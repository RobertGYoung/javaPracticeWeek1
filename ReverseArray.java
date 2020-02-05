package com.revature.day01;
public class ReverseArray{
	public static void main(String[] args){
		int[] myArray = new int[args.length];
		
			for(int i=args.length-1;i>=0;i--){
				myArray[i]=Integer.parseInt(args[i]);
				System.out.print(myArray[i]+" ");
			}
			System.out.println("Sum: "+arraySum(myArray));
			System.out.println("Avg: "+arrayAvg(myArray));
		} 

public static int arraySum(int[] myArray){

	int total=0;
	for(int i = 0; i<myArray.length;i++){
	total=total+myArray[i];
		}//endloop
	return total;
	}//end method

	
public static double arrayAvg(int[] myArray){

	double total=0;
	for(int i = 0; i<myArray.length;i++){
	total=total+myArray[i];
		}//endloop
	return total/(double)myArray.length;
	}//end method
}//end class