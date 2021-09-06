import java.util.ArrayList;
import java.util.PriorityQueue;

//mst (only undirected! in diected , mst are known as arborescence (different thing!))
public class Prims {

    static ArrayList<ArrayList<Node>> adj;
    static int V;

    Prims(int v) {
        V = v;

        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    // we are assuming undirected here!
    void addEdge(int s, int d, int w) {
        adj.get(s).add(new Node(d, w));
        adj.get(d).add(new Node(s, w));
    }

    void mst() {

        int[] a = new int[V];
        int[] parent = new int[V];
        boolean[] mstSet = new boolean[V];
        for (int i = 0; i < V; i++) {
            a[i] = 1000000;
            parent[i] = -1;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(0, a[0]));
        a[0] = 0;

        // travel through the edges and if it is not a part of mst,
        // then add update its key val and add to queue so that it can be considered
        // next time as it will
        // be connected the current edges in mst!
        for (int i = 0; i < V; i++) {
            Node temp = queue.poll();

            mstSet[temp.dest] = false;

            for (Node x : adj.get(temp.dest)) {
                if (mstSet[x.dest] == false && x.wt < a[x.dest]) {
                    parent[x.dest] = temp.dest;
                    a[x.dest] = x.wt;
                    queue.add(new Node(x.dest, a[x.dest]));
                }
            }

        }

        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i);
        }

    }

    public static void main(String[] args) {

        Prims g = new Prims(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);

        g.mst();

    }
}
