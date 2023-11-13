package Assignment3;


//Quesiton 2



public class NumberOfDays {

	public static void main (String[] args) {
		
    //Print the number of days in a year from 2000 to 2020
	  for (int year=2000;year<=2020;year++) {	
		System.out.println("The year of "+year+" has "+numberOfDaysInAYear(year)+" days.");
		
	  }
	}
	
	//The method of how to identify whether it is a leap year or not
	public static int numberOfDaysInAYear(int year) {
		if ((year%4 ==0 && year%100 != 0) || (year%400==0))
		   return 366;
		else 
		   return 365;
	}
	
	
}
