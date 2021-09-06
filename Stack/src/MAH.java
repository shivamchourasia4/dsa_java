import java.util.Scanner;
import java.util.Stack;

//class pair {
//	int val, index;
//
//	pair(int val, int index) {
//		this.val = val;
//		this.index = index;
//	}
//}

//Default access specifier allows it in diff class in same package!!

public class MAH {

	static int[] nsl(int a[]) {

		int ans[] = new int[a.length];
		Stack<pair> st = new Stack<>();

		for (int i = 0; i < a.length; i++) {
			if (st.isEmpty()) {
				ans[i] = -1;
			}

			else if (!st.isEmpty() && st.peek().val < a[i]) {
				ans[i] = st.peek().index;
			} else if (!st.isEmpty() && st.peek().val >= a[i]) {
				while (!st.isEmpty() && st.peek().val >= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					ans[i] = -1;
				} else {
					ans[i] = st.peek().index;
				}
			}

			st.push(new pair(a[i], i));
		}
		return ans;
	}

	static int[] nsr(int a[]) {
		int ans[] = new int[a.length];
		Stack<pair> st = new Stack<>();

		for (int i = a.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				ans[i] = a.length;
			} else if (!st.isEmpty() && st.peek().val < a[i]) {
				ans[i] = st.peek().index;
			} else if (!st.isEmpty() && st.peek().val >= a[i]) {
				while (!st.isEmpty() && st.peek().val >= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					ans[i] = a.length;
				} else {
					ans[i] = st.peek().index;
				}
			}
			st.push(new pair(a[i], i));
		}
		return ans;
	}

	public static long mah(int a[]) {

		int l[] = new int[a.length];
		int r[] = new int[a.length];

		l = nsl(a);
		r = nsr(a);

		// nsl, nsr nikal ke (nsl[i] - nsl[r] - 1) = height se area nikal lenge

		long area = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			area = Math.max(a[i] * (r[i] - l[i] - 1), area);
		}
		return area;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		long area = mah(a);
		System.out.println(area);
		sc.close();
	}
}
