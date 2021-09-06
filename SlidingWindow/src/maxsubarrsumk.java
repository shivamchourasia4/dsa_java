package src;
/* 
Given an array of integers and a number k, find maximum sum of a subarray of size k
*/

import java.util.Scanner;

public class maxsubarrsumk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int mx = Integer.MIN_VALUE;

        int i = 0, j = 0, sum = 0;

        while (j < n) {
            sum += a[j];

            if (j - i + 1 < k) {
                j++;
            }

            else if (j - i + 1 == k) {
                mx = Math.max(mx, sum);
                sum -= a[i];
                i++;
                j++;
            }
        }

        System.out.println(mx);
        sc.close();
    }
}
