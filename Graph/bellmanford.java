import java.util.ArrayList;

public class bellmanford {

    static ArrayList<ArrayList<Node>> adj;
    static int V;

    bellmanford(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    // directed here
    // (can't use undirected here when negative edge as a negative edge in
    // undirected would mean loop!!!)
    void addEdge(int s, int d, int w) {
        adj.get(s).add(new Node(d, w));
    }

    void bf(int s) {
        ArrayList<Integer> al = new ArrayList<>();

        // Step 1: Initialize distances from src
        // to all other vertices as INFINITE
        for (int i = 0; i < V - 1; i++) {
            if (i == s)
                al.add(0);
            else
                al.add(1000000);
        }

        // Step 2: Relax all edges |V| - 1 times.
        // A simple shortest path from src to any
        // other vertex can have at-most |V| - 1
        // edges
        for (int i = 0; i <= V - 1; i++) {

            for (int j = 0; j < adj.size(); j++) {
                for (Node x : adj.get(j)) {
                    if (al.get(j) + x.wt < al.get(x.dest)) {
                        al.set(x.dest, al.get(j) + x.wt);
                    }
                }
            }
        }

        boolean isneg = false;

        // Step 3: check for negative-weight cycles.
        // The above step guarantees shortest distances
        // if graph doesn't contain negative weight cycle.
        // If we get a shorter path, then there
        // is a cycle.
        for (int j = 0; j < adj.size(); j++) {
            for (Node x : adj.get(j)) {
                if (al.get(j) + x.wt < al.get(x.dest)) {
                    System.out.println("Negative Weight cycle found!");
                    isneg = true;
                    break;
                }
            }
        }

        if (!isneg) {
            for (int x : al) {
                System.out.print(x + " ");
            }
        }
    }

    public static void main(String[] args) {

        // shows shortest path as no neg cycle
        bellmanford g = new bellmanford(7);
        g.addEdge(0, 1, 5);
        g.addEdge(1, 5, -3);
        g.addEdge(1, 2, -2);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 2, 6);
        g.addEdge(5, 3, 1);
        g.addEdge(3, 4, -2);

        g.bf(0);

        System.out.println();
        // System.out.println("negative cycle eg - ");

        // negative cycle graph
        bellmanford g1 = new bellmanford(5);
        g1.addEdge(0, 1, 1);
        g1.addEdge(1, 2, -1);
        g1.addEdge(2, 3, -1);
        g1.addEdge(3, 0, -1);

        g1.bf(0);
    }
}
