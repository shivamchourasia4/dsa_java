import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class cqc {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		OutputStream outputstream = System.out;
		PrintWriter out = new PrintWriter(outputstream);
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int v[] = new int[n];
		for (int i = 0; i < n; i++) {
			v[i] = sc.nextInt();
		}
		int p = sc.nextInt();
		ArrayList<TreeSet<Integer>> al = new ArrayList<TreeSet<Integer>>();
		for (int i = 0; i < p; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (al.size() == 0) {
				TreeSet<Integer> ts = new TreeSet<>();
				ts.add(x);
				ts.add(y);
				al.add(ts);
			} else {
				boolean flag = false;
				for (int j = 0; j < al.size(); j++) {
					TreeSet<Integer> tmp = al.get(j);
					if (tmp.contains(x)) {
						for (int k = j + 1; k < al.size(); k++) {
							TreeSet<Integer> atp = al.get(k);
							if (atp.contains(y)) {
								for (int f : atp) {
									tmp.add(f);
								}
								al.remove(atp);
								break;
							}
						}
						tmp.add(y);
						flag = true;
						break;
					} else if (tmp.contains(y)) {
						if (tmp.contains(y)) {
							for (int k = j + 1; k < al.size(); k++) {
								TreeSet<Integer> atp = al.get(k);
								if (atp.contains(x)) {
									for (int f : atp) {
										tmp.add(f);
									}
									al.remove(atp);
									break;
								}
							}
						}
						tmp.add(x);
						flag = true;
						break;
					}
				}
				if (!flag) {
					TreeSet<Integer> tba = new TreeSet<>();
					tba.add(x);
					tba.add(y);
					al.add(tba);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			boolean isPair = true;
			for (TreeSet<Integer> tmp : al) {
				if (tmp.contains(i)) {
					isPair = false;
					break;
				}
			}
			if (isPair) {
				TreeSet<Integer> tba = new TreeSet<>();
				tba.add(i);
				al.add(tba);
			}
		}

		System.out.println(al);

		long sum = Long.MIN_VALUE;
		TreeSet<Integer> ans = new TreeSet<>();
		for (TreeSet<Integer> tmp : al) {
			long temp = 0;
			for (int i : tmp) {
				temp += v[i - 1];
			}
			if (temp > sum) {
				sum = temp;
				ans = tmp;
			} else if (temp == sum) {
				ans = ans.size() <= tmp.size() ? ans : tmp;
				sum = temp;
			}
		}
//		System.out.println(sum);
		for (int i : ans)
			out.print(i + " ");
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