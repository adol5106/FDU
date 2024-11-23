package Final;



public class TestWeightedGraph {

	public static void main(String[] args) {
	 

	    //Question 8.1
	       int graph[][] = new int[][] { { 0, 3, 4, 2, 0}, //1
	            						{ 3, 0, 0, 0, 6},  //2
	            						{ 4, 0, 0, 1, 5},  //3
	            						{ 2, 0, 1, 0, 0},  //4
	            						{ 0, 6, 5, 0, 0}   //5
	            						}; 
                                        //1 ,2, 3, 4, 5
	  	//Question 8.2, 8.3 and 8.4
 
         Graph_Shortest_Path g = new Graph_Shortest_Path(); 
         g.algo_dijkstra(graph, 2); 
	}

}
