package Assignment1;

import java.util.Scanner;

public class ComputeChange {

    public static void main(String[] args) {
    // Scanner creation
    Scanner scanner = new Scanner(System.in);

    // Ask the user to enter the integer
    System.out.print("Please enter an integer whose last two digits represent the cents: ");
    int number = scanner.nextInt();
    int cents = number % 100;  //retrieve the dollar amount
    int dollars = number / 100;  //retrieve the cent amount
    
    
    //output the results
    System.out.println("The input "+number+ " represent "+dollars+ " dollars and "+cents+" cents.");
    
	
    
    
	
    
    
    
	
    }
    
    
	
}
