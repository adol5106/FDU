package Assignment1;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        // Scanner creation
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the three coordinates of the triangle
        System.out.println("Please enter the coordinates of three points (x1, y1), (x2, y2), (x3, y3):");

        // Read the coordinates of the three points
        //Enter the first coordinator
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();

        //Enter the second point coordinator
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        //Enter the third point coordinator
        System.out.print("Enter x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = scanner.nextDouble();

        // Calculate the area of the triangle
        double area = 0.5* Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        


        // Show the result
        System.out.println("The area of this triangle is: " + area);
    }
    

    

	
	
	
}
