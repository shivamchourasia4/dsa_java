import java.util.*;

/**
 * wildcardpatmatch Given two strings 'str' and a wildcard pattern 'pattern' of
 * length N and M respectively, You have to print '1' if the wildcard pattern is
 * matched with str else print '0' .
 * 
 * The wildcard pattern can include the characters ‘?’ and ‘*’ ‘?’ – matches any
 * single character ‘*’ – Matches any sequence of characters (including the
 * empty sequence)
 * 
 * Note: The matching should cover the entire str (not partial str).
 */
public class wildcardpatmatch {

    public static boolean wldcrd(String pat, String txt, int n, int m) {
        boolean t[][] = new boolean[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = true; // condition for phi!
                    continue;
                }
                if (i == 0 && j != 0) {
                    t[i][j] = false;
                    continue;
                }
                if (j == 0 && pat.charAt(i - 1) == '*') {
                    t[i][j] = t[i - 1][j];
                    continue;
                } else if (j == 0 && pat.charAt(i - 1) != '*') {
                    t[i][j] = false;
                    continue;
                }
                if (pat.charAt(i - 1) == '?' || pat.charAt(i - 1) == txt.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1];
                } else if (pat.charAt(i - 1) == '*') {
                    t[i][j] = t[i - 1][j] || t[i][j - 1];
                } else if (pat.charAt(i - 1) != txt.charAt(j - 1)) {
                    t[i][j] = false;
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        return t[n][m];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        String pat = sc.nextLine();
        boolean ans = wldcrd(pat, txt, pat.length(), txt.length());
        System.out.println(ans);
        sc.close();
    }
}