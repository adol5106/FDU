package Assignment5;

//Question 2
import java.util.Scanner;


public class OccuranceOfChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the size of character list
        System.out.print("Enter the size of array: ");
        int size = scanner.nextInt();
        
        char[] charList = new char[size];
        
        System.out.println("Please enter the characters one at a time:");
        
        //Input and assign the char values into the array
        for (int i=0;i<size;i++) {
        	System.out.print("Enter the "+(int)(i+1)+" character:");
        	charList[i]=scanner.next().charAt(0);
        }
        
        

        // Prompt user to enter a character to be counted
        System.out.print("Enter a character to count: ");
        char chcount = scanner.next().charAt(0);

        // Display the result
        int occurrences = countOccurrences(charList, chcount);
        System.out.println("Number of occurrences of '" + chcount + "': " + occurrences);
    }

    // The method to count occurrences of a specified character in the array
    public static int countOccurrences(char[] chars, char ch) {
        int occurance = 0;
        for (char c:chars) {
        	if (c==ch)
        		occurance++;
        }
    	
    	
    	return occurance;
    }
	
	
	
	
}
