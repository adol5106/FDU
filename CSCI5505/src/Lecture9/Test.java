package Lecture9;
import java.util.Scanner;

public class Test {
   public static void main (String[] args) {
	   int[] values = new int[5];
	   for (int i=1; i<5; i++) {
		   values[i]=i+values[i-1];
		   
	   }
	   values[0]=values[1]+values[4];
	   for (int j=0; j<5; j++) {
	     System.out.println(values[j]);
	   }
	   
	   
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("Enter the size of the array: ");
	   int length = scanner.nextInt();
	   double[] myList = new double[length];
	   System.out.print("Enter "+myList.length+" values:");
	   for (int i=0;i<myList.length;i++) {
		   myList[i]=scanner.nextDouble();
	   }
	  
	   double total=0;
	   for (int k=0;k<myList.length;k++) {
		   total += myList[k];
	   }
	   System.out.println(total);
	   
	   double max = myList[0];
	   for (int i =1; i<myList.length;i++) {
		   if (myList[i]>max)
			   max = myList[i];}
	   System.out.println(max);
	   }
	   
	   
}
	
	

