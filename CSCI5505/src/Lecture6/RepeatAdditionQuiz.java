package Lecture6;

import java.util.Scanner;


public class RepeatAdditionQuiz {
   public static void main (String[] args) {
	  int n1= (int)(Math.random()*10);
	  int n2= (int)(Math.random()*10);
	  
	   
	  Scanner input = new Scanner(System.in);
	  System.out.print("What is the answer of "+n1+" + "+n2+ "? ");
	  
	  int trueAnswer = n1+n2;
	  int studentAnswer=input.nextInt();
	  
	  while (studentAnswer != trueAnswer)
	  { 
	     System.out.println("Your answer is wrong, please try again");
	     studentAnswer=input.nextInt();
	     

	   
	  }
	  System.out.print("Your answer is correct!");
	   
   }
		
	
}
