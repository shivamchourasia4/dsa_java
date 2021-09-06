import java.util.Scanner;
import java.util.Stack;

public class NGR {

	static int[] ngr(int a[]) {

		Stack<Integer> st = new Stack<>();
		int ans[] = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--) {
			if (st.isEmpty())
				ans[i] = -1;

			else if (st.peek() > a[i]) {
				ans[i] = st.peek();
			} else if (st.size() > 0 && st.peek() <= a[i]) {
				while (st.size() > 0 && st.peek() <= a[i]) {
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
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		int ans[] = ngr(a);
		for (int i : ans)
			System.out.print(i + " ");

		scanner.close();
	}
}
