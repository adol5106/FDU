package Lecture3;

import java.util.ArrayList;

public class OfficialArrayDemo {

	public static void main(String[] args) {
		// Create an object/instance
		ArrayList<String> myList = new ArrayList<String>();
		
		myList.add("Milk");
		myList.add("Eggs");
		System.out.println(myList);
		
		myList.add(0,"Apples");
		System.out.println(myList);
		
		System.out.println(myList.isEmpty());
		
		System.out.println(myList.size());
		
		System.out.println(myList.contains("Milk"));
		

	}

}
