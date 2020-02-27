package com.revature.queries;

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
import com.revature.scanner.SingleScanner;
import com.revature.users.Account;
import com.revature.queries.AccountQuery;

import com.revature.users.CustomerUser;

public class CustomerQuery {
	public static void checkUserAccountBalance(String userName) {
		int _customerId=0;

		for(CustomerUser each : CustomerQuery.selectFromCustomerTable("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true")){
			_customerId=each.getCustomerId();
		}
		for(Account each : AccountQuery.selectFromAccountTable("SELECT * FROM accounts WHERE customerId = "+_customerId+" AND isApproved=true")){
			System.out.println("Account Number:"+each.getAccountId()+"\nBalance:"+each.getBalance());
			 System.out.println("------------------------");
		}
	}
	
	public boolean deleteFromTable(String deleteQuery) {
		try {
		Connection myConn = DatabaseConnection.getInstance().getConnection();
		Statement deleteStatement = myConn.createStatement();
		
		 int count = deleteStatement.executeUpdate(deleteQuery);
		 if(count<1) {
			 return false;
		 }
		}catch(SQLException e) {
		e.printStackTrace();
	}
		return true;

	}

	public static ArrayList<CustomerUser> selectFromCustomerTable(String query) {  // gives a list to work with
	
		
		ArrayList<CustomerUser> selectedCustomerList = new ArrayList<CustomerUser>();
		try {
		Connection myConn = DatabaseConnection.getInstance().getConnection();
		Statement connectStatement = myConn.createStatement();
		ResultSet myResultCustomer = connectStatement.executeQuery(query);
		while(myResultCustomer.next()) {
			CustomerUser customer = new CustomerUser(myResultCustomer.getInt("id"),myResultCustomer.getBoolean("isApproved"),myResultCustomer.getString("username"));
			
			selectedCustomerList.add(customer);
		}
	

		}
		catch(SQLException e) {
			e.printStackTrace();
		
		}
		return selectedCustomerList;
	}

	
	
	
	
	public static boolean insertToTable(String insertQuery) {
	
				try {
					Connection myConn =DatabaseConnection.getInstance().getConnection();
					Statement insertStatement = myConn.createStatement();
					int count = insertStatement.executeUpdate(insertQuery);
				if(count<1) {
					return false;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				
			}return true;
			}
		

	public static boolean updateTable(String updateQuery) {
		// TODO Auto-generated method stub
		try {
			Connection myConn = DatabaseConnection.getInstance().getConnection();
			Statement updateStatement = myConn.createStatement();
			 int count = updateStatement.executeUpdate(updateQuery);
			 if(count<1) {
				 return false;
			 }
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return true;
			}
		
		}
