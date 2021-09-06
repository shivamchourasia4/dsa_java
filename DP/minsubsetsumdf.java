/* Given a set of integers, the task is to divide it into two sets S1 and S2
 such that the absolute difference between their sums is minimum. 
If there is a set S with n elements, then if we assume Subset1 has m elements, 
Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum. */

/*
 i/o - {1,5,6 11}
 --> 1

*/

import java.util.ArrayList;
import java.util.Scanner;

public class minsubsetsumdf {

	public static int minval(int a[], int n) {
		int sum = 0;
		if (n == 0) {
			return 0;
		}
		for (int i : a) {
			sum += i;
		}
		// System.out.println(sum);
		ArrayList<Integer> al = subsetsum(a, n, sum);
		// System.out.println(al);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < al.size(); i++) {
			// System.out.println("++"+(sum-(2*al.get(i))));
			min = Math.min(min, (sum - (2 * al.get(i))));
		}
		return min;
	}

	public static ArrayList<Integer> subsetsum(int a[], int n, int sum) {

		ArrayList<Integer> st = new ArrayList<>();
		// System.out.println("n=>"+n);
		// System.out.println("sum=>"+sum);

		boolean t[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i < n + 1; i++) {
			t[i][0] = true;
		}
		for (int i = 1; i < sum + 1; i++) {
			t[0][i] = false;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				// System.out.println("i=> "+i+" j=> "+j);

				/*
				 * if(i==n&&j==(sum/2)+2) { break; }
				 */
				if (i == n && j <= sum / 2 + 1) {
					if (t[i][j - 1] == true)
						st.add(j - 1);
				}

				if (a[i - 1] <= j) {
					t[i][j] = t[i - 1][j - a[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}

			}
		}
		/*
		 * for(int i=0;i<n+1;i++) { for(int j=0;j<sum+1;j++) {
		 * System.out.print(t[i][j]+" "); } System.out.println(); }
		 */
		return st;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int ans = minval(a, n);
		System.out.println(ans);
		sc.close();
	}
}