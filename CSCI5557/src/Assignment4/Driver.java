package Assignment4;

//Name: Qingyun Zhang ID:2095754

import Assignment4.BST;

public class Driver {

	public static void main(String[] args) {
        //Question 1
		int[] numbers = new int[20]; 
		for (int i=0;i<numbers.length;i++) {
			numbers[i]=(int)(Math.random()*21);
		}
		System.out.println("Question 1 output:");
		System.out.print("20 Random numbers: ");
		for (int j=0;j<numbers.length;j++) {
			System.out.print(numbers[j]+" ");
		}
		System.out.println();
		System.out.println("Does the array contain duplicates? " + containsDuplicate(numbers));
		System.out.println();
	
	    //Question 3
	    // Create a BST
	    BST<Integer> tree = new BST<>();
	    for (int k=0;k<numbers.length;k++) {
	    	tree.insert(numbers[k]);
	    }
	    System.out.println("Question 3 output:");
	    // Traverse tree
	    System.out.print("Inorder (sorted): ");
	    tree.inorder();
	    System.out.print("\nPostorder: ");
	    tree.postorder();
	    System.out.print("\nPreorder: ");
	    tree.preorder();
	    
	    System.out.println();
	    System.out.println();
	    

	    
	    //Question 6-1
	    System.out.println("Question 6-1 output:");
	    char[] chars = new char[20]; 
		for (int i=0;i<chars.length;i++) {
			chars[i]=(char)(65+(int)(Math.random()*26));
		}
		System.out.print("20 Random characters: ");
		for (int j=0;j<chars.length;j++) {
			System.out.print(chars[j]+" ");
		}
		System.out.println();
		System.out.println("Does the array contain duplicates? " + containsCharDuplicate(chars));
	
		System.out.println();
		//Question 6-3
		System.out.println("Question 6-3 output:");
	    // Create a BST
	    BST<Character> treeChar = new BST<>();
	    for (int k=0;k<chars.length;k++) {
	    	treeChar.insert(chars[k]);
	    }
	
	    // Traverse tree
	    System.out.print("Inorder (sorted): ");
	    treeChar.inorder();
	    System.out.print("\nPostorder: ");
	    treeChar.postorder();
	    System.out.print("\nPreorder: ");
	    treeChar.preorder();
	    
	    System.out.println();
	    System.out.println();
	    

	    
	    
	}
	
	
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Duplicate found
                }
            }
        }
        return false; // No duplicates found
    }

    public static boolean containsCharDuplicate(char[] charArr) {
        for (int i = 0; i < charArr.length; i++) {
            for (int j = i + 1; j < charArr.length; j++) {
                if (charArr[i] == charArr[j]) {
                    return true; // Duplicate found
                }
            }
        }
        return false; // No duplicates found
    }
    
}
