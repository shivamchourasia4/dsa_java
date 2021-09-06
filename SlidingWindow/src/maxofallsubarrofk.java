package src;

import java.util.*;

public class maxofallsubarrofk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // using O(k) space
        Deque<Integer> dq = new LinkedList<Integer>();

        ArrayList<Integer> al = new ArrayList<>();
        int i = 0, j = 0;
        while (j < n) {

            while (!dq.isEmpty() && dq.peekLast() < a[j]) {
                dq.pollLast();
            }

            dq.addLast(a[j]);
            System.out.println(dq);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {

                al.add(dq.peekFirst());

                if (a[i] == dq.peekFirst()) {
                    dq.pollFirst();
                }

                i++;
                j++;

            }

        }

        // Using priority queue, uses unnecessary space

        // Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        // ArrayList<Integer> al = new ArrayList<>();
        // int i = 0, j = 0;
        // while (j < n) {

        // q.add(a[j]);

        // if (j - i + 1 < k) {
        // j++;
        // } else if (j - i + 1 == k) {

        // al.add(q.peek());

        // if (a[i] == q.peek()) {
        // q.poll();
        // } else {
        // q.remove(a[i]);
        // }

        // i++;
        // j++;

        // }

        // }
        System.out.println(al);
        sc.close();
    }
}
