package com.revature.menus;

public class AdminMenu {

	public static void display() {
		AdminLoginMenu.display();
		System.out.println("1. Check Customer List");
		System.out.println("2. Transactions Log");
		System.out.println("3. View pending Customers");
		System.out.println("4. View pending Accounts");
		System.out.println("5. Delete a Customer");
		System.out.println("6. Delete a Customer's Account");
		System.out.println("7. Show Application Log File");
		System.out.println("8. Exit");  
		System.out.println("Choose an option:");
	}
}
