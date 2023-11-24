package Assignment4;

//Question 2

import java.util.Scanner;

public class SmallestElement {
   public static void main (String[] args) {
	   Scanner scanner = new Scanner(System.in);
	   //Input the array size
	   System.out.println("Enter the size of the array: ");
	   int length = scanner.nextInt();
	   //Create an array that holds double values
	   double[] myList = new double[length];
	   System.out.print("Enter "+myList.length+" values:");
	   //Assign the double values to the array by iteration
	   for (int i=0;i<myList.length;i++) {
		   myList[i]=scanner.nextDouble();
	   }
	   //Print out the smallest element's index
	   System.out.println("The index of smallest element is: "+indexOfSmallestElement(myList));
	   
	   
   }
   public static int indexOfSmallestElement(double[] array) {
	   double smallest = array[0];
	   int smallestIndex = 0;
	   
	   for (int j=1;j<array.length;j++) {
	     if (array[j] < smallest && array[j]>1) {
	    	 //Assign the smallest value and index to the variables if the for loop can finder a smaller value
	    	 smallestIndex = j;
	    	 smallest = array[j];}
	     //Get the smallest index if find two or more of the smallest values
	     else if (array[j] == smallest && j<smallestIndex)
	    	 smallestIndex = j;
	     }
	   return smallestIndex;
   }
	
}
