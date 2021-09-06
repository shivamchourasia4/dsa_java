import java.util.*;

public class ImpGraph {

    static LinkedList<Integer> adj[];
    static int V;

    @SuppressWarnings("unchecked")
    ImpGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    void addEdge(int a, int b) {
        adj[a].add(b);
    }

    void printGraph(int s) {

        Iterator<Integer> it = adj[s].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            System.out.println(n);
        }

    }

    public static void main(String[] args) {
        ImpGraph g = new ImpGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Traversing the Graph: ");
        g.printGraph(0);

    }

}
