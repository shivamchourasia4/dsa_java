import java.util.*;

public class nikprb {

    public static int nikfn(int a[], int l, int n) {
        long sum = 0;

        if (l >= n) {
            return 0;
        }
        boolean alzero = true;
        for (int i = l; i <= n; i++) {
            if (a[i] != 0) {
                alzero = false;
            }
            sum += a[i];
        }
        if (alzero) {
            return n;
        }
        // System.out.println("sum=> "+sum);
        if (sum % 2 != 0) {
            return 0;
        } else {
            sum = sum / 2;
            // System.out.println("sum/2=> "+sum);
            long pt = 0;
            int ps = 0;
            for (int i = l; i <= n; i++) {
                // System.out.println("a[i]=> "+a[i]);

                if (pt == sum) // pt==sum
                {
                    // System.out.println("HERE");
                    ps = i - 1;
                    break;
                } else if (pt > sum) // pt>sum
                {
                    return 0;
                }
                pt += a[i];
                // pt = pt.add(BigInteger.valueOf(a[i]));
                // System.out.println("pt=> "+pt);
            }
            // System.out.println("l=> "+l+" ps=> "+ps+" n=>"+n);
            return 1 + Math.max(nikfn(a, l, ps), nikfn(a, ps + 1, n));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int ans = nikfn(a, 0, n - 1);
            System.out.println(ans);
        }
        sc.close();
    }
}