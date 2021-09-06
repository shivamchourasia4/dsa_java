import java.util.Arrays;
import java.util.Scanner;

/* 
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).
*/

//direct this was asked in tcs codevita qualifier round!, only statement was changed

//order of 1 solution ----> simply print -> 1+ (n/2) [basically count of number of 2's] this only
//works when the order doesn't matter

/*

The third method uses the technique of Sliding Window to arrive at the solution.
Approach: This method efficiently implements the above Dynamic Programming approach. 
In this approach for the ith stair, we keep a window of sum of last m possible stairs from which we can climb to the ith stair. 
Instead of running an inner loop, we maintain the result of the inner loop in a temporary variable. 
We remove the elements of the previous window and add the element of the current window and update the sum
*/

public class countNthStairWays {

	public static int solve(int n, int i, int[] t) {

		if (i >= n - 1) {
			return 1;
		} else if (t[i] != -1) {
			return t[i];
		}
		int t1 = solve(n, i + 1, t);
		int t2 = solve(n, i + 2, t);

		return t[i] = t1 + t2;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input nth stair to reach
		int n = sc.nextInt();
		int t[] = new int[n + 1];

		Arrays.fill(t, -1);
		int ans = solve(n, 0, t);

		System.out.println(ans);
		sc.close();
	}
}
