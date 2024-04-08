package Lecture6;

import java.util.Comparator;

public class CustomComparator implements Comparator<String>{
	
	public int compare(String item1, String item2) {
		
		return item2.length() - item1.length();
	}
	
	
	


}
