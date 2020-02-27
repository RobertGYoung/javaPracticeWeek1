package v2;
import java.util.Scanner;
import org.apache.logging.slf4j.Log4jLogger;
public class UserPortal extends Account {

	static void openCustomerPortal() throws InterruptedException {
		Query connectedDB = new Query("jdbc:mysql://localhost:3306/bankdbv2","root","root");
		
		String userName = "";
		int accountNumber=0;
		double amount=0.0;
		int option = 0;
		int menuOption=0;
		boolean userError = false;	
		Scanner input = new Scanner(System.in);
		int accountType=0;
		
		//only for entry user experience will this amazing ui constructs appear- they clutter code
		//so were not used past the point of the approval process
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		System.out.println("Welcome to the Customer Banking Application Portal");
		System.out.println("===================================================\n");
		System.out.print("Loading");													//seriously- its loading
		for(int i=0;i<15;i++) {
			Thread.sleep(55);System.out.print(".");
		}

		for(int i=0;i<5;i++) {
			Thread.sleep(300);System.out.print(".");
		}
		for(int i=0;i<15;i++) {
			Thread.sleep(100);System.out.print(".");
		}
		for(int i=0;i<8;i++) {
			Thread.sleep(55);System.out.print(".");
		}

	
		connectedDB.addAllCustomersToWorkableList(); // for some reason I added the whole customer table to list to
													//check for existence rather than the actual table- just go with it
													//my grandfather always said: if it aint broken dont fix it
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		System.out.println("Welcome to the Customer Banking Application Portal");
		System.out.println("===================================================");

		do {//careful there are nested for loops here... idk sorry		
			
					userError = false;
					try {
						System.out.println("[1]Login  |  [2]Register");
							option = Integer.parseInt(input.next());
						
					
						} catch (NumberFormatException e) {
							System.out.println("Invalid input EXCEPTION");
		
							userError = true;
							break;
						}
					if (option == 0 || option > 2) {
						System.out.println("Invalid input");
						userError = true;
						break;
					}
else {// if they didnt mess up the first time

switch(option) {	//switch for login vs register
		case 1:
			int containCtr=0;//used to iterate through list made to check if user name exists or not
				userError=false;
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

				System.out.println("Welcome to the Customer Banking Application Portal");
				System.out.println("===================================================");
				System.out.println("Enter a username:");
				userName = input.next();
				
			for(CustomerAccount customer : customerList) {
				if(customer.getUserName().equals(userName)) {
					containCtr++;
					}
				}
			if(containCtr==0) { 		//if there is not existing user name
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

				System.out.println("Welcome to the Customer Banking Application Portal");
				System.out.println("===================================================");
				System.out.println("You need to register");
				//userError=true;
				userError=true;
				break;
				}
			break;
		case 2: //register for account - add to database 	
				do {
					userError=false;
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

					System.out.println("Welcome to the Customer Banking Application Portal");
					System.out.println("===================================================");
					System.out.println("Enter a user name to get started:");
					userName = input.next();
				
		 containCtr=0;
				for(int i = 0;i<customerList.size();i++) {
						if(customerList.get(i).getUserName().equals(userName)) {
							containCtr++;	
						}
					}
				if(containCtr>0) {
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

					System.out.println("Welcome to the Customer Banking Application Portal");
					System.out.println("===================================================");
					System.out.println("Username exists, use Login option instead---- back to main menu");
					userError=true;
					break;
					}
				else {
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

					System.out.println("Welcome to the Customer Banking Application Portal");
					System.out.println("===================================================");
					System.out.println("Please wait for account approval; you will soon become a part of our valued customers");
					userError=connectedDB.insertToCustomerTable(userName);// returns boolean, and disallows duplicate username
					System.out.println("Press [0] key to continue...");
					input.next();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

				}
			}while(userError);
				
				break;   // finished 
				default:
				}//end login/register switch
			}//end else
	} while (userError);
		
		

		
		if(connectedDB.checkApproval(userName)) {
		
			System.out.println("********************WELCOME "+userName+"************");
			
			if(connectedDB.hasAccount(userName)==false) {
				menuOption=0;
				while(menuOption!=2) {
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("********************WELCOME "+userName+"************");

				System.out.println("1. Apply for a new account");
				System.out.println("2. Exit");
				System.out.println("Choose an option");
				menuOption=Integer.parseInt(input.next());
				if(menuOption==1) {
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					
					System.out.println("1.Checking");
					System.out.println("2.Saving");
					System.out.println("Which account would you like to apply for?");
					accountType=Integer.parseInt(input.next());
					if(accountType==1) {
						connectedDB.insertToAccountTable(userName, "Checking");
						menuOption=2;
						break;
					}
					else if(accountType==2) {
						connectedDB.insertToAccountTable(userName, "Saving");
						menuOption=2;
						break;
					}
					else {
						System.out.println("Something went wrong");
						break;
					
					}
			}
				else {
					menuOption=2;
				}
			}
			}
			else {
		while (menuOption != 7) {
			

		do {	
			userError = false;
		System.out.println("|  |  |  |  |  |  | MENU |  |  |  |  |  |  |  |");
		System.out.println("1. Apply for a new account");
		System.out.println("2. YOUR SUMMARY");
		System.out.println("3. Check Account Balance");
		System.out.println("4. Make a Deposit");
		System.out.println("5. Make a Withdrawal");
		System.out.println("6. Money Transfer");
		System.out.println("7. Exit");
	
		try {
			System.out.println("Choose an option:");
			menuOption = Integer.parseInt(input.next());
			} catch (NumberFormatException e) {
					System.out.println("Your input was not understood.");
					userError = true;//yup user error 
				}
			} while (userError);

switch (menuOption) {
					case 1:	
							System.out.println("1.Checking");
							System.out.println("2.Saving");
							System.out.println("Which account would you like to apply for?");
							accountType=Integer.parseInt(input.next());
							if(accountType==1) {
								connectedDB.insertToAccountTable(userName, "Checking");
								break;
							}
							else if(accountType==2) {
								connectedDB.insertToAccountTable(userName, "Saving");
								break;
							}
							else {
								System.out.println("Something went wrong");
								userError = true;
								break;
							}
						case 2:
							connectedDB.showUserInfo(userName);
							break;
						case 3: 
							connectedDB.checkUserAccountBalance(userName);
							break;
						case 4:
							
						try {	
								connectedDB.checkUserAccountBalance(userName); //just to show associated accounts

								System.out.println("How much are you depositing?");
		
								amount =Double.parseDouble(input.next());
								System.out.println("Processing...");
							
							} catch (NumberFormatException e) {
								System.out.println("Your input was not understood.");
								userError = true;
								break;
							}	
						try {
								System.out.println("Account Number:   ");
		
								accountNumber = Integer.parseInt(input.next());
								System.out.println("Processing...");
								connectedDB.depositToUserAccountBalance(userName, accountNumber, amount);
								System.out.println("Press [0] to continue...");
								input.next();
								break;
							} catch (NumberFormatException e) {
								
								System.out.println("Your input was not understood.");
								userError = true;
								break;
							}
						
						case 5:
							try {
								connectedDB.checkUserAccountBalance(userName);

								System.out.println("How much are you withdrawing?");
								amount =Double.parseDouble(input.next());
								System.out.println("Processing...");
								} catch (NumberFormatException e) {
									System.out.println("Your input was not understood.");
									userError = true;
								}
							
							try {
								System.out.println("Account Number:");
		
								accountNumber = Integer.parseInt(input.next());
								System.out.println("Processing...");
								connectedDB.withdrawFromUserAccountBalance(userName, accountNumber, amount); //make boolean method
								System.out.println("Press [0] to continue...");
								input.next();
								} catch (NumberFormatException e) {
									System.out.println("Your input was not understood.");
									userError = true;
								}
							
							break;		
						case 6:	System.out.println("*please note- you must know the account number of account you wish to transfer.");
								System.out.println("Which of your account(s) are you transfering from? Enter Account Number:");
								int account1=Integer.parseInt(input.next());
								System.out.println("How much would you like to transfer?");
								amount=Double.parseDouble(input.next());
								System.out.println("Enter Account Number you wish to send funds to: ");
								int account2=Integer.parseInt(input.next());
								System.out.println("You are sending "+amount+" from Account#: "+account1+" to Account#: "+account2);
								System.out.println("Do you wish to continue? Funds cannot be recoverd [y/n]");
								String confirmation=input.next();
								if(amount>0&&confirmation.equalsIgnoreCase("y")) {
									connectedDB.sendToAnotherAccount(userName, account1, account2, amount);
									System.out.println("Press [0] to continue...");
									input.next();
									break;
								}
								else {
									System.out.println("Something went wrong");
									break;
								}
							}//end user option switch
						}
					}//if has account end
				}//if approved end
			else {
				System.out.println("You have yet to be approved-please check later");
			}//if not approved end
			
			input.close();
			System.out.println("BACK TO MAIN MENU");
	}//END USer Experience
		



