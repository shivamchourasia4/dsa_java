import java.util.*;

public class BFS {

    private int V;
    // private LinkedList<Integer>[] adj;
    private LinkedList<LinkedList<Integer>> adj;

    // @SuppressWarnings("unchecked")
    BFS(int v) {
        V = v;
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++)
            adj.add(i, new LinkedList<Integer>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // To do it recursively, we just call the fn until the queue is empty
    // Iterative Approach
    void bfsUtil(int s, boolean visited[]) {

        // This linked list is only acting as a queue
        // Infact we implement a normal queue in Java using linked list only!

        Queue<Integer> qu = new LinkedList<Integer>();

        visited[s] = true;
        qu.add(s);

        while (qu.size() != 0) {
            s = qu.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj.get(s).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    qu.add(n);
                }
            }
        }
    }

    void bfs() {
        // we keep track of it as we may encounter a cycle
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                bfsUtil(i, visited);
        }
    }

    public static void main(String[] args) {
        BFS g = new BFS(5);

        // g.addEdge(0, 1);
        // g.addEdge(0, 2);
        // g.addEdge(1, 2);
        // g.addEdge(2, 0);
        // g.addEdge(2, 3);
        // g.addEdge(3, 3);

        // int v = 5;
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("BFS traversal : ");
        g.bfs();
    }
}
