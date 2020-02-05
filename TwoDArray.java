package com.revature.day01;

import java.util.Arrays;
public class TwoDArray{
	public static void main(String[] args){
	int[][] my2DArray = new int [2][args.length/2];

int sum;
	double total=0;
	if(args.length%2!=0){
		System.out.println("You need an even amount of entries to compute");
	}

	int ctr=0;

		for(int i=0; i<args.length;i+=2){
			my2DArray[0][ctr]=Integer.parseInt(args[i]);
			total=total+my2DArray[0][ctr];
			
			System.out.println("first row includes: "+my2DArray[0][ctr]);
			ctr++;
			}

		ctr =0;

		for(int i=1; i<=args.length;i+=2){
			my2DArray[1][ctr]=Integer.parseInt(args[i]);
			total=total+my2DArray[1][ctr];
			System.out.println("second row includes: "+my2DArray[1][ctr]);
			ctr++;
			}
	
double avg = total/args.length;
System.out.println("sum of 2d array: "+total);
System.out.println("Average of 2d array: "+avg);
System.out.println(Arrays.deepToString(my2DArray));
	

		
	}
}