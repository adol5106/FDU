package Assignment2;

import java.util.ArrayList;
import java.util.Collections;


import java.util.Scanner;




public class TestDriverArrayList {

	//Test driver of the manipulating book list
	public static void main(String[] args) {
		ArrayList<String> bookList = new ArrayList<>();
		fillBookList(bookList);
		
		System.out.println("Unsorted booklist");
		displayBookList(bookList);
		changeBookList(bookList);
		System.out.println("Changed List:");
		displayBookList(bookList);
		sortBookList(bookList);
		System.out.println("Sorted booklist:");
		displayBookList(bookList);
		

		

	}

	//change the book list's book name to upper case
	public static void changeBookList(ArrayList<String> bookList) {
        for (int i = 0; i < bookList.size(); i++) {
        	bookList.set(i, bookList.get(i).toUpperCase());
        }
    }
	
	//Sort the book list in alphabet order
    public static void sortBookList(ArrayList<String> bList) {
        Collections.sort(bList);   
        
    }
	
    //Adding the items into the book list unless the user puts a string of "end"
    public static void fillBookList(ArrayList<String> bookList) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Please enter the book titles: then finish by typing 'end':");  
    	boolean goNext = true;
    	while(goNext) {
    		String title=scanner.nextLine();
    		if ("end".equalsIgnoreCase(title)) {
    			goNext=false;
    			continue;
    		}
    		bookList.add(title);
    		
    	}}

    //Print out the booklist 
    public static void displayBookList(ArrayList<String> bookList) {
        for (String t:bookList) {
            System.out.print(t+"   ");
        }
	   System.out.println();
	   
	   }
	   
    
    	
    }