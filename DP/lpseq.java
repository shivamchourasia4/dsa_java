import java.util.Scanner;

//length of longest palindromic sub sequence
// min no. of insertions or deletions to make a string palindrome
public class lpseq {

    public static int mytry(String s1, String s2, int m, int n) {
        int t[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                    continue;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[m][n];

        // print longest palindromic substring
        // int i=s1.length(),j=s2.length();
        // // List<Character> sl = new ArrayList<>();
        // StringBuilder st = new StringBuilder();
        // while(i>0&&j>0)
        // {
        // if(s1.charAt(i-1)==s2.charAt(j-1))
        // {
        // st.append(Character.toString(s1.charAt(i-1)));
        // i--;
        // j--;
        // }
        // else{
        // if(t[i-1][j]>t[i][j-1])
        // {
        // i--;
        // }
        // else{
        // j--;
        // }
        // }
        // }
        // return st.reverse().toString();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        String s2 = sb.toString();

        int ans = mytry(s1, s2, s1.length(), s2.length());
        // min no. of del to make it palindrome---
        System.out.println("min dels=> " + (s1.length() - ans));
        System.out.println(ans);
        sc.close();
    }
}