
import java.util.*;
 
class Depth {
    private int V; // No. of vertices
 
    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> array[];
 
    // Constructor
    @SuppressWarnings({ "unchecked", "rawtypes" }) Depth(int v)
    {
        V = v;
        array = new LinkedList[v];
        for (int i = 0; i < v; ++i)
        	array[i] = new LinkedList();
    }
 
    // Function to add an edge
    void addEdge(int v, int w)
    {
    	array[v].add(w); // Add w to v's list.
    }
 
    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = array[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        DFSUtil(v, visited);
    }
 
}