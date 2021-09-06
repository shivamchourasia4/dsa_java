import java.util.Arrays;
import java.util.Scanner;

/**
 * maxsubarrndseq
 */
public class maxsubarrndseq {

	public static void maxsubarr(int[] a, int n) {

		// kadane
		int max_curr = 0;
		int max_sofar = Integer.MIN_VALUE;

		for (int x : a) {
			max_curr = Math.max(x, max_curr + x);
			max_sofar = Math.max(max_curr, max_sofar);
		}

		System.out.println(max_sofar);

		// max sub sequence

		int mx = 0;
		Arrays.sort(a);

		if (a[a.length - 1] <= 0) {
			mx = a[a.length - 1];
		} else {

			for (int x : a) {
				if (x > 0) {
					mx += x;
				}
			}
		}

		System.out.println(mx);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		maxsubarr(a, n - 1);
		sc.close();
	}
}

//		if (n == 0) {
//			return 0;
//		}
//		System.out.println("sum=> " + sum + " +a[n-1]> " + a[n - 1]);
//		if (sum + a[n - 1] >= sum) {
//			if (sum == mx) {
//				sum = 0;
//				return Math.max(sum + maxsubarr(a, n - 1, a[n - 1]), sum + maxsubarr(a, n - 1, sum));
//			} else
//				return a[n - 1] + maxsubarr(a, n - 1, a[n - 1]);
//		}
//		return maxsubarr(a, n - 1, sum);