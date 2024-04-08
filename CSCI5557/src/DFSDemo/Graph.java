package DFSDemo;

import java.io.*; 
import java.util.*; 
   
//DFS Technique for undirected graph
class Graph { 
    private int vertices;   // No. of vertices 
   
    // adjacency list declaration
    private LinkedList<Integer>[] adjList; 
   
    // graph Constructor: to initialize adjacency lists as per no of vertices 
    Graph(int v) { 
        vertices = v; 
        adjList = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
        	adjList[i] = new LinkedList(); 
    } 
   
    //add an edge to the graph 
    void addEdge(int v, int w) { 
    	adjList[v].add(w);  // Add w to v's list. 
    } 
   
    // helper function for DFS technique
    void DFS_helper(int v,boolean visited[]) { 
        // current node is visited 
        visited[v] = true; 
        System.out.print(v+" "); 
   
        // process all adjacent vertices 
        Iterator<Integer> i = adjList[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFS_helper(n, visited); 
        } 
    } 
   
    
void DFS(int v) { 
        //initially none of the vertices are visited 
        boolean visited[] = new boolean[vertices]; 
   
        // call recursive DFS_helper function for DFS technique 
        DFS_helper(v, visited); 
    } 
}
