package Lecture9;

import java.util.Scanner;

public class ReverseNumber {
   public static void main (String[] args) {
	   
	   Scanner scanner = new Scanner(System.in);
	   System.out.print("Enter an integer: ");
	   int number = scanner.nextInt();
	   reverse(number);
	   
   }
   
   
   
   public static void reverse(int numbers) {
	   int reversenumber = 0;
	   
	   while (numbers != 0) {
		   int digit = numbers % 10;
		   reversenumber = reversenumber * 10 + digit;
		   numbers /= 10;
	   }
	   
	   System.out.println(reversenumber);
	   
   }
	
	
}