	public static void openAdminPortal() {
		Query connectedDB = new Query("jdbc:mysql://localhost:3306/bankdbv2","root","root");
		String userName;
		String password="admin";
		String confirmation;
		int option = 0;
		int accountOption;
		double amountInput = 0;
		Scanner input = new Scanner(System.in);
		boolean restart=true;
	
			System.out.println("Welcome to the Admin Banking Application Portal");
			System.out.println("===================================================");
			System.out.println("Password:");
			userName = input.next();
			
		if(!userName.equals(password)) {
			System.out.println("Password is Incorrect");
			}//after the else is the end so it'll loop back after an incorrect password, dont worry
else {//pass word worked
			do {
				restart=false;
				option=0;
	
		while (option != 7) {
			option=0;
			System.out.println("1. Check Customer List");
			System.out.println("2. Transactions Log");
			System.out.println("3. View pending Customers");
			System.out.println("4. View pending Accounts");
			System.out.println("5. Delete a Customer");
			System.out.println("6. Delete a Customer's Account");
			System.out.println("7. Exit");  //exits loop
			//resets option
			System.out.println("Choose an option:");
			option = input.nextInt();

	switch (option) {
			case 1:
				connectedDB.showConnectedCustomerTable();
				System.out.println("Choose Customer Number to see details. [0] to go Back");
				accountOption=Integer.parseInt(input.next());
				if(accountOption!=0) {
					connectedDB.searchCustomerTable(accountOption);
					break;
				}
				else if(accountOption==0) {
					System.out.println("Back to admin menu");
					option=6;
					restart=true;
					break;
				}
				else {
					System.out.println("Something went wrong");
					option=6;
					restart=true;
					break;
				}
			case 2:
				connectedDB.showTransactionTable();

				System.out.println("Press [0] to go Back");
				accountOption=Integer.parseInt(input.next());
				if(accountOption==0) {
					System.out.println("Back to admin menu");
					option=6;
					restart=true;
					break;
				}
				else {
					System.out.println("Something went wrong");
					System.out.println("Back to menu");
					option=6;
					restart=true;
					break;
				}
		
			case 3:
				connectedDB.showPendingCustomers();
				System.out.println("Choose Customer Number to Approve. [0] to go Back");
				accountOption=Integer.parseInt(input.next());
				if(accountOption!=0) {
					connectedDB.approveCustomerTable(accountOption, true);
					restart=true;
					option=6;
					break;
				}
				else {
					System.out.println("Back to menu");
					restart=true;
					option=6;
					break;
				}
			
			case 4: 
				connectedDB.showPendingAccounts();
				System.out.println("Choose Account Number to Approve. [0] to go Back");
				accountOption=Integer.parseInt(input.next());
				if(accountOption!=0) {
					connectedDB.approveAccountTable(accountOption, true);
					break;
				}
				else {
					System.out.println("Something went wrong");
					restart=true;
					option=6;
					break;
				}
			case 5:
				connectedDB.showConnectedCustomerTable();
				System.out.println("Choose Customer Number to Delete.  [0] to go Back");
				accountOption=Integer.parseInt(input.next());
				if(accountOption!=0){
				System.out.println("Are you sure you wish to DELETE Customer #:"+accountOption+"?? [y/n]");
				confirmation=input.next();
				if(accountOption!=0&&confirmation.equalsIgnoreCase("y")) {
					connectedDB.deleteCustomer(accountOption);
					break;
				}
				else {
					System.out.println("Something went wrong");
					break;
				}
				
				}
				
				break;
			case 6:connectedDB.showConnectedAccountTable();
			System.out.println("Choose Account Number to Delete.  [0] to go Back");
			accountOption=Integer.parseInt(input.next());
			System.out.println("Are you sure you wish to DELETE Customer #:"+accountOption+"?? [y/n]");
			confirmation=input.next();
			if(accountOption!=0&&confirmation.equalsIgnoreCase("y")) {
				connectedDB.deleteAccount(accountOption);
				break;
			}
			else {
				System.out.println("Something went wrong");
				break;
			}
			default:

			}
		}
			
			}while(restart);
		
	}
	
	}

}
