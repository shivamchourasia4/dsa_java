/* 

Find the length of the longest subsequence of a given sequence such that all 
the elements of the subsequence are in sorted order.

*/

import java.util.*;

class lis {

    // bottom up O(n2) solution
    public static int lisf(int arr[], int n) {
        ArrayList<Integer> al = new ArrayList<>(n);
        // int []al = new int[n];
        for (int i = 0; i < n; i++) {
            al.add(1);
        }
        System.out.println(al);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && al.get(i) < al.get(j) + 1) {
                    al.set(i, al.get(j) + 1);
                }
            }
        }
        System.out.println(al);
        int a = Collections.max(al);
        // al.clear();
        return a;
    }

    // recursive lis
    public static int reclis(int arr[], int i, int j) {

        if (j >= arr.length) {
            return 0;
        } else if (i < 0 || arr[j] > arr[i]) {
            return Math.max(reclis(arr, i, j + 1), 1 + reclis(arr, j, j + 1));
            // trick is to keep track of previous item!(which is why j is passed in the
            // subsequent recursion)
        }

        return reclis(arr, i, j + 1);

    }

    // O(n*log(n)) solution
    public static int efflis(int[] arr, int n) {

        int[] tail = new int[n];

        int len = 1;
        tail[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < tail[0]) { // found new smallest value
                tail[0] = arr[i];
            }

            else if (arr[i] > tail[len - 1]) { // value extends the list
                tail[len++] = arr[i];
            }

            else { // value can be end candidate of an existing sub sequence
                   // search the subsequence end value using binary search!

                int index = CeilIndex(tail, -1, len - 1, arr[i]);

                tail[index] = arr[i];

            }
        }

        return len;

    }

    // binary search kinda ceil value less than arr[i] in sequence
    static int CeilIndex(int A[], int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // int ans = lisf(arr, n); // Bottom up solution

        int dp[] = new int[n + 1];

        Arrays.fill(dp, -1);

        // int ans = reclis(arr, -1, 0); // memoized recursive solution (top down) ->
        // memoized solution written in separate file.

        int ans = efflis(arr, n);
        System.out.print("ans: ");
        System.out.println(ans);
        sc.close();
    }
}

// example in case i forget the nlog(n) approach
/*
 * It will be clear with an example, let us take example from wiki {0, 8, 4, 12,
 * 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}.
 * 
 * A[0] = 0. Case 1. There are no active lists, create one. 0.
 * -----------------------------------------------------------------------------
 * A[1] = 8. Case 2. Clone and extend. 0. 0, 8.
 * -----------------------------------------------------------------------------
 * A[2] = 4. Case 3. Clone, extend and discard. 0. 0, 4. 0, 8. Discarded
 * -----------------------------------------------------------------------------
 * A[3] = 12. Case 2. Clone and extend. 0. 0, 4. 0, 4, 12.
 * -----------------------------------------------------------------------------
 * A[4] = 2. Case 3. Clone, extend and discard. 0. 0, 2. 0, 4. Discarded. 0, 4,
 * 12.
 * -----------------------------------------------------------------------------
 * A[5] = 10. Case 3. Clone, extend and discard. 0. 0, 2. 0, 2, 10. 0, 4, 12.
 * Discarded.
 * -----------------------------------------------------------------------------
 * A[6] = 6. Case 3. Clone, extend and discard. 0. 0, 2. 0, 2, 6. 0, 2, 10.
 * Discarded.
 * -----------------------------------------------------------------------------
 * A[7] = 14. Case 2. Clone and extend. 0. 0, 2. 0, 2, 6. 0, 2, 6, 14.
 * -----------------------------------------------------------------------------
 * A[8] = 1. Case 3. Clone, extend and discard. 0. 0, 1. 0, 2. Discarded. 0, 2,
 * 6. 0, 2, 6, 14.
 * -----------------------------------------------------------------------------
 * A[9] = 9. Case 3. Clone, extend and discard. 0. 0, 1. 0, 2, 6. 0, 2, 6, 9. 0,
 * 2, 6, 14. Discarded.
 * -----------------------------------------------------------------------------
 * A[10] = 5. Case 3. Clone, extend and discard. 0. 0, 1. 0, 1, 5. 0, 2, 6.
 * Discarded. 0, 2, 6, 9.
 * -----------------------------------------------------------------------------
 * A[11] = 13. Case 2. Clone and extend. 0. 0, 1. 0, 1, 5. 0, 2, 6, 9. 0, 2, 6,
 * 9, 13.
 * -----------------------------------------------------------------------------
 * A[12] = 3. Case 3. Clone, extend and discard. 0. 0, 1. 0, 1, 3. 0, 1, 5.
 * Discarded. 0, 2, 6, 9. 0, 2, 6, 9, 13.
 * -----------------------------------------------------------------------------
 * A[13] = 11. Case 3. Clone, extend and discard. 0. 0, 1. 0, 1, 3. 0, 2, 6, 9.
 * 0, 2, 6, 9, 11. 0, 2, 6, 9, 13. Discarded.
 * -----------------------------------------------------------------------------
 * A[14] = 7. Case 3. Clone, extend and discard. 0. 0, 1. 0, 1, 3. 0, 1, 3, 7.
 * 0, 2, 6, 9. Discarded. 0, 2, 6, 9, 11.
 * ----------------------------------------------------------------------------
 * A[15] = 15. Case 2. Clone and extend. 0. 0, 1. 0, 1, 3. 0, 1, 3, 7. 0, 2, 6,
 * 9, 11. 0, 2, 6, 9, 11, 15. <-- LIS List
 * ----------------------------------------------------------------------------
 */