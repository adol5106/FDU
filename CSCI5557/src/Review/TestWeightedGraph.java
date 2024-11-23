package Review;

import java.util.ArrayList;
import java.util.List;

public class TestWeightedGraph {
	  public static void main(String[] args) {
	    String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
	      "Denver", "Kansas City", "Chicago", "Boston", "New York",
	      "Atlanta", "Miami", "Dallas", "Houston"};
	    
	    
	    int[] verticesInt = {0,1,2,3,4,5,6,7,8,9,10,11};
	    
	    Edge e1 = new Edge(0,1);
	    WeightedEdge e1w = new WeightedEdge(0,1,807);
	    
	    int[][] adjacencyMatrix = {
	    		  {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, // 0, Seattle
	    		  {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // 1, San Francisco
	    		  {0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, // 2, Los Angeles
	    		  {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0}, // 3, Denver
	    		  {0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0}, // 4, Kansas City
	    		  {1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0}, // 5, Chicago
	    		  {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, // 6, Boston
	    		  {0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0}, // 7, New York
	    		  {0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1}, // 8, Atlanta
	    		  {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, // 9, Miami
	    		  {0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1}, // 10, Dallas
	    		  {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0}  // 11, Houston
	    		};
	    		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11

	    List<Integer>[] neighbors = new ArrayList[12];
	    
	 // Initialize each ArrayList in the array
	    for (int i = 0; i < neighbors.length; i++) {
	        neighbors[i] = new ArrayList<Integer>();
	    }
	    
	   neighbors[0].add(1);
	    neighbors[0].add(3);
	    neighbors[0].add(5);
	    
	   neighbors[1].add(0);
	    neighbors[1].add(2);
	    neighbors[1].add(3);
	    
	    List<Edge>[] neighbors2 = new List[12];
	    
	 // Initialize each ArrayList in the array
	    for (int i = 0; i < neighbors2.length; i++) {
	        neighbors2[i] = new ArrayList<Edge>();
	    }
	    
	    neighbors2[0].add(new Edge(0,1));
	    neighbors2[0].add(new Edge(0,3));
	    neighbors2[0].add(new Edge(0,5));
	    
	    neighbors2[1].add(new Edge(1,0));
	    neighbors2[1].add(new Edge(1,2));
	    neighbors2[1].add(new Edge(1,3));
	    
	    List<ArrayList<Edge>> neighbors3 = new ArrayList<>();
	    
        // Initialize lists for each vertex as needed
        neighbors3.add(new ArrayList<Edge>());  // Adding list for vertex 0
        neighbors3.add(new ArrayList<Edge>());  // Adding list for vertex 1
	    
	    
	    
	    neighbors3.get(0).add(new Edge(0,1));
	    neighbors3.get(0).add(new Edge(0,3));
	    neighbors3.get(0).add(new Edge(0,5));
	    
	    neighbors3.get(1).add(new Edge(1,1));
	    neighbors3.get(1).add(new Edge(1,3));
	    neighbors3.get(1).add(new Edge(1,5));
	    
	    List<WeightedEdge>[] neighbors4 = new List[12];
	    
		 // Initialize each ArrayList in the array
	    for (int i = 0; i < neighbors4.length; i++) {
	        neighbors4[i] = new ArrayList<WeightedEdge>();
	    }
	    
	    
	    
	    neighbors4[0].add(new WeightedEdge(0,1,807));
	    neighbors4[0].add(new WeightedEdge(0,3,1331));
	    neighbors4[0].add(new WeightedEdge(0,5,2097));
	    
	    neighbors4[1].add(new WeightedEdge(1,0,807));
	    neighbors4[1].add(new WeightedEdge(1,2,381));
	    neighbors4[1].add(new WeightedEdge(1,3,1267));
	    
	    
	    

	    int[][] edges = {
	      {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
	      {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
	      {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
	      {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599}, 
	        {3, 5, 1003},
	      {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
	        {4, 8, 864}, {4, 10, 496},
	      {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533}, 
	        {5, 6, 983}, {5, 7, 787},
	      {6, 5, 983}, {6, 7, 214},
	      {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
	      {8, 4, 864}, {8, 7, 888}, {8, 9, 661}, 
	        {8, 10, 781}, {8, 11, 810},
	      {9, 8, 661}, {9, 11, 1187},
	      {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
	      {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
	    };

	    WeightedGraph<String> graph1 = 
	      new WeightedGraph<>(vertices, edges);
	    System.out.println("The number of vertices in graph1: " 
	      + graph1.getSize());
	    System.out.println("The vertex with index 1 is " 
	      + graph1.getVertex(1));
	    System.out.println("The index for Miami is " + 
	      graph1.getIndex("Miami"));
	    System.out.println("The edges for graph1:");
	    graph1.printWeightedEdges();

	    edges = new int[][] {
	      {0, 1, 2}, {0, 3, 8}, 
	      {1, 0, 2}, {1, 2, 7}, {1, 3, 3},
	      {2, 1, 7}, {2, 3, 4}, {2, 4, 5},
	      {3, 0, 8}, {3, 1, 3}, {3, 2, 4}, {3, 4, 6},
	      {4, 2, 5}, {4, 3, 6}
	    };
	    WeightedGraph<Integer> graph2 = new WeightedGraph<>(edges, 5);
	    System.out.println("\nThe edges for graph2:");
	    graph2.printWeightedEdges();
	  }
	}
