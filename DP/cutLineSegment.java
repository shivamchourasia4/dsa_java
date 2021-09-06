import java.util.Scanner;

/* 
Given an integer N denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum.


The cut segments size must be either x,y,z (As far as i saw from test cases)
*/

public class cutLineSegment {

    public static int solve(int n, int[] a) {

        int t[][] = new int[a.length + 1][n + 1];

        for (int i = 0; i < a.length + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    t[i][j] = Integer.MIN_VALUE;
                    continue;
                }
                if (j == 0) {
                    t[i][j] = 0;
                    continue;
                }

                if (a[i - 1] <= j) {
                    t[i][j] = Math.max(1 + t[i][j - a[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        if (t[a.length][n] <= Integer.MIN_VALUE + 1000)
            return 0;
        return t[a.length][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int a[] = { x, y, z };

        System.out.println(solve(n, a));
        sc.close();
    }
}
