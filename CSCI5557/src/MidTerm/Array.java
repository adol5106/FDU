package MidTerm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.Math;


public class Array {

	public static void main(String[] args) {
		
		//Question 1
		Scanner scanner = new Scanner(System.in);
		
		int[] array = new int[6];
		System.out.println("You will enter 6 odd numbers into the array.");
		
		//Assign the odd values into the array
		for (int i=0; i<array.length; i++) {
		      System.out.println("Please enter the "+(int)(i+1)+" number:");
		      int num=scanner.nextInt();
		      while (num%2==0) {
		    	  System.out.println("Please enter an odd number:");
		    	  num=scanner.nextInt();
		      }
		      array[i]=num;
		    	  
		      
		}
        
		
		//Question 2
		System.out.println("The unsorted list:");
		displayArray(array);
		mergeSort(array);
		System.out.println("The sorted list:");
		displayArray(array);
		
		//Question 3
		ArrayList<Integer> numberList = new ArrayList<>();
		for (int i=0;i<array.length;i++) {
			int index = (int)(Math.random()*6);
			numberList.add(array[index]);
		}
		System.out.println("Unsorted Array List:");
		System.out.println(numberList);
		
		//Question 4
		sortList(numberList);
		System.out.println("Sorted Array List:");
		System.out.println(numberList);
		
		//Question 5
		char[] charArray = new char[6];
		System.out.println("You will enter 6 lowercase alphabetic characters into the array.");
		
		//Assign the lowercase alphabetic characters into the array
		for (int i=0; i<charArray.length; i++) {
		      System.out.println("Please enter the "+(int)(i+1)+" alphabetic characters:");
		      char c = scanner.next().charAt(0);
		      while (!((int)c<=126 && (int)c>=97)) {
		    	  System.out.println("Please enter a lowercase alphabetic character:");
		    	  c = scanner.next().charAt(0);
		      }
		      charArray[i]=c;	  
		      
		}
		
		
		
		
		
		//Question 6
		System.out.println("The unsorted char list:");
		displayCharArray(charArray);
		quickSort(charArray);
		System.out.println("The sorted char list:");
		displayCharArray(charArray);
		
		
		
		//Question 7
		LinkedList<Character> charList = new LinkedList<>();
		for (int i=0;i<charArray.length;i++) {
			int charIndex = (int)(Math.random()*6);
			charList.add(charArray[charIndex]);
		}
		System.out.println("Unsorted Character Linked List:");
		System.out.println(charList);
		
		
		
		//Question 8
		sortCharList(charList);
		System.out.println("Sorted Character Linked List:");
		System.out.println(charList);
		
		
		
	}

	//Merge sort method
	public static void mergeSort(int[] list) {
	    if (list.length > 1) {
	      // Divide it to the first half
	      int[] firstHalf = new int[list.length / 2];
	      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
	      mergeSort(firstHalf);

	      // Divide it to the second half
	      int secondHalfLength = list.length - list.length / 2;
	      int[] secondHalf = new int[secondHalfLength];
	      System.arraycopy(list, list.length / 2, secondHalf, 0,secondHalfLength);
	      mergeSort(secondHalf);

	      // Merge firstHalf with secondHalf into list
	      merge(firstHalf, secondHalf, list);
	    }
	}
	
	

	public static void merge(int[] list1, int[] list2, int[] temp) {
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

	
	
	
    public static void displayArray(int[] array) {
		for (int i=0;i<array.length;i++) {
			 System.out.print(array[i]+" ");
			 }	
		System.out.println();
    }
    
	//Sort the number list in order
    public static void sortList(ArrayList<Integer> nList) {
        Collections.sort(nList);   
        
    }
    
    //Quick sort method
	public static void quickSort(char[] list) {
		    quickSort(list, 0, list.length - 1);
		  }

		  private static void quickSort(char[] list, int first, int last) {
		    if (last > first) {
		      int pivotIndex = partition(list, first, last);
		      quickSort(list, first, pivotIndex - 1);
		      quickSort(list, pivotIndex + 1, last);
		    }
		  }

		  /** Partition the array list[first..last] */
		  private static int partition(char[] list, int first, int last) {
		    char pivot = list[first]; // Choose the first element as the pivot
		    int low = first + 1; // Index for forward search
		    int high = last; // Index for backward search
		    while (high > low) {
		        // Search forward from left
		        while (low <= high && list[low] <= pivot)
		          low++;

		        // Search backward from right
		        while (low <= high && list[high] > pivot)
		          high--;

		        // Swap two elements in the list
		        if (high > low) {
		          char temp = list[high];
		          list[high] = list[low];
		          list[low] = temp;
		        }
		      }

		      while (high > first && list[high] >= pivot)
		        high--;

		      // Swap pivot with list[high]
		      if (pivot > list[high]) {
		        list[first] = list[high];
		        list[high] = pivot;
		        return high;
		      }
		      else {
		        return first;
		      }
		    }
	 
	public static void displayCharArray(char[] array) {
		for (int i=0;i<array.length;i++) {
				System.out.print(array[i]+" ");
					 }	
		System.out.println();
	}
    
	
	//Sort the char linked list in alphabetical order
    public static void sortCharList(LinkedList<Character> cList) {
	        Collections.sort(cList);
	        
    } 	
	
    
}
