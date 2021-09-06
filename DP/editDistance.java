import java.util.Arrays;
import java.util.Scanner;

/* 
Given two strings s and t. Find the minimum number of operations that need to be performed on str1 to convert it to str2. The possible operations are:

Insert
Remove
Replace
*/

public class editDistance {

    public static int solve(String s1, String s2, int i, int j, int t[][]) {

        if (t[i][j] != -1) {
            return t[i][j];
        }

        if (i <= 0) {
            return t[i][j] = j;
        }
        if (j <= 0) {
            return t[i][j] = i;
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return t[i][j] = solve(s1, s2, i - 1, j - 1, t);
        }
        return t[i][j] = Math.min(1 + solve(s1, s2, i - 1, j - 1, t),
                Math.min(solve(s1, s2, i - 1, j, t) + 1, solve(s1, s2, i, j - 1, t) + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int t[][] = new int[s1.length() + 1][s2.length() + 2];

        for (int x[] : t) {
            Arrays.fill(x, -1);
        }

        System.out.println(solve(s1, s2, s1.length() - 1, s2.length() - 1, t));

        sc.close();
    }
}

// Bottom up
/*
 * static int editDistDP(String str1, String str2, int m, int n) { // Create a
 * table to store results of subproblems int dp[][] = new int[m + 1][n + 1];
 * 
 * // Fill d[][] in bottom up manner for (int i = 0; i <= m; i++) { for (int j =
 * 0; j <= n; j++) { // If first string is empty, only option is // to insert
 * all characters of second string if (i == 0) dp[i][j] = j; // Min. operations
 * = j
 * 
 * // If second string is empty, only option is // to remove all characters of
 * second string else if (j == 0) dp[i][j] = i; // Min. operations = i
 * 
 * // If last characters are same, ignore last // char and recur for remaining
 * string else if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i -
 * 1][j - 1];
 * 
 * // If the last character is different, // consider all possibilities and find
 * the // minimum else dp[i][j] = 1 + min(dp[i][j - 1], // Insert dp[i - 1][j],
 * // Remove dp[i - 1] [j - 1]); // Replace } }
 * 
 * return dp[m][n]; }
 * 
 */