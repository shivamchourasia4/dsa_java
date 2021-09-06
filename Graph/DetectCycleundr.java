import java.util.LinkedList;

public class DetectCycleundr {

    static LinkedList<LinkedList<Integer>> adj;
    static int V;

    DetectCycleundr(int v) {
        V = v;
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<>());
        }
    }

    void addEdge(int a, int b) {
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    boolean isCyclicUtil(int s, boolean[] visited, int parent) {
        visited[s] = true;

        for (Integer i : adj.get(s)) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, s))
                    return true;

            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    boolean isCyclic() {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (isCyclicUtil(i, visited, -1))
                    return true;
        }

        return false;
    }

    public static void main(String[] args) {
        DetectCycleundr g1 = new DetectCycleundr(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        System.out.println(g1.isCyclic());

        DetectCycleundr g2 = new DetectCycleundr(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);

        System.out.println(g2.isCyclic());
    }

}
