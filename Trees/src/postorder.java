import java.util.Stack;

public class postorder {

    public static void post(Node root) {
        if (root != null) {
            post(root.left);
            post(root.right);
            System.out.print(root.data + " ");
        }
    }

    // pushing root two times
    public static void itr2(Node root) {

        Stack<Node> st = new Stack<>();

        while (true) {
            while (root != null) {
                st.push(root);
                st.push(root);
                root = root.left;
            }

            if (st.isEmpty()) {
                return;
            }

            root = st.pop();
            if (!st.isEmpty() && st.peek() == root) {
                root = root.right;
            } else {
                System.out.print(root.data + " ");
                root = null;
            }
        }

    }

    public static void iterativepost(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> st = new Stack<>();
        st.push(root);

        Node prev = null;

        while (!st.isEmpty()) {
            Node curr = st.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                // traverse from top to bottom and if curr has left or right child,
                // push it in the stack otherwise pop it out!

                if (curr.left != null)
                    st.push(curr.left);

                else if (curr.right != null)
                    st.push(curr.right);

            } else if (curr.left == prev) {
                if (curr.right != null)
                    st.push(curr.right);

            } else {
                System.out.print(curr.data + " ");
                st.pop();
            }

            prev = curr;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        post(root);
        System.out.println("itr - ");
        iterativepost(root);
        System.out.println("itr2 - ");
        itr2(root);
    }
}
