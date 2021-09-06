package infytqPast;

import java.util.*;

public class twoNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] st = s.split(",");

        int[] nums = new int[st.length];

        for (int i = 0; i < st.length; i++) {
            nums[i] = Integer.parseInt(st[i]);
        }

        int tbi = 0;
        int s1 = 0;
        String s2 = "";
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 5) {
                tbi++;
                s2 += 5;
                continue;
            }

            if (nums[i] == 8) {
                tbi--;
                s2 += 8;
                continue;
            }

            if (tbi == 0) {
                s1 += nums[i];
            } else {
                s2 += nums[i];
            }
        }

        System.out.println(s1 + Integer.parseInt(s2));
        sc.close();
    }
}
