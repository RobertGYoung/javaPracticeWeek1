package com.revature.day01;
public class Arithmetic2{
	public static void main(String []args){
		//int num1,num2, sumResult,subResult, multResult, divResult, modResult;
		//float num1,num2, sumResult,subResult, multResult, divResult, modResult;
		double num1,num2, sumResult,subResult, multResult, divResult, modResult;
			
		//num1 = Integer.parseInt(args[0]);
		//num2 = Integer.parseInt(args[1]);

		//num1 = Float.parseFloat(args[0]);
		//num2 = Float.parseFloat(args[1]);

		num1 = Double.parseDouble(args[0]);
		num2 = Double.parseDouble(args[1]);
		
	sumResult= num1+num2;
	subResult = num1-num2;
	multResult = num1*num2;
	divResult = num1/num2;
	modResult = num1%num2;
	System.out.println("Sum = " + sumResult);
	System.out.println("Difference = " + subResult);
	System.out.println("Product= " + multResult);
	System.out.println("Quotient = " + divResult);
	System.out.println("Remainder = " + modResult);
	
	}

}