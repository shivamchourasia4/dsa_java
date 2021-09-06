package src;

/* 
Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
*/
import java.util.HashMap;
import java.util.Scanner;

public class cntOccAnagrams {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String txt = sc.nextLine();

		String pat = sc.nextLine();

		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < pat.length(); i++) {
			int tbp = hm.getOrDefault(pat.charAt(i), 0);
			hm.put(pat.charAt(i), ++tbp);
		}
		// System.out.println(hm);
		int i = 0, j = 0, c = hm.size(), oc = 0;
		int n = txt.length(), k = pat.length();
		while (j < n) {

			if (hm.containsKey(txt.charAt(j))) {
				hm.put(txt.charAt(j), hm.get(txt.charAt(j)) - 1);
				if (hm.get(txt.charAt(j)) == 0) {
					c--;
				}
			}
			if (j - i + 1 < k) {
				j++;
			}

			// This is tricky!
			else if (j - i + 1 == k) {

				if (c == 0) {
					oc++;
				}

				if (hm.containsKey(txt.charAt(i))) {
					if (hm.get(txt.charAt(i)) == 0) {
						c++;
					}
					hm.put(txt.charAt(i), hm.get(txt.charAt(i)) + 1);
				}

				i++;
				j++;

			}

		}

		System.out.println(oc);
		sc.close();
	}
}
