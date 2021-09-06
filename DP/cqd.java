import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class cqd {
	public static void main(String args[]) {
		OutputStream outputstream = System.out;
		PrintWriter out = new PrintWriter(outputstream);
		FastReader sc = new FastReader();
		int n = sc.nextInt();
//		sc.nextLine();
		String s = sc.nextLine();

		ArrayList<String> as = new ArrayList<>();
		ArrayList<Integer> mrkr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			boolean tba = true;
			String lngst = Character.toString(s.charAt(i));
			char c = s.charAt(i);
			int j = i + 1;
			while (j < n && !lngst.contains(s.charAt(j) + "")) {
//				System.out.println("HERE");
				lngst = lngst + Character.toString(s.charAt(j));
//				System.out.println(lngst);
				j++;
			}
			boolean nxtCheck = true;
			j--;
			if (as.size() > 0 && j + 1 < n) {
				if (s.charAt(j + 1) == s.charAt(i)) {
//					System.out.println(lngst);
//					System.out.println(s.charAt(i) + " " + s.charAt(j + 1));
//					System.out.println("breaked");
					tba = false;
					nxtCheck = false;
				}
			}
			i = j;
//			System.out.println(s.charAt(i));
			if (tba) {
				as.add(lngst);
				mrkr.add(j);
			}
		}
//		out.println(as);
		Collections.sort(as);
//		System.out.println("ans");
//		for (String ans : as) {
//			System.out.print(ans + " ");
//		}
		for (int i = 0; i < as.size(); i++) {
			if (i == as.size() - 1) {
				System.out.print(as.get(i));
			} else {
				System.out.print(as.get(i) + " ");
			}
		}

		out.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}