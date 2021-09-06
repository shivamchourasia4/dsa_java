import java.util.Stack;

public class inorder {

    public static void in(Node root) {

        if (root != null) {
            in(root.left);
            System.out.print(root.data + " ");
            in(root.right);
        }

    }

    public static void iterativein(Node root) {

        Stack<Node> st = new Stack<>();
        Node temp = root;

        while (!st.isEmpty() || temp != null) {

            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;
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

        in(root);
        System.out.println("iter ans");
        iterativein(root);
    }
}
