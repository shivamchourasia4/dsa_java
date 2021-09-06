package src;

import java.util.*;

public class lngstSubStrNoRept {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        HashMap<Character, Integer> hm = new HashMap<>();

        int i = 0, j = 0, cnt = 0, n = s.length();

        while (j < n) {

            int tbp = hm.getOrDefault(s.charAt(j), 0);
            hm.put(s.charAt(j), ++tbp);

            if (hm.size() == j - i + 1) {
                cnt = Math.max(cnt, j - i + 1);
                j++;
            }

            // This is the trick, the condition is reversed also the other condition is
            // useless , cause it will never hit it!
            else if (hm.size() < j - i + 1) {
                while (hm.size() < j - i + 1) {
                    int tbr = hm.get(s.charAt(i));
                    hm.put(s.charAt(i), --tbr);
                    if (hm.get(s.charAt(i)) == 0) {
                        hm.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }

        }

        System.out.println(cnt);
        sc.close();
    }
}
