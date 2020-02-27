package v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Rahb
 *
 *THIS MAIN CLASS CONTAINS: Welcome graphic and menu which opens up a 'UserPortal' Class
 *Do-whiles loop based on existence of user error
 */
public class Main{
	
	public static void main(String[] args) {
		
		//TODO: for v2 - make log in and check if username exists make a map with ID key, make producer consumer design to send amount from one user account to another.
		
		Scanner input = new Scanner(System.in); 				 // main scanner 
		boolean userError; 										//checks for user errors in try catch
		int choice=0;
	
		while (true) { 							//loops until break
			do {								//do while to check for user errors and exception handling
				userError=false;				
			try {	
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			System.out.println("                      /\\\\                " );
			System.out.println("                     /  \\\\               " );
			System.out.println("                    /    \\\\              " );
			System.out.println(" WELCOME TO THE    / BANK \\\\             " );
			System.out.println("                  /        \\\\            " );
			System.out.println("                  ----------''             " );
			System.out.println("Make a Selection");
			System.out.println("1.Customer Portal   |   2.Administration Portal   | 3.Exit App");			//input decides which User portal method to be called
			choice = Integer.parseInt(input.next());
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid Input, try again");
				
				userError=true;		//if exception from user input, variable goes from false to true, 
			}																						//looping back
			
			}while(userError);
			

			System.out.println("---------------------------------------------------");
			switch (choice) {		//switch for customer and admin portals as well as exit condition, loops back at end of process from original loop
			case 1:
				try {
					UserPortal.openCustomerPortal();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				UserPortal.openAdminPortal();
				break;
			case 3:
				System.out.println("The Application has Ended");			//ends the application
				System.exit(1);
			}
			System.out.println("Restarting Application...Type [0] to continue--- or really any key, we're not picky");
			input.next();

			System.out.println("******************************************************************");
			
		}

	}
}
