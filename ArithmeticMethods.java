package com.revature.day01;
public class ArithmeticMethods{
	public static void main(String[] args){
		double num1=Double.parseDouble(args[0]);
		double num2=Double.parseDouble(args[1]);

		System.out.println("Sum:"+add(num1,num2));

		System.out.println("Dif:"+sub(num1,num2));

		System.out.println("Quotient:"+div(num1,num2));

		System.out.println("Product:"+mult(num1,num2));

		System.out.println("Mod:"+mod(num1,num2));
	}

	public static double add(double num1,double num2){
		return num1+num2;
	}
	public static double sub(double num1,double num2){
		return num1-num2;
	}
	public static double div(double num1,double num2){
		return num1/num2;
	}
	public static double mult(double num1,double num2){
		return num1*num2;
	}
	public static double mod(double num1,double num2){
		return num1%num2;
	}
}