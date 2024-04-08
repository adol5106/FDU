package DijkstraDemo2;

public class TestDriver {

	public static void main(String[] args) {
        //example graph is given below
        int graph[][] = new int[][] { { 0, 2, 1, 0, 0, 0}, 
                                      { 2, 0, 7, 0, 8, 4}, 
                                      { 1, 7, 0, 7, 0, 3}, 
                                      { 0, 0, 7, 0, 8, 4}, 
                                      { 0, 8, 0, 8, 0, 5}, 
                                      { 0, 4, 3, 4, 5, 0} }; 
        Graph_Shortest_Path g = new Graph_Shortest_Path(); 
        g.algo_dijkstra(graph, 0); 
	}

}
