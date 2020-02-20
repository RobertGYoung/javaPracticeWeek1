package v2;
import java.sql.*;

public final class Query {

	private String connectionURL;
	private String connectionUser;
	private String connectionPass;
	
	public String getConnectionURL() {
		return connectionURL;
	}

	public void setConnectionURL(String connectionURL) {
		this.connectionURL = connectionURL;
	}

	public String getConnectionUser() {
		return connectionUser;
	}

	public void setConnectionUser(String connectionUser) {
		this.connectionUser = connectionUser;
	}

	public String getConnectionPass() {
		return connectionPass;
	}

	public void setConnectionPass(String connectionPass) {
		this.connectionPass = connectionPass;
	}

	public Query(String url, String user, String pass) {
		this.setConnectionURL(url);
		this.setConnectionUser(user);
		this.setConnectionPass(pass);
	}
/**
 * TODO: make withdraw method and send method and a pending transactions 
 * @param userName
 * @param accountId
 * @param amount
 * 
 */
//	public boolean hasNoAccount(String userName) {
//		boolean hasNoAccount=true;
//		try {
//			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
//			Statement connectStatement = myConn.createStatement();
//			ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true");
//			int _customerId=0;
//		
//			while(myResultCustomer.next()) {
//			 _customerId= myResultCustomer.getInt("id");
//				}
//			
//			
//		}
//			catch(SQLException e) {
//					e.printStackTrace();
//				}
//		return hasNoAccount;
//		
//	}
	
	public void sendToAnotherAccount(String userName, int accountId1, int accountId2, double amount) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true");
			int _customerId=0;
		
			while(myResultCustomer.next()) {
			 _customerId= myResultCustomer.getInt("id");
				}
			Statement withdrawStatement = myConn.createStatement();
			String sql = "UPDATE accounts "+
					"SET balance = balance -"+amount+" WHERE accountId = '"+accountId1+"' AND isApproved = true AND customerId='"+_customerId+"' AND (balance-"+amount+">=0)";
			
			int count =withdrawStatement.executeUpdate(sql);//returns 1 if executed
			ResultSet myResultAccounts = connectStatement.executeQuery("SELECT * FROM accounts WHERE customerId = "+_customerId+" AND accountId='"+accountId1+"' AND isApproved=true;");

