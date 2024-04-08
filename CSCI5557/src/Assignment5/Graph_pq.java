package Assignment5;

import java.util.*;

public class Graph_pq { 
    int dist[]; 
    int[] predecessors;

    Set<Integer> visited; 
    PriorityQueue<Node> pqueue; 
    int V; // Number of vertices 
    List<List<Node> > adj_list; 
    //class constructor
    public Graph_pq(int V) { 
        this.V = V; 
        dist = new int[V]; 
        
        visited = new HashSet<Integer>(); 
        pqueue = new PriorityQueue<Node>(V, new Node()); 
        
        
        predecessors = new int[V];
        Arrays.fill(predecessors, -1); // Initialize all predecessors to -1 indicating no predecessor

    } 
   
    // Dijkstra's Algorithm implementation 
    public void algo_dijkstra(List<List<Node> > adj_list, int src_vertex) 
    { 
        this.adj_list = adj_list; 
   
        for (int i = 0; i < V; i++) 
            dist[i] = Integer.MAX_VALUE; 
   
        // first add source vertex to PriorityQueue 
        pqueue.add(new Node(src_vertex, 0)); 
   
        // Distance to the source from itself is 0 
        dist[src_vertex] = 0; 
        while (visited.size() != V) { 
 
   // u is removed from PriorityQueue and has min distance  
            int u = pqueue.remove().node; 
   
            // add node to finalized list (visited)
            visited.add(u); 
            graph_adjacentNodes(u); 
        } 
    } 
  // this methods processes all neighbours of the just visited node 
    private void graph_adjacentNodes(int u)   { 
        int edgeDistance = -1; 
        int newDistance = -1; 
   
        // process all neighbouring nodes of u 
        for (int i = 0; i < adj_list.get(u).size(); i++) { 
            Node v = adj_list.get(u).get(i); 
   
            //  proceed only if current node is not in 'visited'
            if (!visited.contains(v.node)) { 
                edgeDistance = v.cost; 
                newDistance = dist[u] + edgeDistance; 
   
                // compare distances 
                if (newDistance < dist[v.node]) {
                    dist[v.node] = newDistance; 
                    predecessors[v.node] = u; // Set predecessor
                }
                // Add the current vertex to the PriorityQueue 
                pqueue.add(new Node(v.node, dist[v.node])); 
            } 
        } 
    } 
    public List<Integer> getPath(int target) {
        LinkedList<Integer> path = new LinkedList<>();
        for(int at = target; at != -1; at = predecessors[at]) {
            path.addFirst(at);
        }
        if (path.size() == 1 && path.get(0) != target) { // If only contains source and doesn't match target
            return Collections.emptyList(); // Path doesn't exist
        }
        return path;
    }


}
