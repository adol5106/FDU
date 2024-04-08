package Assignment4;

import Assignment4.BST;

public class DriverUniqueNumber {

	public static void main(String[] args) {
	    //Question 5
		//Unique Case
	    System.out.println("Question 5 unique output:");
        int size = 10; // Desired size of the array
        int[] uniqueNumbers = new int[size];
        int count = 0; // Counter for how many unique numbers have been added

        while (count < size) {
            int randomNumber = (int) (Math.random() * 21); // Generates a number in [0, 20]
            boolean isUnique = true;

            // Check if the generated number is already in the array
            for (int i = 0; i < count; i++) {
                if (uniqueNumbers[i] == randomNumber) {
                    isUnique = false;
                    break;
                }
            }

            // If the number is unique, add it to the array
            if (isUnique) {
                uniqueNumbers[count] = randomNumber;
                count++;
            }
        }
        // Printing the unique random numbers
        System.out.print("The unique character array: ");
        for (int num : uniqueNumbers) {
            System.out.print(num+" ");
        }
	    System.out.println();
	    
	    // Create a BST
	    BST<Integer> treeUnique = new BST<>();
	    for (int k=0;k<uniqueNumbers.length;k++) {
	    	treeUnique.insert(uniqueNumbers[k]);
	    }
	    
	    // Traverse tree
	    System.out.print("Inorder (sorted): ");
	    treeUnique.inorder();
	    System.out.print("\nPostorder: ");
	    treeUnique.postorder();
	    System.out.print("\nPreorder: ");
	    treeUnique.preorder();
	    
	    System.out.println();
	    System.out.println();
	    
	    //Repeated Case
		int[] numbers = new int[20]; 
		for (int i=0;i<numbers.length;i++) {
			numbers[i]=(int)(Math.random()*21);
		}
		System.out.println("Question 5 duplicated output:");
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
	    System.out.println("Question 5 duplicated transverse:");
	    // Traverse tree
	    System.out.print("Inorder (sorted): ");
	    tree.inorder();
	    System.out.print("\nPostorder: ");
	    tree.postorder();
	    System.out.print("\nPreorder: ");
	    tree.preorder();
	    
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
	
	
}
