package com.revature.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.connection.DatabaseConnection;
import com.revature.users.Account;

public class AccountQuery {
	
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

	public static ArrayList<Account> selectFromAccountTable(String query) {  // gives a list to work with
	
		
		ArrayList<Account> selectedAccountList = new ArrayList<Account>();
		try {
		Connection myConn = DatabaseConnection.getInstance().getConnection();
		Statement connectStatement = myConn.createStatement();
		ResultSet AccountResult = connectStatement.executeQuery(query);
		while(AccountResult.next()) {
			Account account = new Account(AccountResult.getInt("accountId"),AccountResult.getInt("customerId"),AccountResult.getString("accountType"),AccountResult.getDouble("balance"),AccountResult.getBoolean("isApproved"));
			selectedAccountList.add(account);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return selectedAccountList;
	}
}
