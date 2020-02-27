package com.revature.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.connection.DatabaseConnection;
import com.revature.menus.AccountTypesMenu;
import com.revature.queries.AccountQuery;
import com.revature.queries.CustomerQuery;
import com.revature.scanner.SingleScanner;
import com.revature.users.Account;
import com.revature.users.CustomerUser;

public class AccountApplicationLogic extends UserLogic {
	static Scanner input = SingleScanner.getInput();
public static boolean applyForAccount(String userName) {
	boolean goBack = false;
	AccountTypesMenu.display();
	System.out.println("Press [0] to go back");
	int accountType=Integer.parseInt(input.next());
	if(accountType==1) {
		insertToAccountTable(userName, "Checking");
		goBack = true;
		
	}
	else if(accountType==2) {
		insertToAccountTable(userName, "Saving");
		goBack = true;

	}
	else {
		System.out.println("Something went wrong");
		System.out.println("Press [0] to go back");
		input.nextLine();

		goBack = true;
		
	}
	return goBack;
	}
public static void insertToAccountTable(String userName, String accountType) { //applying for account [default balance 0, default aproval false]
	try {
		ArrayList<CustomerUser> newList = CustomerQuery.selectFromCustomerTable("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true");
	
	int _customerId=0;

	for(CustomerUser each: newList) {
	 _customerId= each.getCustomerId();
		}
	
	
	AccountQuery.insertToTable("INSERT INTO accounts (customerId, accountType) VALUES ('"+_customerId+"', '"+accountType+"')");


	    System.out.println("You have applied for a(n): "+accountType+" Account- please wait for approval, check again soon");
	 
	    }
		catch(Exception e){
			System.out.println("Something went wrong on our end!- sorry for the inconvenience");
			e.printStackTrace();
		}
}

}
