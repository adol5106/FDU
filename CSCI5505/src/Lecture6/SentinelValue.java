package Lecture6;

import java.util.Scanner;

public class SentinelValue {
  public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  int sum = 0;
	  System.out.print("Please enter a number, and you enter 0 to end the input: ");
	  int value=input.nextInt();
	  sum += value;
	  while (value != 0) {
		  System.out.print("Please enter a number, and you enter 0 to end the input: ");
		  value=input.nextInt();
		  sum += value;
		  
	  }
	  System.out.print("The sum of the numbers is "+sum);
	  
	  
	  
	  
	  
  }
	
	
	
}
