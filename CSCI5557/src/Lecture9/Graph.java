package Lecture9;
import java.util.*;

//Graph class
class Graph {
 // node of adjacency list 
 static class Node {
     int value; //
     int weight;
     Node(int value, int weight)  {
         this.value = value;
         this.weight = weight;
     }
 }

//define adjacency list
List<List<Node>> adjList = new ArrayList<>();

//Graph Constructor
public Graph(List<Edge> edges)
{
    // adjacency list memory allocation
    for (int i = 0; i < edges.size(); i++)
        adjList.add(i, new ArrayList<>());

    // add edges to the graph
    for (Edge e : edges)
    {
        // allocate new node in adjacency List from src to dest
        adjList.get(e.src).add(new Node(e.dest, e.weight));
    }
}

//print adjacency list for the graph
public static void printGraph(Graph graph)  {
    int src_vertex = 0;
    int list_size = graph.adjList.size();

    System.out.println("The contents of the graph:");
    while (src_vertex < list_size) {
        //traverse through the adjacency list and print the edges
        for (Node edge : graph.adjList.get(src_vertex)) {
            System.out.print("Vertex:" + src_vertex + " ==> " + edge.value + 
                            " (" + edge.weight + ")\t");
        }

        System.out.println();
        src_vertex++;
    }
}

}