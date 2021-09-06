import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//basically using bfs to implement topological sorting!
public class Kahns {

    static ArrayList<ArrayList<Integer>> adj;
    static int V;

    Kahns(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    void toplsrtBFS() {

        // to check if the graph contains cycle!
        // if count is not equal to the number of edges the there is not a cycle
        int cnt = 0;

        int[] degree = new int[V];
        // boolean[] visited = new boolean[V]; not needed
        Queue<Integer> queue = new LinkedList<>();

        // initializing indegree of vertices.
        // for (int i = 0; i < V; i++) {
        // degree[i] = 0;
        // }

        for (int i = 0; i < adj.size(); i++) {
            for (int x : adj.get(i)) {
                degree[x] += 1;
            }
        }

        // pushing vertices with indegree 0
        for (int i = 0; i < V; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {

            int p = queue.poll();
            System.out.print(p + " ");
            ArrayList<Integer> temp = adj.get(p);

            for (int x : temp) {
                degree[x] -= 1;
                if (degree[x] == 0) {
                    queue.add(x);
                }
            }
            cnt++;

        }

        if (cnt != V) {
            System.out.println("Graph is not DAG");
        }

    }

    public static void main(String[] args) {
        Kahns g = new Kahns(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.toplsrtBFS();
    }
}
