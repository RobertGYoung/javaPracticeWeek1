package com.revature.day01;
//conversions 1 usd = 1.49 aud, .90eur, .77ukp, 108.69yen, 71.29inr
import java.util.Scanner;
import java.text.DecimalFormat;


//Math.floor(num*100.0)/100; 
public class CurrencyConvertor{
	public static void main(String[] args){
		
	Scanner amountInput = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("#.00"); 
	System.out.println("Enter amount of USD to conver to other currencies: ");

	Double usdAmount = Double.parseDouble(amountInput.nextLine());
	
	double aud = usdAmount*1.49;
	double eur = usdAmount*0.90;
	double ukp = usdAmount*0.77;
	double yen = usdAmount*108.69;
	double inr = usdAmount*71.29;

	System.out.println("The USD amount you chose is: "+Math.floor(usdAmount*100.00)/100);
	System.out.println("That Converts to:\n"+df.format(aud)+"AUD\n"+df.format(eur)+"EUR\n"+df.format(ukp)+"UKP\n"+df.format(yen)+"YEN\n"+df.format(inr)+"INR");
	}

}