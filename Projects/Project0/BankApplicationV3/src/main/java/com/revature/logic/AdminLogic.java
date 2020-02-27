package com.revature.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.connection.DatabaseConnection;
import com.revature.queries.AccountQuery;
import com.revature.queries.CustomerQuery;
import com.revature.scanner.SingleScanner;
import com.revature.users.Account;
import com.revature.users.CustomerUser;

public class AdminLogic {
	static Scanner input = SingleScanner.getInput();
	static private ArrayList<String> passwordList = new ArrayList<String>();
		
	public static void showTransactionLog() {
		System.out.println("************************CUSTOMERS********************");
		try {
		Connection myConn = DatabaseConnection.getInstance().getConnection();
		CallableStatement stmt = myConn.prepareCall("{call showTransactionsTable()}");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			   System.out.println(String.format("%s - %s",
			                      "TID:"+rs.getString("transactionId"),
			                      " \n\tCID" + rs.getString("fromCustomerId")
			                      +" AID:"+ rs.getString("fromAccountId")
			                      +" AMOUNT:"+rs.getString("amount")
			                      +" ADMIN-ACTION:" +rs.getString("approvalOccured")
			                      +" TIME:"+rs.getDate("timeOccured") +" at "+rs.getTime("timeOccured")));
			   System.out.println("--------------------------------------");
			   						
			}
			myConn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
public static void showCustomerList() {
	System.out.println("************************CUSTOMERS********************");
	for(CustomerUser each: CustomerQuery.selectFromCustomerTable("Select * FROM customers")){
		System.out.println("ID:"+each.getCustomerId()+"\nUserName:"+each.getUserName()+"\nApproved:"+each.getIsApproved());
		System.out.println("----------------------|");
	}
	System.out.println("Enter Customer ID for details. Press [0] to go back");

	int details = Integer.parseInt(input.nextLine());
	
	if(details!=0) {
		for(Account each: AccountQuery.selectFromAccountTable("SELECT * FROM accounts WHERE customerId = "+details+";")) {
			System.out.println("AccountID:"+each.getAccountId()+"\nTYPE: "+each.getAccountType()+"\nApproved: "+each.getIsApproved());
			System.out.println("----------------------|");
		}
		
	}
	
	
}
	
public static void addPassword() {
	passwordList.add("admin");
}
	
	
public static boolean login() {
	
	System.out.println("Password:");
	String password = input.nextLine();
	if(passwordList.contains(password)){
		return true;
	}
	return false;
	}
public static void showPendingAccounts() {
	System.out.println("***************PENDING CUSTOMERS****************");
	for(Account each: AccountQuery.selectFromAccountTable("Select * FROM accounts Where isApproved=false")){
		System.out.println("AccountID:"+each.getAccountId()+"\nCustomerID: "+each.getCustomerId()+"\nTYPE: "+each.getAccountType()+"\nApproved: "+each.getIsApproved());
		System.out.println("----------------------|");
	}
		System.out.println("Choose Customer Number to Approve. [0] to go Back");
		
		int accountOption=Integer.parseInt(input.next());
		if(accountOption!=0) {
		boolean count=CustomerQuery.updateTable("UPDATE accounts SET isApproved = true WHERE id="+accountOption+";");
		if(count) {
			System.out.println("Successfully updated");
		}
		else {
			System.out.println("Customer "+accountOption+" not found");
		}
		}
	
}
public static void showPendingCustomers() {
	System.out.println("***************PENDING CUSTOMERS****************");
	for(CustomerUser each: CustomerQuery.selectFromCustomerTable("Select * FROM customers Where isApproved=false")){
		System.out.println("ID:"+each.getCustomerId()+"\nUserName:"+each.getUserName()+"\nApproved:"+each.getIsApproved());
		System.out.println("----------------------|");
	}
		System.out.println("Choose Customer Number to Approve. [0] to go Back");
		int customerOption=Integer.parseInt(input.next());
		if(customerOption!=0) {
		boolean count=CustomerQuery.updateTable("UPDATE customers SET isApproved = true WHERE id="+customerOption+";");
		if(count) {
			System.out.println("Successfully updated");
		}
		else {
			System.out.println("Customer "+customerOption+" not found");
		}
		}
	
}

public static void revokeAccounts() {
	// TODO Auto-generated method stub
	for(Account each: AccountQuery.selectFromAccountTable("Select * FROM accounts Where isApproved=false")){
		System.out.println("AccountID:"+each.getAccountId()+"\nCustomerID: "+each.getCustomerId()+"\nTYPE: "+each.getAccountType()+"\nApproved: "+each.getIsApproved());
		System.out.println("----------------------|");
	}
		System.out.println("Choose Account Number to Revoke. [0] to go Back");
		
		int accountOption=Integer.parseInt(input.next());
		if(accountOption!=0) {
	AccountQuery.updateTable("DELETE FROM accounts WHERE accountId="+accountOption+";" );
	
}
}
public static void revokeCustomers() {
	System.out.println("************************CUSTOMERS********************");
	for(CustomerUser each: CustomerQuery.selectFromCustomerTable("Select * FROM customers")){
		System.out.println("ID:"+each.getCustomerId()+"\nUserName:"+each.getUserName()+"\nApproved:"+each.getIsApproved());
		System.out.println("----------------------|");
	}
	System.out.println("Choose Customer ID to Revoke. [0] to go Back");
	int accountOption=Integer.parseInt(input.next());
	if(accountOption!=0) {
CustomerQuery.updateTable("DELETE FROM accounts WHERE id="+accountOption+";" );
}
}
public static void readFromLog() throws IOException {
	
	
		 FileReader fr= new FileReader("../BankApplicationV3/log/logfile.txt"); 
		  
		    int i; 
		    while ((i=fr.read()) != -1) 
		      System.out.print((char) i);
		    
		    fr.close();
}
}
