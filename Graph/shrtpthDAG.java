import java.util.ArrayList;
import java.util.Stack;

// for better time complexity in dag i.e O(V+E)
// dijkstra(non neg) and bellman also work but this has better time complexity
public class shrtpthDAG {

    static ArrayList<ArrayList<Node>> adj;
    static int V;

    shrtpthDAG(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int wt) {
        adj.get(u).add(new Node(v, wt));
    }

    // topologically sort the graph
    // for each vertex in the sorted list
    // take the adj edges and relax!!

    void tplhlrp(int s, boolean[] visited, Stack<Integer> st) {

        visited[s] = true;

        for (Node x : adj.get(s)) {
            if (!visited[x.dest]) {
                tplhlrp(x.dest, visited, st);
            }
        }

        st.push(s);

    }

    void shrtpth(int s) {

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                tplhlrp(i, visited, st);
            }
        }

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (i == s)
                al.add(0);
            else
                al.add(1000000);

        }
        // relaxing the topologically sorted list

        while (!st.isEmpty()) {

            int temp = st.pop();
            for (Node x : adj.get(temp)) {

                if (al.get(temp) + x.wt < al.get(x.dest)) {
                    al.set(x.dest, al.get(temp) + x.wt);
                }

            }

        }

        System.out.println(al);

    }

    public static void main(String[] args) {

        shrtpthDAG g = new shrtpthDAG(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        g.shrtpth(1);

    }
}
