/* 
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property)

*/

import java.util.*;

public class z1knap_bu {

    public static int knapsack(int wt[], int val[], int n, int w) {
        int t[][] = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // for(int i=0;i<n+1;i++)
        // {
        // for(int j=0;j<w+1;j++)
        // {
        // System.out.print("1"+" ");
        // }
        // System.out.println();
        // }
        return t[n][w];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of elements:");
        int n = sc.nextInt();
        int wt[] = new int[n];
        System.out.println("Enter the weights: ");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        int val[] = new int[n];
        System.out.println("Enter the values: ");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        System.out.println("Enter the knapsack weight: ");
        int w = sc.nextInt();

        int ans = knapsack(wt, val, n, w);
        System.out.println(ans);
        sc.close();
    }
}