/* 
Given a string you need to print longest possible substring that has exactly M unique characters. If there are more than one substring of longest possible length, then print any one of them.

Examples: 

"aabbcc", k = 1
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.

"aaabbb", k = 3
There are only two unique characters, thus show error message. 
*/
package src;

import java.util.*;

public class lngstSubStrUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int k = sc.nextInt();

        int n = s.length();

        int i = 0, j = 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        String sb = "";
        while (j < n) {

            // System.out.println(hm);

            int tbp = hm.getOrDefault(s.charAt(j), 0);
            hm.put(s.charAt(j), ++tbp);

            if (hm.size() < k) {
                j++;
            }

            else if (hm.size() == k) {

                if (j - i + 1 > sb.length()) {
                    sb = s.substring(i, j + 1);
                }

                j++;
            }

            else {
                while (hm.size() > k) {
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

        System.out.println(sb);
        sc.close();
    }
}
