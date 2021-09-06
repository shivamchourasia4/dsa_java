package infytqPast;

import java.util.Scanner;

public class arrRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int rt[] = new int[n];

        for (int i = 0; i < n; i++) {
            rt[(i + k) % n] = a[i];
        }

        for (int i : rt) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            rt[(i + (n - k)) % n] = a[i];
        }

        for (int i : rt) {
            System.out.print(i + " ");
        }
        System.out.println();
        sc.close();
    }
}
