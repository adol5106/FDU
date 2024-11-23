package Final;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Lecture8.AVLTree;
import Lecture8.BST;

//Name: Qingyun Zhang (Rick)  ID: 2095754
//Question 1

public class QueueDriver {

	
	
	public static void main(String[] args) {
		//Question 1
		Scanner scanner = new Scanner(System.in);
		Queue<Character> queueChar = new LinkedList<>();
		System.out.println("Enter the following characters:'H', 'J', 'M', 'G', 'D' ");
		queueChar = makeQueue(queueChar);
        System.out.println(queueChar);
		
        //Question 2
        AVLTree<Character> tree = new AVLTree<>();
        tree = makeAVLTree(queueChar,tree);
        
        //Question 3
        System.out.println("Please enter the order method:");
        String orderMethod = scanner.nextLine();
        showAVLTree(tree,orderMethod);
        
        
	}

	public static Queue<Character> makeQueue(Queue<Character> inputQueue){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the character 'H' ");
		char h = scanner.next().charAt(0);
		inputQueue.offer(h);
		System.out.println("Enter the character 'J' ");
		char j = scanner.next().charAt(0);
		inputQueue.offer(j);
		System.out.println("Enter the character 'M' ");
		char m = scanner.next().charAt(0);
		inputQueue.offer(m);
		System.out.println("Enter the character 'G' ");
		char g = scanner.next().charAt(0);
		inputQueue.offer(g);  
		System.out.println("Enter the character 'D' ");
		char d = scanner.next().charAt(0);
		inputQueue.offer(d);
		
		return inputQueue;
	}
	
	public static AVLTree<Character> makeAVLTree(Queue<Character> inputQueue, AVLTree<Character> treeInput){
		
		while (inputQueue.size()!=0)
		 treeInput.insert(inputQueue.poll());
		
		return treeInput;
		
	}
	
	  public static void showAVLTree(BST tree, String order) {
		    // Traverse tree
		  switch (order) {
		  case "inorder":
		    System.out.print("\nInorder (sorted): ");
		    tree.inorder();
		    break;
		  
		  case "postorder":
		    System.out.print("\nPostorder: ");
		    tree.postorder();
		    break;
		    
		  case "preorder":
		    System.out.print("\nPreorder: ");
		    tree.preorder();
		    break;
		    
		  default:
			System.out.println("Invalid Entry!");
	
	  }  
		    System.out.println();
		  }
	  }

