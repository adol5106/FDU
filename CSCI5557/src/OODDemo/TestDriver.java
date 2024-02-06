package OODDemo;

public class TestDriver {

	public static void main(String[] args) {
		
		//Lets build some car objects
		//Scanner input = new Scanner(System.in);
		
		//Car carOne = new Car(); // create a Car object called carOne
		Car carOne = new Car("Red","Ford",2023,25000.76);
		carOne.start();
		carOne.accerlerate();
		carOne.stop();
		
		System.out.println(carOne);
		
		
	}


	
	
}
