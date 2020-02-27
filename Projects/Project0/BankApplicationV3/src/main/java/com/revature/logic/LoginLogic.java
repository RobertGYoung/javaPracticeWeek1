package com.revature.logic;

import java.util.Scanner;

import com.revature.menus.WelcomeMenu;
import com.revature.queries.CustomerQuery;
import com.revature.scanner.SingleScanner;
import com.revature.users.User;

public class LoginLogic extends com.revature.menus.LoginOptionsMenu implements Logic {

	static Scanner input = SingleScanner.getInput();

	public static String logic(int loginOption) {
		String userName;
		if(loginOption==1) {
				WelcomeMenu.display();
				System.out.println("Enter a username:");
					userName = input.nextLine();
					UserLogic.addAllCustomersToWorkableList();  //adds all customers to a list to check presence. 
				if(UserLogic.checkPresence(userName)==false) {
					WelcomeMenu.display();
					System.out.println("You need to register");
					input.nextLine();
					userName=null;
						}		
				else {
					return userName;
				}
				
					}
		else if(loginOption==2) {
					WelcomeMenu.display();
					System.out.println("Enter a user name to get started:");
					userName = input.nextLine();	
				if(UserLogic.checkPresence(userName)==true) {
						System.out.println("Username exists, use Login option instead----");
						System.out.println("Press [0] to go back to main menu");
						input.nextLine();
						userName=null;
					}
				else{
					
					
					if(CustomerQuery.insertToTable("INSERT INTO customers (username) Values ('"+userName+"')")==true) {
					System.out.println("Please wait for account approval; you will soon become a part of our valued customers");
					
					input.nextLine();
					userName=null;
					}else {
						System.out.println("something went wrong");
						userName = null;
					}
				}
			}
		else {
			System.out.println("Something went wrong- back to menu");
			userName=null;
		}
		return userName;
}

	@Override
	public void logic() {
		// TODO Auto-generated method stub
		
	}
	
}
