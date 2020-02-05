package com.revature.day01;
import java.util.Arrays;
public class TwoDArrayTrial{
	public static void main(String[] args){
int x=2;
	int[][] my2DArray = new int [args.length/2][x];
int sum;
	double total=0;
	if(args.length%2!=0){
		System.out.println("You need an even amount of entries to compute");
	}
	int ctr=0;
		for(int i=0; i<args.length;i+=x){
			my2DArray[ctr][0]=Integer.parseInt(args[i]);
			total=total+my2DArray[ctr][0];			
			System.out.println("first row includes: "+my2DArray[ctr][0]);
			ctr++;
			}
	ctr =0;
		for(int i=1; i<=args.length;i+=x){
			my2DArray[ctr][1]=Integer.parseInt(args[i]);
			total=total+my2DArray[ctr][1];
			System.out.println("second row includes: "+my2DArray[ctr][1]);
			ctr++;
			}
double avg = total/args.length;
System.out.println("sum of 2d array: "+total);
System.out.println("Average of 2d array: "+avg);
System.out.println(Arrays.deepToString(my2DArray));
	

		
	}
}