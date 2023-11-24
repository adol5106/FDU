package Assignment4;

//Question 3

import java.util.Scanner;

public class SortedList {
	   public static void main (String[] args) {
		   Scanner scanner = new Scanner(System.in);
		   //Prompt to the user to input the array size
		   System.out.println("Enter the size of the array: ");
		   int length = scanner.nextInt();
		   //create the array by the inputting length
		   int[] myList = new int[length];
		   //Prompt the user to input each element of the array
		   System.out.println("Enter "+myList.length+" values for the array:");
		   //Assign the values to the array
		   for (int i=0;i<myList.length;i++) {
			   myList[i]=scanner.nextInt();
		   }
		   
		   //if else statement to print the messages based on the returned boolean result
		   if (isSorted(myList))
			   System.out.println("This list is sorted.");
		   else
			   System.out.println("This list is not sorted.");
		   
		   
	   }
	   
	   //the method to check whether the array is sorted or not
	   public static boolean isSorted(int[] list) {
		   for (int j=0; j<list.length-1;j++) {
			   if (list[j] > list[j+1])  //as long as a element value is larger than the value of the next element, then return false for an unsorted array
				   
				   return false;
			  
		   }
		   return true;
		   
		   
	   }
}
	   

