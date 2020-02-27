package com.revature.scanner;

import java.util.Scanner;

public  class SingleScanner {

	    private static Scanner input;
	   
	
	    public static Scanner getInput() {
	        if (input == null) {
	            input= new Scanner(System.in);
	        } 
	        return input;
	    }
	}

