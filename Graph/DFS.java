//package Graph;

import java.util.*;

public class DFS {
    private int V;
    // private LinkedList<Integer> adj[];
    private LinkedList<LinkedList<Integer>> adj;

    // @SuppressWarnings("unchecked")
    DFS(int v) {
        V = v;
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++)
            adj.add(i, new LinkedList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // Recursive Approach
    void DFStbu(int v, boolean[] visited) {

        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj.get(v).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFStbu(n, visited);
        }
    }

    void dfs() {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                DFStbu(i, visited);
        }
    }

    // -------------Iterative Approach Using Stack

    void dfsitrUtil(int s, boolean[] visited) {

        Stack<Integer> st = new Stack<>();

        st.push(s);
        while (!st.isEmpty()) {
            int n = st.peek();
            st.pop();
            if (!visited[n]) {
                System.out.print(n + " ");
                visited[n] = true;
            }

            for (Integer i : adj.get(s)) {
                if (!visited[i]) {
                    st.push(i);
                }
            }

        }
    }

    void dfsitr() {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsitrUtil(i, visited);
            }
        }

    }

    public static void main(String[] args) {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // g.addEdge(1, 0);
        // g.addEdge(2, 1);
        // g.addEdge(3, 4);
        // g.addEdge(4, 0);

        System.out.println("DFS traversal : ");
        g.dfs();
        System.out.println("DFS traversal itr: ");
        g.dfsitr();
        // for iterative dfs , use a stack and pop and push resp while stack is not
        // empty! and reverse iterator shall also be used
    }
}
