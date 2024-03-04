package Lecture4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class LinkedListDemo {

	public static void main(String[] args) {
		
		
		MyLinkedList<String> herList = new MyLinkedList<>();
		
		herList.add("C++");
		herList.add("Java");
		herList.add("Python");
		
		System.out.println(herList);
		
		
		
		LinkedList<String> myList = new LinkedList<>();
		
		myList.add("Milk");
		myList.add("Eggs");
		myList.add("Apples");
		
		displayList(myList);
		
		ArrayList<String> yourList = new ArrayList<>(); //polymorphism
		                            //data encapsulation
		                            //inheritance
		
		yourList.add("Red");
		yourList.add("Green");
		yourList.add("Blue");
		
		displayList(yourList);

	}
	//public static void displayList(ArrayList<String> aList) {
		
		//System.out.println(aList);
		
		
	//}
	
	
   // public static void displayList(LinkedList<String> aList) {
    	//System.out.println(aList);
    	
    	
   // }
	
    public static void displayList(Collection<String> aList) {
    	System.out.println(aList);
    }
	
    public static void displayList(List<String> aList) {
    	System.out.println(aList);
    	
    }
    
	
}
