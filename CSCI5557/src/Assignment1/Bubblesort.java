package Assignment1;

//Question 1
import java.util.Scanner;


public class Bubblesort {

	public static void main(String[] args) {
		
		System.out.println("Bubble sort!");
		Scanner scanner = new Scanner(System.in);
		
		int[] array = new int[10];
		System.out.println("You will enter 10 numbers into the array.");
		
		//Assign the values into the array
		for (int i=0; i<array.length; i++) {
		      System.out.println("Please enter the "+(int)(i+1)+" number:");
		      array[i]=scanner.nextInt();
		      
		}
		
		
		System.out.println("Before sorting:");
		displayArray(array);//display the array before sorting
		
	    bubbleSort(array); //execute the bubble sort
	    System.out.println();
		System.out.println("After sorting:");
		displayArray(array); //display the array after sorting

		
	 }
	 
	 public static void bubbleSort(int[] myList) {
			boolean needNextPass = true;
		    
			for (int k = 1; k < myList.length && needNextPass; k++) {
			      needNextPass = false; //flag the next round to false at the 
			      //beginning of the iteration 
			      //because we want to make it as false if no next round needed
			      
			      for (int i = 0; i < myList.length - k; i++) {
			        if (myList[i] > myList[i + 1]) {
			          int temp = myList[i];
			          myList[i] = myList[i + 1];
			          myList[i + 1] = temp; //swap the larger one to the right
			          
			          needNextPass = true; // Next pass still needed
			        }
			      }
			}
		 
	 }
public static void displayArray(int[] array) {
		for (int i=0;i<array.length;i++) {
			 System.out.print(array[i]+" ");
			 
			 
			 
}
	 
}
}



