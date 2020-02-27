package com.revature.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.connection.DatabaseConnection;
import com.revature.queries.AccountQuery;
import com.revature.queries.CustomerQuery;
import com.revature.scanner.SingleScanner;
import com.revature.users.Account;
import com.revature.users.CustomerUser;

public class UserLogic implements Logic{
static Scanner input = SingleScanner.getInput();
public static List<CustomerUser> customerList = new ArrayList<CustomerUser>();

public static void showUserInfo(String userName) {

			try {
				ArrayList<CustomerUser> resultList= CustomerQuery.selectFromCustomerTable("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true");
				int _customerId=0;
				for(CustomerUser cust: resultList) {
					System.out.println("ID:"+cust.getId()+"\nUserName:"+cust.getUserName()+"\nApproved:"+cust.getIsApproved());
					_customerId=cust.getCustomerId();
				}
				ArrayList<Account> resultList2= AccountQuery.selectFromAccountTable("SELECT * FROM accounts WHERE customerId = "+_customerId+";");
				System.out.println("****ASSOCIATED ACCOUNTS");
				for(Account account : resultList2) {
				System.out.println("Customer ID:"+account.getCustomerId()+"\nAccount Number:"+account.getAccountId()+"\nType: "+account.getAccountType()+"\nBalance:"+account.getBalance()+"\nApproved:"+account.getIsApproved());
				 System.out.println("------------------------");
				}
			}
				catch(Exception e){
					System.out.println("Something went wrong on our end!- sorry for the inconvenience");
			
				}
			}
public static boolean hasAccount(String userName) {
	boolean hasAccount=true;

			ArrayList<CustomerUser> selectedList;
			selectedList= (ArrayList<CustomerUser>)CustomerQuery.selectFromCustomerTable("SELECT * FROM customers WHERE username ='"+userName+"' AND isApproved=true");
			
		int _customerId=0;
				for(CustomerUser cust : selectedList) {
					_customerId=cust.getCustomerId();
					
				}
				ArrayList<Account> selectedList2 = AccountQuery.selectFromAccountTable("SELECT * FROM accounts WHERE customerId = "+_customerId+" AND isApproved=true");
				int count = 0;
				for(CustomerUser cust : selectedList2) {
					count++;
					}	
				if(count>0) {
					hasAccount = true;
				}
					else {System.out.println("You do not have any approved accounts associated with your profile.");
					System.out.println("Press [0] to continue");
					input.next();
								hasAccount=false;}
		
						return hasAccount;
			}

	
public static boolean checkPresence(String userName) {
		int containCtr=0;
		for(CustomerUser customer : customerList) {
			if(customer.getUserName().equals(userName)) {
				containCtr++;
				}
			}
			if(containCtr==0) {
				return false;
			}
			else {
				return true;
			}
	}
	
	public static void addAllCustomersToWorkableList() {
		try {
			Connection myConn = DatabaseConnection.getInstance().getConnection();
			PreparedStatement prepareStatement = myConn.prepareStatement("SELECT * FROM customers");
			ResultSet myResult = prepareStatement.executeQuery();
			while(myResult.next()) {
				customerList.add(new CustomerUser(myResult.getInt("id"),myResult.getBoolean("isApproved"), myResult.getString("username")));
				}
			}
			catch(Exception e){
				System.out.println("Something went wrong on our end!- sorry for the inconvenience");
			}
		}
	public void logic() {
				// TODO Auto-generated method stub
				
			}
	public static boolean checkApproval(String userName) {
				int count=0;
				boolean approved=false;
				for(CustomerUser each: CustomerQuery.selectFromCustomerTable("SELECT * FROM customers WHERE username ='"+userName+"' AND isApproved=true")) {
					count++;
				}
				if(count>0) {
					approved = true;
				}
				return approved;
			}
	public static void depositToUserAccountBalance(String userName) {
				System.out.println("How much are you depositing?");
					double amount =Double.parseDouble(input.next());
				System.out.println("Account Number:   ");
					int accountId = Integer.parseInt(input.next());
					System.out.println("Processing...");
				int _customerId=0;
				for(CustomerUser each: CustomerQuery.selectFromCustomerTable("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true")) {
					_customerId=each.getCustomerId();
				}
				boolean count =CustomerQuery.updateTable("UPDATE accounts SET balance = balance +"+amount+" WHERE accountId = '"+accountId+"' AND isApproved = true");
				if(count==false) {
					System.out.println("transaction failed");
				}
				for(Account each : AccountQuery.selectFromAccountTable("SELECT * FROM accounts WHERE customerId = "+_customerId+" AND accountId='"+accountId+"' AND isApproved=true;")) {
					System.out.println("********Balance********");
					System.out.println("Account Number:"+each.getAccountId()+" balance is now: "+each.getBalance()+" after deposit of: "+amount);
				}
			}
	public static void withdrawToUserAccountBalance(String userName) {
		System.out.println("How much are you withdrawing?");
		double amount =Double.parseDouble(input.next());
	System.out.println("Account Number:   ");
		int accountId = Integer.parseInt(input.next());
		System.out.println("Processing...");
		int _customerId=0;
		for(CustomerUser each: CustomerQuery.selectFromCustomerTable("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true")) {
			_customerId=each.getCustomerId();
		}
		boolean count =CustomerQuery.updateTable("UPDATE accounts SET balance = balance -"+amount+" WHERE accountId = '"+accountId+"' AND isApproved = true AND (balance-"+amount+">=0)");
		if(count==false) {
			System.out.println("transaction failed");
		}
	}
	public static void searchUser(String searchEntry) {
		//TODO
	}
	public static void transferToAnotherAccount(String userName) {
		
			CustomerQuery.checkUserAccountBalance(userName);

			System.out.println("Which of your account(s) are you transfering from? Enter Account Number:");
				int accountId1=Integer.parseInt(input.next());
			System.out.println("How much would you like to transfer?");
				double amount=Double.parseDouble(input.next());
			System.out.println("Enter Account Number you wish to send funds to: ");
				int accountId2=Integer.parseInt(input.next());
			System.out.println("You are sending "+amount+" from Account#: "+accountId1+" to Account#: "+accountId2);
			System.out.println("Do you wish to continue? Funds cannot be recoverd [y/n]");
				String confirmation=input.next();
		if(amount>0&&confirmation.equalsIgnoreCase("y")) {
			int _customerId=0;
			for(CustomerUser each: CustomerQuery.selectFromCustomerTable("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true")){
				_customerId = each.getCustomerId();
			}
			boolean count2=false;
			boolean count1 =CustomerQuery.updateTable("UPDATE accounts SET balance = balance -"+amount+" WHERE accountId = '"+accountId1+"' AND isApproved = true AND (balance-"+amount+">=0)");
			if(count1==true) {
				count2=CustomerQuery.updateTable("UPDATE accounts SET balance = balance +"+amount+" WHERE accountId = '"+accountId2+"' AND isApproved = true");
			}
			if(count2==false) {
				CustomerQuery.updateTable("UPDATE accounts SET balance = balance +"+amount+" WHERE accountId = '"+accountId1+"' AND isApproved = true");
			}
			if(count1==false||count2==false) {
				System.out.println("Transfer Failed");
			}
			else {
				System.out.println("Transfer Successful");
				
			}
	}
	}
}