			while(myResultAccounts.next()) {
				System.out.println("********Balance********");
				System.out.println("Balance after transfer is: "+(myResultAccounts.getInt("balance")));
				//System.out.println("*Note this reflection is incorrect if you chose an unapproved account!");
				
				if(count>0) { 
		
			Statement depositStatement = myConn.createStatement();
			String sql1 = "UPDATE accounts "+
					"SET balance = balance +"+amount+" WHERE accountId = '"+accountId2+"' AND isApproved = true";
			depositStatement.executeUpdate(sql1);		
			System.out.println("Transfer Processed: $"+amount+" sent to Account Number: "+accountId2);
				}
				else {
					System.out.println("transfer unsuccessful-not enough funds");
				}
			}	myConn.close();
		}
			catch(Exception e){
				System.out.println("Deposit Failed - account not associated with your account or has yet to be approved");
			}
	}
	
	
	
	
	public void withdrawFromUserAccountBalance(String userName, int accountId, double amount) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true");
			int _customerId=0;
		
			while(myResultCustomer.next()) {
			 _customerId= myResultCustomer.getInt("id");
				}
			Statement depositStatement = myConn.createStatement();
			String sql = "UPDATE accounts "+
					"SET balance = balance -"+amount+" WHERE accountId = '"+accountId+"' AND isApproved = true AND (balance-"+amount+">=0)";
			
			depositStatement.executeUpdate(sql);
			ResultSet myResultAccounts = connectStatement.executeQuery("SELECT * FROM accounts WHERE customerId = "+_customerId+" AND accountId='"+accountId+"' AND isApproved=true;");


		
			while(myResultAccounts.next()) {
				System.out.println("********Balance********");
				System.out.println("Balance after withdrawal is: "+(myResultAccounts.getInt("balance")));
				//System.out.println("*Note this reflection is incorrect if you chose an unapproved account!");
				
				
				}myConn.close();
		}
	
			catch(Exception e){
				System.out.println("Deposit Failed - account not associated with your account or has yet to be approved");
			}
	}
	
	public void depositToUserAccountBalance(String userName, int accountId, double amount) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true");
			int _customerId=0;
		
			while(myResultCustomer.next()) {
			 _customerId= myResultCustomer.getInt("id");
				}
			Statement depositStatement = myConn.createStatement();
			String sql = "UPDATE accounts "+
					"SET balance = balance +"+amount+" WHERE accountId = '"+accountId+"' AND isApproved = true";
			depositStatement.executeUpdate(sql);
			
			
	
			ResultSet myResultAccounts = connectStatement.executeQuery("SELECT * FROM accounts WHERE customerId = "+_customerId+" AND accountId='"+accountId+"' AND isApproved=true;");
			
			while(myResultAccounts.next()) {
				System.out.println("********Balance********");
				System.out.println("Account Number:"+myResultAccounts.getString(accountId)+" balance is now: "+
				myResultAccounts.getString("balance")+" after deposit of: "+amount);
				//System.out.println("*Note this reflection is incorrect if you chose an unapproved account!");
				
				
				}myConn.close();
		}
	
			catch(Exception e){
				System.out.println("Deposit Failed - account not associated with your account or has yet to be approved");
			}
	}
	public void checkUserAccountBalance(String userName) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true");

			int _customerId=0;

			System.out.println("********Balance********");
			while(myResultCustomer.next()) {
		
			 _customerId= myResultCustomer.getInt("id");
				}
			
	
			ResultSet myResultAccounts = connectStatement.executeQuery("SELECT * FROM accounts WHERE customerId = "+_customerId+" AND isApproved=true ;");
		
			while(myResultAccounts.next()) {
				System.out.println("Account Number:"+myResultAccounts.getString("accountId")+"\nBalance:"+myResultAccounts.getString("balance"));
				 System.out.println("------------------------");

				}myConn.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	public void showUserInfo(String userName) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true");

			int _customerId=0;

			System.out.println("********CUSTOMER SUMMARY********");
			while(myResultCustomer.next()) {
			System.out.println("ID:"+myResultCustomer.getString("id")+"\nUserName:"+myResultCustomer.getString("username")+"\nApproved:"+myResultCustomer.getBoolean("isApproved"));
			//System.out.println(myResult.getString("username"));
			 _customerId= myResultCustomer.getInt("id");
			 System.out.println("------------------------");
			}
			
	
			ResultSet myResultAccounts = connectStatement.executeQuery("SELECT * FROM accounts WHERE customerId = "+_customerId+";");
			System.out.println("****ASSOCIATED ACCOUNTS");
			while(myResultAccounts.next()) {
				System.out.println("Customer ID:"+myResultAccounts.getString("customerId")+"\nAccount Number:"+myResultAccounts.getString("accountId")+"\nType: "+myResultAccounts.getString("accountType")+"\nBalance:"+myResultAccounts.getString("balance")+"\nApproved:"+myResultAccounts.getBoolean("isApproved"));
				 System.out.println("------------------------");

				}myConn.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	public void addAllCustomersToWorkableList() {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResult = connectStatement.executeQuery("SELECT * FROM customers");
			while(myResult.next()) {
		//	System.out.println("ID:"+myResult.getString("id")+"\nUserName:"+myResult.getString("username")+"\nPassWord:"+myResult.getString("password")+"\nApproved:"+myResult.getBoolean("isApproved"));
			//System.out.println(myResult.getString("username"));
				
				Account.customerList.add(new CustomerAccount(myResult.getString("username")));
				Account.customerList.get(Account.customerList.size()-1).setName(myResult.getString("username"));
				Account.customerList.get(Account.customerList.size()-1).setApproved(myResult.getBoolean("isApproved"));
				Account.customerList.get(Account.customerList.size()-1).setCustomerId(myResult.getInt("id"));
			}
			myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}
	public void deleteCustomer(String userName) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement deleteStatement = myConn.createStatement();
			   
		    String sql = "DELETE FROM customers WHERE username ='" +userName+"'";
		              
		    deleteStatement.executeUpdate(sql);
		    System.out.println("Customer Deleted!");
		    myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}
	public void deleteCustomer(int id) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement deleteStatement = myConn.createStatement();
			   
		    String sql = "DELETE FROM customers WHERE id ='" +id+"'";
		              
		    deleteStatement.executeUpdate(sql);
		    System.out.println("Customer #:"+id+ " --Deleted!");
		    myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}
	public void deleteAccount(int accountId) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement deleteStatement = myConn.createStatement();
			   
		    String sql = "DELETE FROM accounts WHERE accountId ='" +accountId+"'";
		              
		    deleteStatement.executeUpdate(sql);
		    System.out.println("Account #:"+accountId+"--- Deleted!");
		    myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}
	
	public boolean insertToCustomerTable(String userName) { //applying for customer [default false]
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement insertStatement = myConn.createStatement();
			   
	    String sql = "INSERT INTO customers ( username)" +
	                 "VALUES ('"+userName+"')";
		    String sql2 = "SELECT * FROM customers WHERE username ='"+userName+"'";
		    insertStatement.executeUpdate(sql);
		   ResultSet userInfo= insertStatement.executeQuery(sql2);
		   while(userInfo.next()) {
		    System.out.println("Account Registered! Your Customer ID is: "+userInfo.getString("id"));
	
		   }myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
				return true;
			}
		return false;
	}
	public void insertToAccountTable(int customerId, String accountType) { //applying for account [default balance 0, default aproval false]
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement insertStatement = myConn.createStatement();
			   
		    String sql = "INSERT INTO accounts(customerId, accountType)" +
		                 "VALUES ('"+customerId+"', '"+accountType+"')";
		    insertStatement.executeUpdate(sql);
		    System.out.println("You have applied for a(n): "+accountType+" Account- please wait for approval, check again soon");
		    myConn.close();
		    }
			catch(Exception e){
				e.printStackTrace();
			}
	}
	public void insertToAccountTable(String userName, String accountType) { //applying for account [default balance 0, default aproval false]
		try {
		Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
		Statement connectStatement = myConn.createStatement();
		ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE username LIKE '"+userName+"' AND isApproved=true");
		int _customerId=0;
	
		while(myResultCustomer.next()) {
		 _customerId= myResultCustomer.getInt("id");
			}
		
			Statement insertStatement = myConn.createStatement();
			   
		    String sql = "INSERT INTO accounts(customerId, accountType)" +
		                 "VALUES ('"+_customerId+"', '"+accountType+"')";
		    insertStatement.executeUpdate(sql);
		    System.out.println("You have applied for a(n): "+accountType+" Account- please wait for approval, check again soon");
		    myConn.close();
		    }
			catch(Exception e){
				e.printStackTrace();
			}
	}


 
	public void approveCustomerTable( int id, boolean isApproved) { //for admin use
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement updateStatement = myConn.createStatement();
			   
//		    String sql = "UPDATE customer SET isApproved = "+isApproved +
//		                 " WHERE id ='"+id+"'";
			String sql = "UPDATE customers "+
							"SET isApproved = "+isApproved+" WHERE id = '"+id+"'";
			
		    updateStatement.executeUpdate(sql);
		    System.out.println("updated");
		    myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	public void approveAccountTable( int id, boolean isApproved) { //for admin use
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement updateStatement = myConn.createStatement();
			   
//		    String sql = "UPDATE customer SET isApproved = "+isApproved +
//		                 " WHERE id ='"+id+"'";
			String sql = "UPDATE accounts "+
							"SET isApproved = "+isApproved+" WHERE accountId = '"+id+"'";
			
		    updateStatement.executeUpdate(sql);
		    System.out.println("updated");
		    myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
/**
 * 
 * @param userName
 * used to search by user name and shows customer and all associated accounts and values
 * 
 */
	public boolean checkApproval( String userName) {
		boolean isApproved=false;
		try {
			
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE username = '"+userName+"'");

			while(myResultCustomer.next()) {
				
				 isApproved= myResultCustomer.getBoolean("isApproved");
				 return isApproved;
				}myConn.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isApproved;
	}
	public void searchCustomerTable(String userName) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE username LIKE '"+userName+"'");

			int _customerId=0;

			System.out.println("****CUSTOMER(s) FOUND****");
			while(myResultCustomer.next()) {
			System.out.println("ID:"+myResultCustomer.getString("id")+"\nUserName:"+myResultCustomer.getString("username")+"\nApproved:"+myResultCustomer.getBoolean("isApproved"));
			//System.out.println(myResult.getString("username"));
			 _customerId= myResultCustomer.getInt("id");
			 System.out.println("------------------------");
			}
			
	
			ResultSet myResultAccounts = connectStatement.executeQuery("SELECT * FROM accounts WHERE customerId = "+_customerId+";");
			System.out.println("****ASSOCIATED ACCOUNTS");
			while(myResultAccounts.next()) {
				System.out.println("Customer ID:"+myResultAccounts.getString("customerId")+"\nAccount Number:"+myResultAccounts.getString("accountId")+"\nType: "+myResultAccounts.getString("accountType")+"\nBalance:"+myResultAccounts.getString("balance")+"\nApproved:"+myResultAccounts.getBoolean("isApproved"));
				 System.out.println("------------------------");

				}myConn.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	public void searchCustomerTable(int id) {
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResultCustomer = connectStatement.executeQuery("SELECT * FROM customers WHERE id = "+id+";");
			int _customerId=0;

			System.out.println("****CUSTOMER(s) FOUND****");
			while(myResultCustomer.next()) {
			System.out.println("ID:"+myResultCustomer.getString("id")+"\nUserName:"+myResultCustomer.getString("username")+"\nApproved:"+myResultCustomer.getBoolean("isApproved"));
			 _customerId= myResultCustomer.getInt("id");
			 System.out.println("------------------------");
			}
			
			
			ResultSet myResultAccounts = connectStatement.executeQuery("SELECT * FROM accounts WHERE customerId = "+id+";");
			System.out.println("****ASSOCIATED ACCOUNTS");
		
			while(myResultAccounts.next()) {
				System.out.println("Customer ID:"+myResultAccounts.getString("customerId")+"\nAccount Number:"+myResultAccounts.getString("accountId")+"\nType: "+myResultAccounts.getString("accountType")+"\nBalance:"+myResultAccounts.getString("balance")+"\nApproved:"+myResultAccounts.getBoolean("isApproved"));
				 System.out.println("------------------------");

				}myConn.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	public void showConnectedCustomerTable() {
		System.out.println("************************CUSTOMERS********************");
		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResult = connectStatement.executeQuery("SELECT * FROM customers");
			while(myResult.next()) {
			System.out.println("ID:"+myResult.getString("id")+"\nUserName:"+myResult.getString("username")+"\nApproved:"+myResult.getBoolean("isApproved"));
			//System.out.println(myResult.getString("username"));
			}
			myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}//end showConnectedDBtable
	public void showConnectedAccountTable() {
		System.out.println("************************ACCOUNTS********************");

		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResult = connectStatement.executeQuery("SELECT * FROM accounts");
			while(myResult.next()) {
			System.out.println("Customer ID:"+myResult.getString("customerId")+"\nAccount Number:"+myResult.getString("accountId")+"\nType: "+myResult.getString("accountType")+"\nBalance:"+myResult.getString("balance")+"\nApproved:"+myResult.getBoolean("isApproved"));
			//System.out.println(myResult.getString("username"));
			}
			myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	public void showPendingAccounts() {
		System.out.println("************************PENDING ACCOUNTS********************");

		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResult = connectStatement.executeQuery("SELECT * FROM accounts WHERE isApproved = false");
			while(myResult.next()) {
			System.out.println("Customer ID:"+myResult.getString("customerId")+"\nAccount Number:"+myResult.getString("accountId")+"\nType: "+myResult.getString("accountType")+"\nBalance:"+myResult.getString("balance")+"\nApproved:"+myResult.getBoolean("isApproved"));
			//System.out.println(myResult.getString("username"));
			}
			myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	public void showApprovedAccounts() {
		System.out.println("************************APPROVED ACCOUNTS********************");

		try {
			Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
			Statement connectStatement = myConn.createStatement();
			ResultSet myResult = connectStatement.executeQuery("SELECT * FROM accounts WHERE isApproved = true");
			while(myResult.next()) {
			System.out.println("Customer ID:"+myResult.getString("customerId")+"\nAccount Number:"+myResult.getString("accountId")+"\nType: "+myResult.getString("accountType")+"\nBalance:"+myResult.getString("balance")+"\nApproved:"+myResult.getBoolean("isApproved"));
			//System.out.println(myResult.getString("username"));
			}
			myConn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
		public void showPendingCustomers() {
			System.out.println("************************PENDING CUSTOMERS********************");
			try {
				Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
				Statement connectStatement = myConn.createStatement();
				ResultSet myResult = connectStatement.executeQuery("SELECT * FROM customers WHERE isApproved = false");
				while(myResult.next()) {
				System.out.println("ID:"+myResult.getString("id")+"\nUserName:"+myResult.getString("username")+"\nApproved:"+myResult.getBoolean("isApproved"));
				//System.out.println(myResult.getString("username"));
				}
				myConn.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
	}
		public void showApprovedCustomers() {
			System.out.println("************************APPROVED CUSTOMERS********************");
			try {
				Connection myConn = DriverManager.getConnection( getConnectionURL(), getConnectionPass(),getConnectionPass());
				Statement connectStatement = myConn.createStatement();
				ResultSet myResult = connectStatement.executeQuery("SELECT * FROM customers WHERE isApproved = true");
				while(myResult.next()) {
				System.out.println("ID:"+myResult.getString("id")+"\nUserName:"+myResult.getString("username")+"\nApproved:"+myResult.getBoolean("isApproved"));
				//System.out.println(myResult.getString("username"));
				}
				myConn.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
	
		}
}

