package Assignment4;

import Assignment4.BST;

public class DriverUnqiueChar {

	public static void main(String[] args) {
	    //Question 6-5
		//Unique Case
	    System.out.println("Question 6-5 unique output:");
	    int sizeChar = 10;
        char[] uniqueChars = new char[sizeChar];
        int countChar = 0; // Counter for how many unique numbers have been added

        while (countChar < sizeChar) {
            char randomChar = (char)(65+(int)(Math.random() * 26)); // Generates a number in [0, 20]
            boolean isUniqueChar = true;

            // Check if the generated number is already in the array
            for (int i = 0; i < countChar; i++) {
                if (uniqueChars[i] == randomChar) {
                    isUniqueChar = false;
                    break;
                }
            }

            // If the number is unique, add it to the array
            if (isUniqueChar) {
            	uniqueChars[countChar] = randomChar;
            	countChar++;
            }
        }
        // Printing the unique random numbers
        System.out.print("The unique character array: ");
        for (char c : uniqueChars) {
            System.out.print(c+" ");
        }
	    System.out.println();
	    
	    
	    // Create a BST
	    BST<Character> treeUniqueChar = new BST<>();
	    for (int k=0;k<uniqueChars.length;k++) {
	    	treeUniqueChar.insert(uniqueChars[k]);
	    }
	    
	    // Traverse tree
	    System.out.print("Inorder (sorted): ");
	    treeUniqueChar.inorder();
	    System.out.print("\nPostorder: ");
	    treeUniqueChar.postorder();
	    System.out.print("\nPreorder: ");
	    treeUniqueChar.preorder();
	    
	    System.out.println();
	    System.out.println();
	    
	    
	    //Repeated Case
	    System.out.println("Question 6-5 duplicated output:");
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
		System.out.println("Question 6-5 duplicated transverse:");
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
