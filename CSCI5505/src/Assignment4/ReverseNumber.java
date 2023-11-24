package Assignment4;

//Question 1

import java.util.Scanner;

public class ReverseNumber {
   public static void main (String[] args) {
	   
	   Scanner scanner = new Scanner(System.in);
	   
	   //Create an array that can hold ten integers
	   int[] myList = new int[10];
	   System.out.print("Enter ten integer: ");
	   
	   //Assign the ten integers into an array of 10 by user's input
	   for (int i =0;i<10;i++) {
	      myList[i] = scanner.nextInt();
	   }
	   
	   //Notifying the user to print the ten integers in reverse order
	   System.out.println("The reverse order of the ten integers is ");
	   
	   //Print the ten integers in reverse order
	   for (int j=9; j>=0; j--) {
		   System.out.print(myList[j]+" ");
		   
	   }
	   
   }
   
   

	
	
}
