import java.util.*;

public class DetectCycledirct {

    static LinkedList<LinkedList<Integer>> adj;
    static int V;

    DetectCycledirct(int v) {
        V = v;
        adj = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new LinkedList<>());
        }
    }

    void addEdge(int s, int d) {
        adj.get(s).add(d);
    }

    boolean isCyclicUtil(int s, boolean[] visited, boolean[] recStack) {

        if (recStack[s]) {
            return true;
        }

        if (visited[s]) {
            return false;
        }

        visited[s] = true;
        recStack[s] = true;

        for (Integer i : adj.get(s)) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        recStack[s] = false;
        return false;
    }

    boolean isCyclic(int v) {
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DetectCycledirct graph = new DetectCycledirct(8);
        // graph.addEdge(0, 1);
        // graph.addEdge(0, 2);
        // graph.addEdge(1, 2);
        // graph.addEdge(2, 0);
        // graph.addEdge(2, 3);
        // graph.addEdge(3, 3);

        // graph.addEdge(0, 1);
        // graph.addEdge(0, 2);
        // graph.addEdge(1, 2);
        // graph.addEdge(2, 3);

        graph.addEdge(6, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 7);
        graph.addEdge(7, 5);
        graph.addEdge(5, 1);
        graph.addEdge(1, 3);
        graph.addEdge(5, 6);

        System.out.println(graph.isCyclic(8));

    }

}