
/* 
Given a positive integer n, find the nth fibonacci number. Since the answer can be very large, return the answer modulo 1000000007
*/
import java.util.*;

public class NthFibo {

    public static long dpfib(int n, long[] dp) {

        if (dp[n] != -1) {
            return dp[n];
        }

        if (n == 1) {
            return dp[n] = 1;
        }

        if (n == 2) {
            return dp[n] = 1;
        }

        return dp[n] = (dpfib(n - 1, dp) + dpfib(n - 2, dp)) % 1000000007;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        long[] dp = new long[(int) n + 1];
        Arrays.fill(dp, -1);
        System.out.println(dpfib((int) n, dp));
        sc.close();
    }
}
