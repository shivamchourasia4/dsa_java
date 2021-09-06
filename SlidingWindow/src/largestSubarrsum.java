package src;
/*
Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.

O(n) solution
*/

import java.util.HashMap;
import java.util.Scanner;

public class largestSubarrsum {

    public static int solve(int[] a, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int len = 0, sum = 0;

        for (int i = 0; i < a.length; i++) {

            sum += a[i];

            if (sum == k) {
                len = i + 1;
            }
            if (!hm.containsKey(sum))
                hm.put(sum, i);

            if (hm.containsKey(sum - k)) {
                if (len < (i - hm.get(sum - k))) {
                    len = i - hm.get(sum - k);
                }
            }

        }

        return len;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // this doesnt works for negative numbers

        // int i = 0, j = 0, mx = 0, sum = 0;

        // while (j < n) {

        // sum += a[j];

        // if (sum < k) {
        // j++;
        // }

        // else if (sum == k) {
        // mx = Math.max(mx, j - i + 1);
        // j++;
        // }

        // else {

        // while (sum > k) {
        // sum -= a[i];
        // i++;
        // }

        // j++;
        // }

        // }

        // System.out.println(mx);

        System.out.println(solve(a, k));
        sc.close();

    }

}
