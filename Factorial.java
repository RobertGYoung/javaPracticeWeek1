package com.revature.day01;
public class Factorial{
	public static void main(String []args){
/*		
	int num = Integer.parseInt(args[0]);
	int total=num;

	for(int i = num;i>1 ;i--){
	total=total*(i-1);
		 
		}
System.out.println(total);*/



	int num = Integer.parseInt(args[0]);
	int total=num;
	int i = num;
	while(i>1){
		total=total*(i-1);

		i--;
	}
	System.out.println(total);
	
	}

}