/* 
Given a string, find the longest substring which is palindrome
4 solutions
- o(n^3) - generating all substrings and checking if each is palindrome or not individually
- o(n^2 log(n)) - using binary search and parity (errichito) 
- o(n^2) - (both space and time) bottom up dp | o(1) solution is also
- o(n) - manacher's algo
*/

import java.util.Scanner;

public class lngstPaldrmSubstr {

    public static String solve(String s) {
        int n = s.length();
        boolean t[][] = new boolean[n][n];

        // all substrings of length 1 are palindrome
        int len = 1;
        for (int i = 0; i < n; i++)
            t[i][i] = true;

        // check for substring of length 2
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                t[i][i + 1] = true;
                start = i;
                len = 2;
            }
        }

        // for lenghts greater than 3

        for (int k = 3; k < n + 1; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;

                if (t[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    t[i][j] = true;
                    if (k > len) {
                        start = i;
                        len = k;
                    }
                }

            }
        }

        return s.substring(start, start + len);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solve(s));
        sc.close();
    }
}
