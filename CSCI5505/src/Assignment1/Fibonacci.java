package Assignment1;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
    // Scanner creation
    Scanner scanner = new Scanner(System.in);	
    
    //Prompt to the user for input which Fibonacci number user wants to get
	System.out.print("Which Fibonacci nuumber you would like to get: ");
	int number = scanner.nextInt();
    int first = 0;
    int second = 1;
    int third = 0;

    // Calculating the Fibonacci numbers
    for (int i = 2; i <= number; i++) {
        third = first + second;
        first = second;
        second = third;}
    
    // Printout the result
    System.out.println("The " + number + "th Fibonacci number is: " + third);
    
    
    
	
   
    }
}