package lecture2;
import java.util.Scanner;

public class ComputeAverage {
  public static void main(String[] args) {
	  Scanner input=new Scanner(System.in); //create a scanner object
	  final int SIZE=5;
	  System.out.print("Enter "+SIZE+" numbers:");//Prompt user to enter three numbers
	  double number1=input.nextDouble();
	  double number2=input.nextDouble();
	  double number3=input.nextDouble();
	  double number4=input.nextDouble();
	  double number5=input.nextDouble();
	  double average=(number1+number2+number3+number4+number5)/SIZE; //Compute average
	  System.out.println("The average of "+number1+" "+number2+" "+number3+" "+number4+" "+number5+" is "+average);//display result
	  
  }
	
	
}
