import java.util.ArrayList;
import java.util.PriorityQueue;

//kinda like a pair to store dest and weight both
class Node implements Comparable<Node> {

    int dest, wt;

    Node(int dest, int wt) {
        this.dest = dest;
        this.wt = wt;
    }

    @Override
    public int compareTo(Node o) {

        return dest - o.dest;
    }
}

public class dijkstra {

    static ArrayList<ArrayList<Node>> adj;
    static int V;

    dijkstra(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    // we suppose unidrected here
    void addEdge(int s, int d, int w) {
        adj.get(s).add(new Node(d, w));
        adj.get(d).add(new Node(s, w));
    }

    // this doesn't work in a graph with negative edge!!!
    void djk(int s) {

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            if (i == s)
                al.add(0);
            else
                al.add(1000000);
        }

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        pQueue.add(new Node(s, 0));

        while (!pQueue.isEmpty()) {

            Node temp = pQueue.poll();

            for (Node x : adj.get(temp.dest)) {
                if (al.get(temp.dest) + x.wt < al.get(x.dest)) {
                    al.set(x.dest, al.get(temp.dest) + x.wt);
                    pQueue.add(new Node(x.dest, x.wt));
                }
            }
        }

        for (int x : al) {
            System.out.print(x + " ");
        }

    }

    public static void main(String[] args) {
        dijkstra g = new dijkstra(6);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 4, 1);
        g.addEdge(3, 4, 3);
        g.addEdge(3, 2, 4);
        g.addEdge(5, 2, 5);
        g.addEdge(5, 3, 1);

        g.djk(1);
    }
}
