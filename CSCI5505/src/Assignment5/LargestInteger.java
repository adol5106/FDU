package Assignment5;

//Question 1
import java.util.Scanner;

public class LargestInteger {
   public static void main (String[] args) {
	   
	   Scanner scanner = new Scanner(System.in);
	   
	   //Create an integer array of size 8
	   int[] myList = new int[8];
	   System.out.println("You will enter 8 numbers.");
	   
	   //Assign the values into the array
	   for (int i=0; i<myList.length; i++) {
	      System.out.println("Please enter the "+(int)(i+1)+" number:");
	      myList[i]=scanner.nextInt();
	      
	     }
	   
	   int largestElement = getLargestInteger(myList);
	   System.out.println(largestElement);
		   
	   }
	
   //The method of getting the largest integer
   public static int getLargestInteger(int[] list) {
	   int largest=Integer.MIN_VALUE;
	   for (int j=0;j<list.length;j++) {
		   if (list[j] > largest)
			   largest = list[j];}
	   return largest;   
	   }
	   
	   
	   
	   
	   
   }
   
	   
	   
	   
	
	
	

