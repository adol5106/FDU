package lecture2;

import java.util.Scanner;
public class ComputeRectangleArea {
      public static void main(String[] args) {
    	  //create a scanner object
    	  Scanner input = new Scanner (System.in);
    	  //Prompt the user to enter length and width
    	  System.out.print("Please enter the length: "); //prompt for entering the length
    	  double length = input.nextDouble();
    	  System.out.print("Please enter the width: "); //prompt for entering the width
    	  double width = input.nextDouble();
    	  
    	  //compute area
    	  double area = length * width;
    	  //display result
    	  System.out.println("The area of the rectangle is "+area);
    	  
    	  
    	  
      }
	
}
