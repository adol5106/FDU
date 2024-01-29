package Lecture1;

public class ClassAssignment {

	public static void main(String[] args) {
		String[] stringArray= {"gp","Wa","pp","zy","Y1"};
		char[] charArray= {'a','p','b','d','c'};
		
	    //Before sorting
	    System.out.println("Before sorting:");
	    displayArrayString(stringArray);
		
	    selectionSortString(stringArray);
	    
	    //After sorting
	    System.out.println("After sorting:");
	    displayArrayString(stringArray);
		
		
		
	}
	
	
	//Method that implements Selection Sort in characters
	public static void selectionSort(char[] array){
	    // One by one move boundary of unsorted subarray
	    for (int i = 0; i < array.length-1; i++) {

	        // Find the minimum element in unsorted array
	        int min_idx = i;
	        for (int j = i+1; j < array.length; j++){
	            if (array[j] < array[min_idx]) {
	                min_idx = j;
	            }
	        }
	 
	        // Swap the found minimum element with the first element
	        char temp = array[min_idx];
	        array[min_idx] = array[i];
	        array[i] = temp;
	    }
		
		
	}
	
	
	
	public static void displayArray(char[] array) {
		for (int k=0; k<array.length;k++) {
			System.out.println(array[k]);
	}
	}
	

	//Method that implements Selection Sort in characters
	public static void selectionSortString(String[] array){
	    // One by one move boundary of unsorted subarray
	    for (int i = 0; i < array.length-1; i++) {

	        // Find the minimum element in unsorted array
	        int min_idx = i;
	        for (int j = i+1; j < array.length; j++){
	            if (array[j].compareTo(array[min_idx])<0) {
	                min_idx = j;
	            }
	        }
	 
	        // Swap the found minimum element with the first element
	        String temp = array[min_idx];
	        array[min_idx] = array[i];
	        array[i] = temp;
	    }
		
	}
	
	
	public static void displayArrayString(String[] array) {
		for (int k=0; k<array.length;k++) {
			System.out.println(array[k]);
	}
	}
	
}





