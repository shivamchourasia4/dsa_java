
/* 
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

For example, a topological sorting of the following graph is “5 4 2 3 1 0”. There can be more than one topological sorting for a graph. For example, another topological sorting of the following graph is “4 5 2 3 1 0”. The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no incoming edges).
*/
/* 
 In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices. In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of the stack. Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in the stack. 

*/
import java.util.ArrayList;
import java.util.Stack;

public class ToplsrtDFS {
    static ArrayList<ArrayList<Integer>> adj;
    static int V;

    ToplsrtDFS(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    void Tpl(int s, boolean[] visited, Stack<Integer> st) {
        visited[s] = true;

        for (Integer i : adj.get(s)) {
            if (!visited[i]) {
                Tpl(i, visited, st);
            }
        }
        st.push(s);
    }

    void TopologicalSort() {

        boolean visited[] = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                Tpl(i, visited, st);
        }

        // printing the stack
        while (!st.isEmpty()) {
            int n = st.peek();
            System.out.print(n + " ");
            st.pop();
        }

    }

    public static void main(String[] args) {
        ToplsrtDFS g = new ToplsrtDFS(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.TopologicalSort();

    }
}
