package Final;

//Question Part 2

public class TestGraph {

	public static void main(String[] args) {
		//Question 1
		String[] vertices = {"1","2","3","4","5"};

		//Question 2
		int[][] edges = {{0,2},{0,3},{0,1},
		{1,0},{1,4},
		{2,0},{2,3},{2,4},
		{3,0},{3,2},
		{4,2},{4,1}};
		
		//Question 3
	    int[][] adjacencyMatrix = {
	    		  {0, 1, 0, 1, 0 }, // 1
	    		  {1, 0, 0, 0, 1 }, // 2
	    		  {1, 0, 0, 1, 1 }, // 3
	    		  {1, 0, 1, 0, 0 }, // 4
	    		  {0, 1, 1, 0, 0 }, // 5
	    		};
	    		// 1, 2, 3, 4, 5
		
	    //Question 4
	    Graph<String> graph1 = new UnweightedGraph<>(vertices,edges);
	    
	    //Question 6
	    UnweightedGraph<String>.SearchTree bfs = graph1.bfs(graph1.getIndex("1")); // Get a dfs starting at 1

	  	    java.util.List<Integer> searchOrders = bfs.getSearchOrder();
	  	    
	  	    System.out.println(bfs.getNumberOfVerticesFound() +
	  	      " Vertices are searched in this order:");
	  	    
	  	    for (int i = 0; i < searchOrders.size(); i++)
	  	      System.out.println(graph1.getVertex(searchOrders.get(i)));

	  	    for (int i = 0; i < searchOrders.size(); i++)
	  	      if (bfs.getParent(i) != -1)
	  	        System.out.println("parent of " + graph1.getVertex(i) + 
	  	          " is " + graph1.getVertex(bfs.getParent(i)));
	  	  }
	    


}

