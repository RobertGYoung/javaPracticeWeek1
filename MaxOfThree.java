package com.revature.day01;
public class MaxOfThree{
	public static void main(String[] args){
	int num1, num2, num3;
	num1= Integer.parseInt(args[0]);
	num2= Integer.parseInt(args[1]);
	num3= Integer.parseInt(args[2]);
	
	if(num1>=num2&&num1>=num2){
		System.out.println(num1);
	}
	else if(num2>=num1&&num2>=num3){
		System.out.println(num2);
	}

	else if(num3>=num1&&num3>=num2){
		System.out.println(num3);
	}
	

}

}