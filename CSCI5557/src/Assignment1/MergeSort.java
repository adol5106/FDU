package Assignment1;

//Question 2
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		
		System.out.println("Merge sort!");
		Scanner scanner = new Scanner(System.in);
		
		char[] array = new char[10];
		System.out.println("You will enter 10 characters into the array.");
		
		//Assign the values into the array
		for (int i=0; i<array.length; i++) {
		      System.out.println("Please enter the "+(int)(i+1)+" character:");
		      array[i]=scanner.next().charAt(0);
		      
		}
		
		
		System.out.println("Before sorting:");
		displayArray(array);//display the array before sorting
		
	    mergeSort(array);
	    System.out.println();
		System.out.println("After sorting:");
		displayArray(array);//display the array after sorting


	}

	
	
	public static void mergeSort(char[] list) {
	    if (list.length > 1) {
	      // Divide it to the first half
	      char[] firstHalf = new char[list.length / 2];
	      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
	      mergeSort(firstHalf);

	      // Divide it to the second half
	      int secondHalfLength = list.length - list.length / 2;
	      char[] secondHalf = new char[secondHalfLength];
	      System.arraycopy(list, list.length / 2, secondHalf, 0,
	                             secondHalfLength);
	      mergeSort(secondHalf);

	      // Merge firstHalf with secondHalf into list
	      merge(firstHalf, secondHalf, list);
	    }
	}
	
	

	public static void merge(char[] list1, char[] list2, char[] temp) {
	    int current1 = 0; // Current index in list1
	    int current2 = 0; // Current index in list2
	    int current3 = 0; // Current index in temp

	    while (current1 < list1.length && current2 < list2.length) {//when both list 1 and 2 can be iterated
	      if (list1[current1] < list2[current2])
	        temp[current3++] = list1[current1++]; //add the smaller value to the merged array
	      else
	        temp[current3++] = list2[current2++];
	    }

	    while (current1 < list1.length) //when list 2 is over
	      temp[current3++] = list1[current1++];

	    while (current2 < list2.length) //when list 1 is over
	      temp[current3++] = list2[current2++];
	}

	
	
	
    public static void displayArray(char[] array) {
		for (int i=0;i<array.length;i++) {
			 System.out.print(array[i]+" ");
			 
			 
			 
}	
    }	
	
}
