
/*

Given a number N. Find the minimum number of squares of any number that sums to N. For Example: If N = 100 , N can be expressed as (10*10) and also as (5*5 + 5*5 + 5*5 + 5*5) but the output will be 1 as minimum number of square is 1 , i.e (10*10).

*/
import java.util.Arrays;
import java.util.Scanner;

public class minSqSum {

    public static int solve(int n, int i, int[][] t) {
        if (t[n - 1][i - 1] != -1) {
            return t[n - 1][i - 1];
        }
        if (n == ((int) Math.floor(Math.sqrt(n) * (int) Math.floor(Math.sqrt(n))))) {
            return 1;
        }

        if (i * i >= n) { // or we could write i > (int)Math.sqrt(n)+1
            return t[n - 1][i - 1] = n;
        }

        return t[n - 1][i - 1] = Math.min(1 + solve(n - (i * i), i, t), solve(n, i + 1, t));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // single input n
        int n = sc.nextInt();

        int t[][] = new int[n + 1][(int) Math.sqrt(n) + 1];
        for (int[] x : t)
            Arrays.fill(x, -1);
        System.out.println(solve(n, 1, t));
        sc.close();
    }
}
