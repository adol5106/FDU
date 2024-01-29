
public class Demo1 {

	public static void main(String[] args) {
		System.out.println("Hello, world!");

		int[] array = {11,55,33,22,77,88,44};
	    int n = array.length;
	    
	    //Before sorting
	    System.out.println("Before sorting:");
	    displayArray(array);
	    
        insertionSort(array);
	   
	    //After sorting 
	    System.out.println("After Sorting:");
	    displayArray(array);
	}

	
	
	//Method that implements Selection Sort
	public static void selectionSort(int[] array){
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
	        int temp = array[min_idx];
	        array[min_idx] = array[i];
	        array[i] = temp;
	    }
		
		
	}
	
	public static void displayArray(int[] array) {
		for (int k=0; k<array.length;k++) {
			System.out.println(array[k]);
	}
	
	
	
	}
	
	public static void insertionSort(int[] myList) {
	    for (int i = 1; i < myList.length; i++) {
	        int currentElement = myList[i];

	        int j;
	        for (j = i - 1; j >= 0 && myList[j] > currentElement; j--) {
	            myList[j + 1] = myList[j];
	        }
	    
	        myList[j + 1] = currentElement;
	    }

		
		
	}
	
}
