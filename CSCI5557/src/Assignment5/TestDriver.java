package Assignment5;

import java.util.*;

//Name:Qingyun Zhang  ID:2095754
//Question 4

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
        adj_list.get(0).add(new Node(3, 536)); 
        adj_list.get(0).add(new Node(1, 160)); 
        adj_list.get(1).add(new Node(3, 449)); 
        adj_list.get(1).add(new Node(4, 516));
        adj_list.get(1).add(new Node(2, 536));
        adj_list.get(2).add(new Node(4, 130)); 
        adj_list.get(3).add(new Node(5, 449)); 
        adj_list.get(3).add(new Node(6, 339));
        adj_list.get(3).add(new Node(9, 735));
        adj_list.get(4).add(new Node(3, 450));
        adj_list.get(4).add(new Node(6, 546));
        adj_list.get(5).add(new Node(9, 692));
        adj_list.get(5).add(new Node(7, 613));
        adj_list.get(5).add(new Node(8, 701));
        adj_list.get(6).add(new Node(9, 500));
        adj_list.get(6).add(new Node(10, 525));
        adj_list.get(7).add(new Node(8, 205));
        adj_list.get(8).add(new Node(11, 396));
        adj_list.get(9).add(new Node(8, 424));
        adj_list.get(9).add(new Node(11, 442));
        adj_list.get(10).add(new Node(11, 525));
        adj_list.get(10).add(new Node(9, 112));
        
        
        // call Dijkstra's algo method  
        Graph_pq dpq = new Graph_pq(V); 
        dpq.algo_dijkstra(adj_list, source); 
        
        //List all of the cities
        String[] cities= {"Olympia","Salem","Sacramento","Boise","Carson City","Helena","SaltLakeCity","Bismarck","Pierre","Cheyenne","Denver","Lincoln"};
        
   
        // Print the shortest path from source node to all the nodes 
        System.out.println("The shorted path from source node to other nodes:"); 
        System.out.println("Source\t\t" + "  Node#\t\t" + "    Distance");
        
        System.out.println(cities[0] + " \t " + cities[10] + "  \t\t"  + dpq.dist[10]); 
        
        System.out.println();
        
        //Create a linkedlist for the shortest path based on city names
        List<Integer> path = dpq.getPath(10);
        List<String> cityPath = new LinkedList<>();
        for (int i:path) {
        	cityPath.add(cities[i]);
        }
        

        // Print the path
        if (path.isEmpty()) {
            System.out.println("No path exists from " + cities[0] + " to " + cities[10]);
        } else {
            System.out.println("Shortest path from " + cities[0] + " to " + cities[10] + ": " + cityPath);
        }
        
        
    }
}
