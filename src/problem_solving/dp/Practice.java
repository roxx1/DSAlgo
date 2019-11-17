package problem_solving.dp;


// Java program to print DFS traversal from a given given graph

import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph {
    private int V; // No. of vertices

    // Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph      // 2 0 1 3
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, Set<Integer> visited) {
        // Mark the current node as visited and print it
        visited.add(v);
        System.out.println("v is " + v);
        System.out.println(visited);
        //System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited.contains(n))
                DFSUtil(n, visited);
        }
        visited.remove(v);
        System.out.println("v removed is " + v);
        System.out.println("Remaining set " + visited);
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        DFSUtil(v, new HashSet<Integer>());
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
            "(starting from vertex 2)");

        g.DFS(1);
    }
}
// This code is contributed by Aakash Hasija

