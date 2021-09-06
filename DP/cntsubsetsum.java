import java.util.Scanner;

public class cntsubsetsum {

	public static int nofzero(int a[]) {
		int cnt = 0;
		for (int i : a) {
			if (i == 0) {
				cnt++;
			}
		}
		return cnt;
	}

	public static int cntss(int a[], int n, int sum) {
		/*
		 * if(sum==0) { return 1; } if(n==0&&sum!=0) We don't really need these lines!!!
		 * { return 0; }
		 */

		int t[][] = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 && j != 0) {
					t[i][j] = 0;
					continue;
				}
				if (j == 0) {
					t[i][j] = (int) Math.pow(2, nofzero(a));
					continue;
				}
				if (a[i - 1] <= j) {
					t[i][j] = (t[i][j - a[i - 1]] + t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		// for (int i = 0; i < n + 1; i++) {
		// for (int j = 0; j < sum + 1; j++) {
		// System.out.print(t[i][j] + " ");
		// }
		// System.out.println();
		// }
		return t[n][sum];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// size of arr
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		// required sum
		int sum = sc.nextInt();

		int ans = cntss(a, n, sum);
		System.out.println(ans);
		sc.close();
	}
}