
import java.util.*;
 
// This class represents a directed graph using adjacency
// list representation
class Breadth {
    private int V; // No. of vertices
    private LinkedList<Integer> array[]; // Adjacency Lists
 
    // Constructor
    @SuppressWarnings({ "unchecked", "rawtypes" })
	Breadth(int v)
    {
        V = v;
        array = new LinkedList[v];
        for (int i = 0; i < v; ++i)
        	array[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w) { array[v].add(w); }
 
    // prints BFS traversal from a given source
    void BFS(int source)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue
            = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);
 
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
        	source = queue.poll();
            System.out.print(source + " ");
 
            // Get all adjacent vertices of the dequeued
            // vertex s If a adjacent has not been visited,
            // then mark it visited and enqueue it
            Iterator<Integer> i = array[source].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
 
}