package Lecture5;

import java.util.Scanner;
import java.util.Stack;

public class StackDemo2 {

	public static void main(String[] args) {
		
		//Declares a stack called bookStack in main()
		Stack<String> bookStack = new Stack<>();
		
		//Call
		//
		//by 
		fillBookStack(bookStack);
		System.out.println("The book stack is "+bookStack);
		
		
		
		GenericStack<String> myStrStack = new GenericStack<>();
		myStrStack.push("Red");
		myStrStack.push("Green");
		myStrStack.push("Blue");
		
		System.out.println(myStrStack);
		System.out.println(myStrStack.search("Red"));
		System.out.println("Yellow: "+myStrStack.search("Yellow"));
		
		
		
		
		Stack<String> strStack = new Stack<>();
		
		
		
		strStack.push("One");
		strStack.push("Two");
		strStack.push("Three");
		
		System.out.println(strStack);
		
		
		
		Stack<Integer> intStack = new Stack<>();

		
		intStack.push(123);
		intStack.push(456);
		intStack.push(789);
		
		System.out.println(intStack.empty());
		
		System.out.println("123 has index "+intStack.search(123));
		
		System.out.println(intStack);
		
		System.out.println(intStack.pop());
		
		System.out.println(intStack);
		
		System.out.println(intStack.peek());
		
		System.out.println(intStack);
	}

	
	
	public static void fillBookStack(Stack<String> bookStack) {
		Scanner scanner = new Scanner(System.in);
		String s="";
		
		do {
			System.out.println("Enter a book title: ");
			s = scanner.nextLine();
			bookStack.push(s);
			System.out.println("Have more books? ");
			s = scanner.nextLine();
		} while(!s.equals("no"));
		
		
		
	}
	
	
	
}
