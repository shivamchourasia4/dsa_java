import java.util.Scanner;

// longest repeating sub sequence
public class lngstrepeatsubseq {

    public static int reqfn(String s1, String s2, int n) {
        int t[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[n][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int ans = reqfn(s1, s1, s1.length());
        System.out.println(ans);
        sc.close();
    }
}