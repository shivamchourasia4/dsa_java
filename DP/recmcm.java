/* 
Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications. The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).
*/

import java.util.Scanner;
import java.util.Arrays;

public class recmcm {

    public static int recslv(int a[], int i, int j, int t[][]) {

        if (i >= j) {
            return 0; // Also memoized!!!!!
        }
        if (t[i][j] != -1) {
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = recslv(a, i, k, t) + recslv(a, k + 1, j, t) + (a[i - 1] * a[k] * a[j]);
            if (temp < min) {
                min = temp;
            }
        }
        return t[i][j] = min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size: ");
        int n = sc.nextInt();
        System.out.println("Enter elements: ");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {

            a[i] = sc.nextInt();
        }
        int t[][] = new int[n + 1][n + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        int ans = recslv(a, 1, n - 1, t);
        System.out.println(ans);
        sc.close();
    }

}