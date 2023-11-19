package Lecture9;

import java.util.Scanner;

public class ShiftingElements {
  public static void main(String[] args) {
	  
	   Scanner scanner = new Scanner(System.in);
	   double[] myList = new double[10];
	   System.out.print("Enter 10 values:");
	   for (int i=0;i<10;i++) {
		   myList[i]=scanner.nextDouble();
	   }
	  
	   double temp = myList[0];
	   
	   for (int j=1; j<myList.length; j++) {
		   myList[j-1] = myList[j];
	   }
	  
	   myList[myList.length-1] = temp;
	  
	   for (int k=0;k<myList.length;k++) {
	    System.out.println(myList[k]);
	   }
  }
	
	
	
	
	
}
