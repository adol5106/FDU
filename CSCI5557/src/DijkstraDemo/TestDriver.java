package DijkstraDemo;

import java.util.*;

public class TestDriver {

    public static void main(String arg[])   { 
        int V = 12; 
        int source = 0; 
        // adjacency list representation of graph
        List<List<Node> > adj_list = new ArrayList<List<Node> >(); 
        // Initialize adjacency list for every node in the graph 
        for (int i = 0; i < V; i++) { 
            List<Node> item = new ArrayList<Node>(); 
            adj_list.add(item); 
        } 
 
   
        // Input graph edges 
        adj_list.get(0).add(new Node(3, 5)); 
        adj_list.get(0).add(new Node(2, 3)); 
        adj_list.get(0).add(new Node(3, 2)); 
        adj_list.get(0).add(new Node(4, 3));
        adj_list.get(0).add(new Node(5, 3));
        adj_list.get(2).add(new Node(1, 2)); 
        adj_list.get(2).add(new Node(3, 3)); 
        // call Dijkstra's algo method  
        Graph_pq dpq = new Graph_pq(V); 
        dpq.algo_dijkstra(adj_list, source); 
   
        // Print the shortest path from source node to all the nodes 
        System.out.println("The shorted path from source node to other nodes:"); 
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < dpq.dist.length; i++) 
            System.out.println(source + " \t\t " + i + " \t\t "  + dpq.dist[i]); 
    } 
}
