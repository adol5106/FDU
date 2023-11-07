package Assignment2;

import java.util.Scanner;

//Question 2

public class MajorAndGrade {
  public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  
	  //input the major code
	  System.out.print("Enter student major code: ");
	  char majorCode = scanner.next().charAt(0);
	  majorCode = Character.toUpperCase(majorCode);
	  
	  //input the student grade
	  System.out.print("Enter student grade: ");
	  int grade = scanner.nextInt();
	  
	  //Print out the major code
	  System.out.print("The student has a major of ");
	  switch (majorCode) {
	  case 'M':
		  System.out.println("Mathematics");
		  break;
	  case 'C':
		  System.out.println("Computer Science");
		  break;
	  case 'I':
		  System.out.println("Information Technology");
		  break;
	  
	  }
	  
	  //Print out the grade
	  System.out.print("The student is in the grade of ");
	  switch (grade) {
	  case 1:
		  System.out.println("Freshman");
		  break;
	  case 2:
		  System.out.println("Sophomore");
		  break;
	  case 3:
		  System.out.println("Junior");
		  break;
	  case 4:
		  System.out.println("Senior");
		  break;
		  
	  
	  
	  
	  }
	  
	  
	  
  }
	
	
	
	
	
	
	
}
