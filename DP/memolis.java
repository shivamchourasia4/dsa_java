import java.util.Arrays;
import java.util.Scanner;

public class memolis {

    public static int memofn(int a[], int prev, int curr, int t[][]) {
        if (curr == a.length) {
            return 0;
        }
        if (t[prev + 1][curr] >= 0) {
            return t[prev + 1][curr];
        }

        int taken = 0;
        if (prev < 0 || a[curr] > a[prev]) {
            taken = 1 + memofn(a, curr, curr + 1, t);
        }

        int nottaken = memofn(a, prev, curr + 1, t);
        return t[prev + 1][curr] = Math.max(taken, nottaken);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int t[][] = new int[a.length + 1][a.length];
        for (int[] i : t) {
            Arrays.fill(i, -1);
        }

        int ans = memofn(a, -1, 0, t);
        System.out.println(ans);
        sc.close();
    }
}