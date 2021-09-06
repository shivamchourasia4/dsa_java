import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Single source shortest path for unweighted graph.

it must be noted that all the shortest path algorithms work for both
directed and undirected graphs!

we add in both elements in undirected , in single element in directed(src to dest).

since it is unweighted so we assume that every node has unit (1) wt.
also, weight is kinda refrained from this code, instead we just add 1 when needed!
*/

public class shrtpthunwt {

    static ArrayList<ArrayList<Integer>> adj;
    static int V;

    shrtpthunwt(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int s, int v) {
        // lets just assume undirected.
        adj.get(s).add(v);
        adj.get(v).add(s);
    }

    void shrtpth(int src) {

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (i == src)
                al.add(0);
            else
                al.add(1000000);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        while (!queue.isEmpty()) {

            int temp = queue.poll();

            for (int x : adj.get(temp)) {

                // we compare cuur dist with incomming distance
                if (al.get(temp) + 1 < al.get(x)) {
                    al.set(x, al.get(temp) + 1);
                    queue.add(x);
                }

            }

        }

        for (int x : al) {
            System.out.print(x + " ");
        }

    }

    public static void main(String[] args) {

        shrtpthunwt g = new shrtpthunwt(9);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(6, 5);
        g.addEdge(6, 2);
        g.addEdge(6, 7);
        g.addEdge(6, 8);
        g.addEdge(8, 7);

        g.shrtpth(0);

    }
}
