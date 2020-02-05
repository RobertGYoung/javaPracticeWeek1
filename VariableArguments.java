package com.revature.day01;
public class VariableArguments{
	public static void main(String[] args){

	int [] arr= new int[args.length];
	for(int i=0;i<args.length;i++){
		arr[i]=Integer.parseInt(args[i]);
	}
int addResult = add(arr);

System.out.println("Result= "+addResult);
		
}

public static int add(int ...elementsInArray){

int [] nums = elementsInArray;
int result = 0;
for (int i = 0; i<nums.length;i++){
		result =result+nums[i];
		}
return result;

	}
}