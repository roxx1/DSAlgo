package data_structures.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {

    private static boolean adjMatrix[][];
    private static int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new boolean[vertices][vertices];
    }

    public static boolean isEdge(int i, int j) {
        return adjMatrix[i][j];
    }

    public static void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    public static Graph createGraph() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        return g;
          /* Outputs
           0: 0 1 1 0
           1: 1 0 1 0
           2: 1 1 0 1
           3: 0 0 1 0
          */
    }


    public static void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " => ");

        for (int i = 0; i < vertices; i++) {
            final boolean w = adjMatrix[v][i];
            if (w) {
                if (!visited[i]) {
                    dfs(i, visited);
                }
            }
        }
    }

    public static void bfs(int v, Queue<Integer> queue, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " => ");

        for (int i = 0; i < vertices; i++) {
            final boolean w = adjMatrix[v][i];
            if (w) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        if (queue.isEmpty())
            return;

        final Integer ve = queue.poll();
        bfs(ve, queue, visited);
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        final Graph graph = createGraph();
        System.out.println(graph.toString());

        boolean visited[];

        visited = new boolean[vertices];
        dfs(2, visited);

        System.out.println();

        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[vertices];
        bfs(3, queue, visited);
        queue.clear();
    }

}
