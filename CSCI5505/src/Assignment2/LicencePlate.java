package Assignment2;

//Question 1

public class LicencePlate {
   public static void main(String[] args) {
	   
	   System.out.print("The license plate number generated randomly is: ");
	   
	   //Print out the first three digits of random letters
	   for (int c =0; c<3; c++) {
	     char randomLetter = (char)((Math.random()*(26))+'A');
	     System.out.print(randomLetter);
	   }
	   
	   //Print out the two digits of random numbers
	   for (int n=0; n<2; n++) {
		     int randomNumber = (int)(Math.random()*(10));
		     System.out.print(randomNumber);
		   }
	   
   }
}
