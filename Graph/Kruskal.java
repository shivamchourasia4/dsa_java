import java.util.ArrayList;
import java.util.Collections;

class Nodes implements Comparable<Nodes> {
    int src, dest, wt;

    Nodes(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    @Override
    public int compareTo(Nodes o) {
        return wt - o.wt;
    }

}

public class Kruskal {

    // simple array list works here!
    static ArrayList<Nodes> adj;
    static int V;
    static int[] parent;
    static int[] rank;

    Kruskal(int v) {
        V = v;
        adj = new ArrayList<>();

        parent = new int[V];
        rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

    }

    // only for undirected!!
    void addEdge(int a, int b, int wt) {
        adj.add(new Nodes(a, b, wt));
    }

    // disjoint set utilities

    int findParent(int a) {
        if (a == parent[a])
            return parent[a];

        return parent[parent[a]];
    }

    void union(int a, int b) {
        int u = findParent(a);
        int v = findParent(b);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u] += 1;
        }
    }

    void mst() {

        Collections.sort(adj);

        int cost = 0;

        ArrayList<Nodes> ans = new ArrayList<>();

        for (Nodes temp : adj) {
            if (findParent(temp.dest) != findParent(temp.src)) {
                cost += temp.wt;
                ans.add(temp);
                union(temp.dest, temp.src);
            }
        }

        System.out.println("Cost of mst = " + cost);

        for (Nodes temp : ans) {
            System.out.println(temp.src + " - " + temp.dest);
        }
    }

    public static void main(String args[]) {
        Kruskal g = new Kruskal(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);

        g.mst();

        Kruskal g1 = new Kruskal(7);
        g1.addEdge(1, 4, 1);
        g1.addEdge(1, 2, 2);
        g1.addEdge(1, 5, 4);
        g1.addEdge(2, 4, 3);
        g1.addEdge(5, 4, 9);
        g1.addEdge(2, 3, 3);
        g1.addEdge(2, 6, 7);
        g1.addEdge(3, 6, 8);

        g1.mst();
    }
}
