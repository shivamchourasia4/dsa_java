package src;

import java.util.*;

/*
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Example 2:

Input: s = "a", t = "a"
Output: "a"
*/

public class minWindowSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        int i = 0, j = 0, n = s.length(), m = t.length();
        int ans = Integer.MAX_VALUE;
        int st = 0;

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int k = 0; k < m; k++) {
            int tbp = hm.getOrDefault(t.charAt(k), 0);
            hm.put(t.charAt(k), ++tbp);
        }
        int cntr = hm.size();

        while (j < n) {
            if (hm.containsKey(s.charAt(j))) {
                hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                if (hm.get(s.charAt(j)) == 0) {
                    cntr--;
                }
            }

            if (cntr == 0) {
                while (cntr == 0) {

                    if (j - i + 1 < ans) {
                        ans = Math.min(ans, j - i + 1);
                        st = i;
                    }

                    if (hm.containsKey(s.charAt(i))) {
                        hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
                        if (hm.get(s.charAt(i)) > 0) {
                            cntr++;
                        }
                    }
                    i++;
                }

            }
            j++;

        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println("");
        } else {
            // System.out.println(st + " " + ans);
            System.out.println(s.substring(st, st + ans));
        }
        sc.close();

    }
}
