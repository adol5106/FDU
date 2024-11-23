package Final;


public class TestGraphDFS {

	public static void main(String[] args) {
		//Question 1
		String[] vertices2 = {"1","2","3","4","5"};

		//Question 2
		int[][] edges2 = {{0,2},{0,3},{0,1},
		{1,0},{1,4},
		{2,0},{2,3},{2,4},
		{3,0},{3,2},
		{4,2},{4,1}};
	







	
     //Question 5
    Graph<String> graph2 = new UnweightedGraph<>(vertices2, edges2);
    
    UnweightedGraph<String>.SearchTree dfs = graph2.dfs(graph2.getIndex("1")); // Get a dfs starting at Chicago

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph2.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph2.getVertex(i) +" is " + graph2.getVertex(dfs.getParent(i)));
}
}
