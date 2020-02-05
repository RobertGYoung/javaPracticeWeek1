package com.revature.day01;
public class ScalableMaxNumberCalc{

	public static void main(String[] args){
	int biggest=0;

	for(String input : args){

		int i = Integer.parseInt(input);
		
		if(i>biggest){
biggest=i;
}
		}
System.out.println("This is the biggest of the list: "+biggest);
	}
}