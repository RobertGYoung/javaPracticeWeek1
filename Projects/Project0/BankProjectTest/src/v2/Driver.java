package v2;
import java.sql.*;

public class Driver {
	public static void main(String[] args) {
		Query connectedDB = new Query("jdbc:mysql://localhost:3306/bankdbv2","root","root");
	/**
	 * SYSTEM METHODS
	 * 		
	 * TODO:
	 * 	should call all approved accounts and, instantiate to objects, add details and add to a list to be worked with internally
	 * 		this will allow for checks to be made for existing name when registering
	 * 		this will allow access to balances for transactions
	 * 
	 *
	 * 
	 * create and write rollback log files for every transaction made- add admin method to read those files. include customer id, account id and date 
	 
	 */	
//		connectedDB.addAllCustomersToWorkableList();
//		for(int i=0;i<Account.customerList.size();i++) {
//		System.out.println(Account.customerList.get(i).getUserName());
//		System.out.println(Account.customerList.get(i).getCustomerId());
		
/**
 * USER METHODS
 */
		connectedDB.showTransactionTable();
		//connectedDB.hasAccount("testAccount");
		//connectedDB.insertToCustomerTable("testAccount4", "passWord");  //register customer
		//connectedDB.insertToAccountTable(1, "Saving");				//apply for account
	//	connectedDB.insertToAccountTable("vswalker", "Saving");
/**
 * ADMIN METHODS		
 */		
	//	connectedDB.sendToAnotherAccount("yoyo", 11, 2, 9);
	//	connectedDB.withdrawFromUserAccountBalance("testAccount",2,5.00);
	//	connectedDB.depositToUserAccountBalance("testAccount",2 , 10.00);
//		connectedDB.deleteCustomer(4);      //admin
//		connectedDB.deleteAccount(4);
//		connectedDB.deleteCustomer(testAccount4);//admin
//		connectedDB.approveCustomerTable(1, true);//admin
//		connectedDB.approveAccountTable(2, true);//admin
//		connectedDB.searchCustomerTable("testAccount");//admin
//		connectedDB.searchCustomerTable(1);//admin

	//	connectedDB.showConnectedCustomerTable();//admin
	//	connectedDB.showConnectedAccountTable();//admin
//		connectedDB.showPendingCustomers();//admin
	
	//connectedDB.showApprovedAccounts();
	//	connectedDB.showPendingAccounts();
	
;	 }
	
}
	

