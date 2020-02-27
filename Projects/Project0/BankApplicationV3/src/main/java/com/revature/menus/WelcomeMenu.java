package com.revature.menus;

public class WelcomeMenu extends Menu{

	public static void  display() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Welcome to the Customer Banking Application Portal");
		System.out.println("===================================================");
	
	}
	public static void displayUserMenu(String userName) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("********************WELCOME "+userName+"************");
	}
	public static void loading() {
		System.out.print("Loading");		
		
		
		try {
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
		}
		catch(InterruptedException e) {
			e.printStackTrace();
			}
	}
}
