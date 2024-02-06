package OODDemo;

public class Car {

	// attribute, or properties; data members
	String color;
	String make;
	int year;
	double price;
	
	
	//constructors for building objects
	public Car() { //default constructor		
		
	}
	
	// another constructor
	public Car(String color,String make,int year,double price) {
		this.color = color;
		this.make = make;
		this.year = year;
		this.price = price;
		
	}
	
	
	
	
	//common behaviors, or member methods
	void start() {
		System.out.println("The car is starting...");
	}
	
	void stop() {
		System.out.println("Car is stopping...");
		
	}
	
	void accerlerate() {
		System.out.println("Car is accerlating...");
		
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", make=" + make + ", year=" + year + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
}
