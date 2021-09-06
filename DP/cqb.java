import java.util.Scanner;

public class cqb {

	// A recursive function used by countWays
	public static long countWays(int n) {
		long[] btw = new long[n + 1];
		btw[0] = 1;
		btw[1] = 1;
		btw[2] = 2;
		for (int i = 3; i <= n; i++)
			btw[i] = btw[i - 1] + btw[i - 2] + btw[i - 3];

		return btw[n];
	}

	// Driver function
	public static void main(String argc[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			if (n == 0)
				System.out.println(1);
			else
				System.out.println(countWays(n + 1));
		}
		sc.close();
	}
}