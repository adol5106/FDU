package Assignment1;

//Question 3
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		
		System.out.println("Quick Sort");
		Scanner scanner = new Scanner(System.in);
		
		String[] array = new String[10];
		System.out.println("You will enter 10 countries into the array.");
		
		//Assign the values into the array
		for (int i=0; i<array.length; i++) {
		      System.out.println("Please enter the "+(int)(i+1)+" country:");
		      array[i]=scanner.nextLine();
		      
		}
		
		
		System.out.println("Before sorting:");
		displayArray(array);//display the array before sorting
		
	    quickSort(array);
	    System.out.println();
		System.out.println("After sorting:");
		displayArray(array);//display the array after sorting



	}

	
public static void quickSort(String[] list) {
		    quickSort(list, 0, list.length - 1);
		  }

		  private static void quickSort(String[] list, int first, int last) {
		    if (last > first) {
		      int pivotIndex = partition(list, first, last);
		      //recursion of partition 
		      quickSort(list, first, pivotIndex - 1);
		      quickSort(list, pivotIndex + 1, last);
		    }
		  }

		  /** Partition the array list[first..last] */
		  private static int partition(String[] list, int first, int last) {
		    String pivot = list[first]; // Choose the first element as the pivot
		    int low = first + 1; // Index for forward search
		    int high = last; // Index for backward search
	
		    while (high > low) {
		        // Search forward from left
		        while (low <= high && (list[low].compareTo(pivot)<=0) )
		          low++;

		        // Search backward from right
		        while (low <= high && list[high].compareTo(pivot) > 0)
		          high--;

		        // Swap two elements in the list
		        if (high > low) {
		          String temp = list[high];
		          list[high] = list[low];
		          list[low] = temp;
		        }
		      }

		      while (high > first && list[high].compareTo(pivot)>=0 )
		        high--;

		      // Swap pivot with list[high]
		      if (pivot.compareTo(list[high]) >0) {
		        list[first] = list[high];
		        list[high] = pivot;
		        return high;
		      }
		      else {
		        return first;
		      }
		    }
	
	
	
	
	
	
public static void displayArray(String[] array) {
	for (int i=0;i<array.length;i++) {
		System.out.print(array[i]+" ");
    }	
  }
}
