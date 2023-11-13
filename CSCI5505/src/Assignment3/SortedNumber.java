package Assignment3;

import java.util.Scanner;

//Question 3

public class SortedNumber {
     public static void main (String[] args) {
    	 Scanner scanner = new Scanner(System.in);
    	 
    	 //Enter the three numbers one by one
    	 System.out.println("Please enter the first number: ");
    	 double number1= scanner.nextDouble();
    	 System.out.println("Please enter the second number: ");
    	 double number2= scanner.nextDouble();
    	 System.out.println("Please enter the third number: ");
    	 double number3=scanner.nextDouble();
    	 
    	 displaySortedNumbers(number1,number2,number3);
    	 
    	 
    	 
    	 
     }
     //the method of sorting three numbers
	 public static void displaySortedNumbers(double num1, double num2, double num3) {
		 double temp;
		 
		 if (num1 > num2) {
			 temp = num1;
			 num1 = num2;
			 num2 = temp;
		 }
		 if (num2 > num3) {
			 temp = num2;
			 num2 = num3;
			 num3 = temp;
		 }
		 if (num1 > num2) {
			 temp = num1;
			 num1 = num2;
			 num2 = temp;
		 }
		 
		 System.out.println(num1+" "+num2+" "+num3);
		 
	 }
	
	
}
