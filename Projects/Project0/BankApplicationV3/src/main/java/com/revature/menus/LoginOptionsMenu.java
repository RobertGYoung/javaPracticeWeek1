package com.revature.menus;

import java.util.Scanner;

import com.revature.scanner.SingleScanner;

public class LoginOptionsMenu extends Menu {
	static Scanner input = SingleScanner.getInput();

	public LoginOptionsMenu() {
	}
	
	
	public static void display() {
		WelcomeMenu.display();

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		System.out.println("Welcome to the Customer Banking Application Portal");
		System.out.println("===================================================");
		System.out.println("[1]Login  |  [2]Register");
	
	}
	
}

