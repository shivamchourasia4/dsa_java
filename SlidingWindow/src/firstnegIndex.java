package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class firstnegIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = new int[n];

        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int i = 0, j = 0;

        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> al = new ArrayList<>();

        while (j < n) {

            if (a[j] < 0) {
                q.add(a[j]);
            }

            // System.out.println(q);

            if (j - i + 1 < k) {
                j++;
            }

            else if (j - i + 1 == k) {

                if (q.isEmpty()) {
                    al.add(0);
                } else {

                    al.add(q.peek());
                    if (a[i] == q.peek()) {
                        q.poll();
                    }
                }
                i++;
                j++;
            }
        }

        System.out.println(al);
        sc.close();
    }
}
