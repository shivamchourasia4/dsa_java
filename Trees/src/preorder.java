import java.util.Stack;

public class preorder {

    // recursive preorder
    public static void pre(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            pre(root.left);
            pre(root.right);
        }
    }

    // iterative preorder

    public static void iterativepre(Node root) {
        Stack<Node> st = new Stack<>();

        if (root == null) {
            return;
        }

        st.push(root);

        while (!st.isEmpty()) {
            Node temp = st.pop();
            System.out.print(temp.data + " ");

            if (temp.right != null) {
                st.push(temp.right);
            }

            if (temp.left != null) {
                st.push(temp.left);
            }

        }
        return;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        pre(root);
        System.out.println("Iterative ans - ");
        iterativepre(root);
    }

}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
