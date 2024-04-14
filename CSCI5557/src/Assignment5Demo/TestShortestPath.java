package Assignment5Demo;

//Name: Qingyun Zhang
//ID: 2095754
//Question 4

import java.util.List;
import java.util.*;

public class TestShortestPath {

	
	  public static void main(String[] args) {
	    String[] vertices = {"Olympia","Salem","Sacramento","Boise","Carson City","Helena","Salt Lake City","Bismarck","Pierre","Cheyenne","Denver","Lincoln"};

	    int[][] edges = {
	      {0, 3, 536}, {0, 1, 160}, 
	      {1, 3, 449}, {1, 4, 516}, {1, 2, 536},
	      {2, 4, 130}, 
	      {3, 5, 449}, {3, 6, 339}, {3, 9, 735},
	      {4, 3, 450}, {4, 6, 546},
	      {5, 9, 692}, {5, 7, 613}, {5, 8, 701},
	      {6, 9, 500}, {6, 10, 525},
	      {7, 8, 205}, 
	      {8, 11, 396}, 
	      {9, 8, 424}, {9, 11, 442}, 
	      {10, 11, 525}, {10, 9, 112},
	    };

	    // Create a weighted graph
	    WeightedGraph<String> graph = new WeightedGraph<>(vertices, edges);
	    
	    // Build a search tree with Olympia being the source vertex
	    WeightedGraph<String>.ShortestPathTree tree = graph.getShortestPath(graph.getIndex("Olympia"));
	    
	    // Print all shortest paths starting from Olympia
	    tree.printAllPaths();

        
	    List<String> path = tree.getPath(graph.getIndex("Denver")); // root is Olympia
	    //System.out.print(graph.getIndex("Denver"));
	    
	    System.out.println();
	    System.out.println("The distance in miles between Olympia and Denver is "+tree.getCost(findIndex(vertices, "Denver")));
	    
	    revlist(path);
	    
	    // Display shortest path from Olympia to Denver
	    System.out.println();
	    System.out.print("Shortest Path from Olympia to Denver: ");
	    
	    for (String s: path) {
	      System.out.print(s);
	      if (s!=path.get(path.size()-1))
	        System.out.print(" -> ");
	    }
	    
	  }

	    public static <T> void revlist(List<T> list)
	    {
	        // base condition when the list size is 0 
	        if (list.size() <= 1 || list == null)
	            return;
	 
	       
	        T value = list.remove(0);
	       
	        // call the recursive function to reverse 
	        // the list after removing the first element 
	        revlist(list);
	 
	        // now after the rest of the list has been 
	        // reversed by the upper recursive call, 
	        // add the first value at the end
	        list.add(value);
	    }
	    
	    public static int findIndex(String[] array, String value) {
	        // Loop through the array
	        for (int i = 0; i < array.length; i++) {
	            // Check if the current array element equals the value
	            if (array[i] == value) {
	                return i; // Return the index of the element
	            }
	        }
	        return -1; // Return -1 if the value is not found
	    }
}
