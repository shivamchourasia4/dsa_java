/*
 * 
 * Given a NxN matrix of positive integers. There are only three possible moves
 * from a cell Matrix[r][c].
 * 
 * Matrix [r+1] [c] Matrix [r+1] [c-1] Matrix [r+1] [c+1] â€‹Starting from any
 * column in row 0, return the largest sum of any of the paths up to row N-1
 */

// only solution function is written.. input is autoassumed

import java.util.*;

class Solution {

    static int solve(int[][] m, int n, int i, int j, int[][] t) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (i > n - 1 || j > n - 1) {
            return 0;
        }

        // System.out.println(m[i][j]);

        if (t[i][j] != -1) {
            return t[i][j];
        }

        return t[i][j] = m[i][j] + Math.max(solve(m, n, i + 1, j, t),
                Math.max(solve(m, n, i + 1, j + 1, t), solve(m, n, i + 1, j - 1, t)));

    }

    static int maximumPath(int N, int Matrix[][]) {

        int mx = 0;
        int t[][] = new int[N + 1][N + 1];

        for (int[] x : t) {
            Arrays.fill(x, -1);
        }
        for (int i = 0; i <= N - 1; i++) {
            mx = Math.max(mx, solve(Matrix, N, 0, i, t));
        }

        return mx;
    }
}