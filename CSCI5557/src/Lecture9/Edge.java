package Lecture9;

//class to store edges of the weighted graph
class Edge {
  int src;  // source vertex number
  int dest;  // destination vertex number
  int weight;  // weight between the source and destination
  
  Edge(int src, int dest, int weight) {
          this.src = src;
          this.dest = dest;
          this.weight = weight;
      }
}
