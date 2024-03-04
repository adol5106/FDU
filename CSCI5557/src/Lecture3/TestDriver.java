package Lecture3;

public class TestDriver {

	public static void main(String[] args) {
		MyArrayList<String> myList = new MyArrayList<>();

		
		myList.add("Milk");
		myList.add("Eggs");
		myList.add(1,"Apples");
		
	   for (String s: myList) {	
		System.out.print(s+" ");
	   }
	

}
}