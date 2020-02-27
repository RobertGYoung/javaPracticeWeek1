package com.revature;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.revature.connection.DatabaseConnection;
import com.revature.logic.AccountApplicationLogic;
import com.revature.logic.AdminLogic;
import com.revature.logic.LoginLogic;
import com.revature.logic.UserLogic;
import com.revature.menus.AccountTypesMenu;
import com.revature.menus.AdminLoginMenu;
import com.revature.menus.AdminMenu;
import com.revature.menus.CustomerMenu;
import com.revature.menus.FirstTimeCustomerMenu;
import com.revature.menus.LoginOptionsMenu;
import com.revature.menus.StartUpMenu;
import com.revature.queries.CustomerQuery;
import com.revature.scanner.SingleScanner;
import com.revature.users.CustomerUser;

import testing.LoggeClass;
import testing.LoggerApp;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * 
 * TODO: Customer: deposit, withdraw, transfer, input validation
 * 		Admin: all
 * @author Rahb
 *
 */ 
public class Main {
	static Scanner input = SingleScanner.getInput();
	static Logger mainLogger = LogManager.getLogger(Main.class);
public static void main(String[] args) throws SQLException {
	
		Connection myConn = DatabaseConnection.getInstance().getConnection();
		mainLogger.trace("Application Started");
		AdminLogic.addPassword();
					while(true) {			String userName;
										boolean userError = false;
										boolean goBack=false;
										String startUpOption;
										int menuOption;
										
									StartUpMenu.display();
									System.out.println("---");
									startUpOption = input.nextLine();
									
							switch (startUpOption) { 
										//1customer 2admin 3axit
								case "1":															//user portal
										do { userError = false;
												LoginOptionsMenu.display();
												int loginOption = Integer.parseInt(input.nextLine());
												 userName= LoginLogic.logic(loginOption);
												if(userName==null) 
													userError=true;
												}while(userError);									//end user validation
										mainLogger.trace("User "+userName+" has logged in");
										do {userError = false;
											goBack=false;
											menuOption=0;
													if(UserLogic.checkApproval(userName)==false) {
														System.out.println("Please wait for application approval; you will soon become a part of our valued customers");
														mainLogger.trace("User "+userName+" is waiting to be approved");

														break;
													}
													else if(UserLogic.hasAccount(userName)==false) {  
												FirstTimeCustomerMenu.display(userName);
												menuOption=Integer.parseInt(input.next());
												goBack=AccountApplicationLogic.applyForAccount(userName);
												mainLogger.trace("User "+userName+" applied for an account and is awaiting approval");

												break;
											}
											else {
														CustomerMenu.display();
														menuOption = Integer.parseInt(input.next());
													while(menuOption!=7) {
														
													switch(menuOption) {
															case 1:
																goBack=AccountApplicationLogic.applyForAccount(userName);
																mainLogger.trace("User "+userName+" exited account application from main menu");

																break;
															
															case 2:
																UserLogic.showUserInfo(userName);
																System.out.println("Press [0] to go back");
																input.next();
																goBack = true;
																break;
															case 3:
																CustomerQuery.checkUserAccountBalance(userName);
																System.out.println("Press [0] to go back");
																input.next();
																mainLogger.trace("User "+userName+" checked thier balance");

																goBack = true;
																break;
															case 4:
																CustomerQuery.checkUserAccountBalance(userName);
																UserLogic.depositToUserAccountBalance(userName);
																System.out.println("Press [0] to go back");
																mainLogger.trace("User "+userName+" possibly made a deposit");

																input.next();
																goBack=true;
																break;
															case 5:
																CustomerQuery.checkUserAccountBalance(userName);
																UserLogic.withdrawToUserAccountBalance(userName);
																System.out.println("Press [0] to go back");
																mainLogger.trace("User "+userName+" possibly made a withdrawal");

																input.next();
																goBack=true;
																break;
															case 6:
																UserLogic.transferToAnotherAccount(userName);
																mainLogger.trace("User "+userName+" possibly sent funds to another account");

																goBack=true;
																break;
																}
													menuOption=7;
													
															}
														}

											}while(goBack);
										mainLogger.trace("User "+userName+" exited thier profile");

											break;
										case "2":
											boolean goBackAdmin=false;
												String option=null;
												AdminLoginMenu.display();
												mainLogger.trace("Someone attempting to log into admin");

												if(AdminLogic.login()) {
													do {
														mainLogger.trace("Admin successfully logged in");

													AdminMenu.display();
													option = input.nextLine();	
													switch(option){
														case "1":
															AdminLogic.showCustomerList();
															System.out.println("Press [0] to go back");
															input.nextLine();
															goBackAdmin=true;
															break;
														case "2":
															AdminLogic.showTransactionLog();
															System.out.println("Press [0] to go back");
															input.nextLine();
															goBackAdmin=true;
															break;
														case "3": 
															AdminLogic.showPendingCustomers();
															System.out.println("Press [0] to go back");
															input.nextLine();
															goBackAdmin=true;
															break;
														case "4": 
															AdminLogic.showPendingAccounts();
															System.out.println("Press [0] to go back");
															input.nextLine();
															goBackAdmin=true;
															break;
														case "5":
															AdminLogic.revokeCustomers();
															mainLogger.trace("admin may have revoked a customer's privaledge");

															System.out.println("Press [0] to go back");
															
															input.nextLine();
															goBackAdmin=true;
															
															break;
														case "6":
															AdminLogic.revokeAccounts();
															mainLogger.trace("admin may have revoked an account privaledge");

															System.out.println("Press [0] to go back");
															input.nextLine();
															goBackAdmin=true;
															break;
														case "7":		//log
															mainLogger.trace("YOUR READING THE LOG BUT YOU PROBABLY ALREADY KNOW THAT");

															try {
															AdminLogic.readFromLog();
															}
															catch(IOException e){
																e.printStackTrace();
															}
															System.out.println("Press [0] to go back");
															input.nextLine();
															goBackAdmin=true;
															break;
														case "8":
															
															goBackAdmin=false;
															break;
													}
												
												}while (goBackAdmin);
													mainLogger.trace("admin logged out");

												}
												
;											break;
										case "3":System.out.println("System powering down");
										mainLogger.trace("Application Terminated");
										myConn.close();
												System.exit(1);
											break;	
								}
System.out.println("Press [0] to go back to Menu");
input.nextLine();
System.out.println("-----");
}
}
}

