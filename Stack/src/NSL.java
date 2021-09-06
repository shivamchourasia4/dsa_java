import java.util.Scanner;
import java.util.Stack;

public class NSL {

	static int[] nsl(int[] a) {
		int ans[] = new int[a.length];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < a.length; i++) {
			if (st.isEmpty()) {
				ans[i] = -1;
			} else if (!st.isEmpty() && st.peek() < a[i]) {
				ans[i] = st.peek();
			} else if (!st.isEmpty() && st.peek() >= a[i]) {
				while (!st.isEmpty() && st.peek() >= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					ans[i] = -1;
				} else {
					ans[i] = st.peek();
				}
			}
			st.push(a[i]);
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a[] = new int[n];

		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		int ans[] = nsl(a);

		for (int i : ans) {
			System.out.print(i + " ");
		}
		sc.close();
	}

}
