/*
 * Main class that uses DFS and BFS graph traversal algorithms. 
 * Read the input graph from a .txt file. An adjacency matrix is used to store a directed graph. 
 * It asks the user to input the file name first and then will output the DFS and BFS traversal results.
 * File format has 5 vertices
 * CSCIU-432-01-Spring-2023
 * Kimberly Lanford
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("unused")
	private int numVertices;
    private static int[][] adjacencyMatrix;
    @SuppressWarnings("unused")
	private ArrayList<Integer> dfsTraversal;
    @SuppressWarnings("unused")
	private ArrayList<Integer> bfsTraversal;

    // scans the text file that is 5 by 5 into a 2D array adjacencyMatrix; 
    //  prints statement if file doesn't exist 
    public static void readText(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            
            adjacencyMatrix = new int[5][5];
            	for (int i = 0; i < 5; i++) {
            		  for (int j = 0; j < 5; j++) {
            		    if (!scanner.hasNextInt()) break;
            		    adjacencyMatrix[i][j] = scanner.nextInt();
            		  }
            		  if (!scanner.hasNextInt()) break;
            		}

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // method that can print the 2d array to check if it was read in successfully 
	public static void print2DArray(int[][] array) {
    	  for (int[] row : array) {
    	    for (int value : row) {
    	      System.out.print(value + " ");
    	    }
    	    System.out.println();
    	  }
    	}
    
    @SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
       // fileName = "C:\\Users\\Kimberly\\Documents\\uscupstate\\Algoriths\\AdjacencyMatrix.txt";
        readText(fileName);
        
       
        // adds the adjacencyMatrix to Breadth's addEdge function and Depth's addEdge function
        Breadth b = new Breadth(5);
        Depth d = new Depth(5);
        for (int i = 0; i < 5; i++) {
  		  for (int j = 0; j < 5; j++) {
  		    if(adjacencyMatrix[i][j] == 1)
  		    	b.addEdge(i, j);
  		    	d.addEdge(i, j);
  		  }
        }
        
        // prints the Breadth First Search as well as Depth First Search 
        System.out.println("Following is Breadth First Traversal: ");
        b.BFS(0);
        System.out.println();
        System.out.println("Following is Depth First Traversal: ");
        d.DFS(0);
        
        //print2DArray(adjacencyMatrix);	// this was to test the array
    }


}

