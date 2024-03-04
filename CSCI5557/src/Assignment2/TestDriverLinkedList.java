package Assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class TestDriverLinkedList {

	//Test driver of the book list based on linked list
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<>();
		
		fillBooklist(myList);
		System.out.println("Filled List:");
		displayBookList(myList);
		changeBooklist(myList);
		System.out.println("Changed List:");
		displayBookList(myList);
		sortBookList(myList);
		System.out.println("Sorted List:");
		displayBookList(myList);

	}

	
	//Add the item into the book list until the user answer "no" in question of "Have more books?"
	public static void fillBooklist(LinkedList<String> bookList) {
		Scanner scanner = new Scanner(System.in);
		String s="";
		
		do {
			System.out.println("Enter a book title: ");
			s = scanner.nextLine();
			bookList.add(s);
			System.out.println("Have more books? ");
			s = scanner.nextLine();
		} while(!s.equals("no"));
		
		
		
	}
	
	//change the book list items into upper case
	public static void changeBooklist(LinkedList<String> bookList) {
		for (int i=0;i<bookList.size();i++) {
			String s = bookList.get(i);
			s = s.toUpperCase();
			bookList.set(i, s);
			
		}}
	
	
	//Sort the book list in alphabetical order
    public static void sortBookList(LinkedList<String> bList) {
	        Collections.sort(bList);
	        
    } 	
		
    
    //Display all of the book list items
    public static void displayBookList(LinkedList<String> bookList) {
        for (String t:bookList) {
            System.out.print(t+"    ");
        }
	    System.out.println();
	   
	   }


}
	
	

