import java.util.Collections;
import java.util.PriorityQueue;

class help {

	public static String helpfn(String[] arr) {

		// Determine size of the array
		int n = arr.length;

		// Take first word from array as reference
		String s = arr[0];
		int len = s.length();

		String res = "";

//        for (int i = 0; i < len; i++) {
		for (int j = 1; j <= len; j++) {

			// generating all possible substrings
			// of our reference string arr[0] i.e s
			String stem = s.substring(0, j);
			int k = 1;
			for (k = 1; k < n; k++)

				// Check if the generated stem is
				// common to all words
				if (!arr[k].contains(stem))
					break;

			// If current substring is present in
			// all strings and its length is greater
			// than current result
			if (k == n && res.length() < stem.length())
				res = stem;
		}
//        }

		return res;

	}

	public static int solve(int[] arr, int k) {

		PriorityQueue<Integer> hp = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			hp.add(arr[i]);
			if (hp.size() > k) {
				hp.poll();
			}

		}

		return hp.poll();

	}

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);

//		
//		String s1 = sc.nextLine();
////		int n = sc.nextInt();
//
//		System.out.println(helpfn(s1));

//		String arr[] = { "rosewood", "rose", "rosy", "rosemarry", "roshh" };
//
//		System.out.println(helpfn(arr));
//		
//
//		int a[] = { 4, 5, 6, 3, 1, 2 };
//		System.out.println(solve(a, 3));

		String s = "999999999999";
		int min = Integer.MAX_VALUE;
		String d = "";
		String r = "";
		for (int i = 1; i < s.length(); i++) {
			String s1 = s.substring(0, i);
			String s2 = s.substring(i, s.length());

			int a = Integer.parseInt(s1);
			int b = Integer.parseInt(s2);
			System.out.println(a + " " + b);
			int dif = (int) Math.abs(a - b);
			if (min > dif) {
				min = dif;
				d = s1;
				r = s2;

			}

		}
		System.out.println(min);
//		System.out.println(d + "-" + r + "-" + (d + r));
		System.out.println(d + r);

	}
}

//public static String helpfn(String str, int n) {
//
//	StringBuilder sb = new StringBuilder();
//
//	String ans = "";
//	try {
//
//		for (int i = 0; i < str.length(); i += 2) {
//			for (int j = 0; i < str.length() && j < Integer.parseInt(str.charAt(i + 1) + ""); j++) {
//				sb.append(str.charAt(i));
//			}
//		}
//
//	} catch (Exception e) {
//
//		// throw statement
//
//	}
//
//	try {
//		ans = String.valueOf(sb.charAt(n - 1));
//	} catch (Exception e) {
//		return "-1";
//	}
//

//for (int i = 0; i < input1.length(); i++) {
//	hm.put(input1.charAt(i), hm.getOrDefault(input1.charAt(i), 0) + 1);
//	ts.add(input1.charAt(i));
//}
//
//for (Character x : ts) {
//	sb.append(x + "" + hm.get(x));
//}
//	return ans;
//
//}