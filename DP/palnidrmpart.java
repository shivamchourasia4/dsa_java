import java.util.Arrays;
import java.util.Scanner;

public class palnidrmpart {

    public static boolean isplndrm(String sl) {

        /*
         * StringBuffer str = new StringBuffer(s); str.reverse(); String rev =
         * str.toString(); if(s.compareTo(rev)==0) { return true; } return false;
         */
        int i = 0, j = sl.length() - 1;
        boolean rt = false;
        while (i < j) {
            if (sl.charAt(i) != sl.charAt(j)) {
                return rt = false;
            }
            rt = true;
            i++;
            j--;
        }
        return rt;
    }

    public static int recplndrmpart(String s, int l, int u, int t[][]) {

        if (l >= u) {
            return 0;
        }
        if (t[l][u] != -1) {
            return t[l][u];
        }
        if (isplndrm(s.substring(l, u + 1))) {
            return t[l][u] = 0;
        }
        int mx = Integer.MAX_VALUE;
        for (int k = l; k <= u - 1; k++) {

            int right, left;
            if (t[l][k] != -1) {
                left = t[l][k];
            } else {
                left = recplndrmpart(s, l, k, t);
                t[l][k] = left;
            }
            if (t[k + 1][u] != -1) {
                right = t[k + 1][u];
            } else {
                right = recplndrmpart(s, k + 1, u, t);
                t[k + 1][u] = right;
            }

            int temp = 1 + recplndrmpart(s, l, k, t) + recplndrmpart(s, k + 1, u, t);
            if (temp < mx) {
                mx = temp;
            }
        }
        return t[l][u] = mx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int t[][] = new int[s.length() + 1][s.length() + 1];
        for (int row[] : t) {
            Arrays.fill(row, -1);
        }
        int ans = recplndrmpart(s, 0, s.length() - 1, t);
        System.out.println(ans);
        sc.close();
    }
}