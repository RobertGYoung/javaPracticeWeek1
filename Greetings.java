package com.revature.day01;
public class Greetings{

	public static void main(String[] args){
		
		String name;
		int age;
	


	if(args.length==0){
		System.out.println(greeting());
	}

	else if(args.length==1){
		
		name = args[0];
		System.out.println(greeting(name));
		}

	else if(args.length==2){
		name = args[0];
		age = Integer.parseInt(args[1]);
		System.out.println(greeting(name, age));
	}
	
	}
	

	public static String greeting(){
		return "Hello World! You can be the best";
	} 



	public static String greeting(String name){

		return "Hello "+name+" You can be the best";
	}

	public static String greeting(String name, int age){

		return "Hello "+name+" You are "+age+" years old";
	}
}