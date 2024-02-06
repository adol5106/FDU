package Lecture2;

public class BubbleSortChar {

	public static void main(String[] args) {
		char[] array= {'A','V','K','F'}; 
		
		displayArray(array);
		
	    bubbleSort(array);
		System.out.println();
		displayArray(array);

	}

	
	

	
	
	public static void bubbleSort(char[] myList) {
			boolean needNextPass = true;
		    
			for (int k = 1; k < myList.length && needNextPass; k++) {
			      needNextPass = false;
			      
			      for (int i = 0; i < myList.length - k; i++) {
			        if (myList[i] > myList[i + 1]) {
			          char temp = myList[i];
			          myList[i] = myList[i + 1];
			          myList[i + 1] = temp;
			          
			          needNextPass = true; // Next pass still needed
			        }
			      }
			}
		 
	 }	
	
	 public static void displayArray(char[] array) {
		 for (int i=0;i<array.length;i++) {
			 System.out.print(array[i]+" ");
			 
			 
			 
		 }
		 
		 
	 }
}
