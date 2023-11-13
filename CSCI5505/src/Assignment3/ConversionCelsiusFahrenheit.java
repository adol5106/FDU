package Assignment3;

import java.util.Scanner;

//Question 1

public class ConversionCelsiusFahrenheit {
    public static void main (String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	//input the unit
    	System.out.println("Please enter the unit (F or C): ");
  	    char unit = scanner.next().charAt(0);
  	    unit = Character.toUpperCase(unit);
  	    
  	    //input the degree
  	    System.out.println("Please enter the degree: ");
  	    double degree = scanner.nextDouble();
  	    
  	    //choose either C to F or F to C
  	    switch (unit) {
  	    case 'F':
  	    	System.out.println("The fahrenheit degree of "+degree+" is "+fahrenheitToCelsius(degree)+" in celsius.");
  	    	break;
  	    case 'C':
  	    	System.out.println("The celsius degree of "+degree+" is "+celsiusToFahrenheit(degree)+" in fahrenheit.");
  	    	break;
  	    
  	    
  	    }
    	
    	
    }
	
    //method of celsius to fahrenheit conversion
    public static double celsiusToFahrenheit(double celsius) {
    	double fahrenheit = (9.0 / 5)*celsius+32;
    	return fahrenheit;
    	
    }
	
    //method of fahrenheit to celsius conversion
    public static double fahrenheitToCelsius(double fahrenheit) {
    	double celsius = (5.0/9) * (fahrenheit - 32);
    	return celsius;
    }
    
	
	
}
