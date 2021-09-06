import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class cplchef {

	public static boolean subset(int a[], int n, int sum) {
		boolean[][] t = new boolean[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 && j == 0) {
					t[i][j] = true;
					continue;
				}

				if (i == 0) {
					t[i][j] = false;
					continue;
				}
				if (j == 0) {
					t[i][j] = true;
					continue;
				}
				if (a[i - 1] <= j) {
					t[i][j] = t[i - 1][j - a[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[n][sum];
	}

	public static boolean ifpart(int a[], int n) {
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		if (sum % 2 != 0) {
			return false;
		} else {
			boolean t[][] = new boolean[n + 1][(sum / 2) + 1];
			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < (sum / 2) + 1; j++) {
					if (i == 0 && j == 0) {
						t[i][j] = true;
						continue;
					}
					if (i == 0) {
						t[i][j] = false;
						continue;
					}
					if (j == 0) {
						t[i][j] = true;
						continue;
					}
					if (a[i - 1] <= j) {
						t[i][j] = t[i - 1][j - a[i - 1]] || t[i - 1][j];
					} else {
						t[i][j] = t[i - 1][j];
					}
				}
			}
//            for(int i=0;i<n+1;i++)
//            {
//                for(int j=0;j<(sum/2)+1;j++)
//                {
//                    System.out.print(t[i][j]+" ");
//                }
//            System.out.println();
//            }
			return t[n][(sum / 2)];
		}

	}

	static int[] sort(int a[]) {

		ArrayList<Integer> al = new ArrayList<>();

		for (int i : a) {
			al.add(i);
		}
		Collections.sort(al, Collections.reverseOrder());

		return al.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[n];

			int sum = 0;

			for (int i = 0; i < n; i++) {
				int r = sc.nextInt();
				a[i] = r;
				sum += r;
			}

			a = sort(a);

			if (a[0] >= k) {
				int count = 1;
				int sum2 = 0;
				boolean flag = false;
				for (int i = 1; i < n; i++) {
					sum2 += a[i];
					count++;
					if (sum2 >= k) {
						flag = true;
						break;
					}
				}
				if (flag)
					System.out.println(count);
				else
					System.out.println(-1);
			}

			else if (a[0] < k) {

				if (sum == 2 * k) {
					boolean rslt = ifpart(a, a.length);
					if (rslt)
						System.out.println(a.length);
					else
						System.out.println(-1);
				} else if (sum < 2 * k) {
					System.out.println(-1);
				} else {
					ArrayList<Integer> al = new ArrayList<>();
					ArrayList<Integer> bl = new ArrayList<>();
					int sum1 = 0, e = 0;
					boolean equalprt = false;
					for (int i = 0; i < a.length; i++) {
						sum1 += a[i];
						al.add(a[i]);

						if (sum1 == 2 * k) {

							boolean fr = ifpart(al.stream().mapToInt(p -> p).toArray(), al.size());

							if (fr) {
								System.out.println(al.size());
								equalprt = true;
								break;
							}
						}

						if (sum1 > 2 * k) {
							e = i;
							break;
						}
					}

					if (!equalprt) {

						boolean issubsetk = false;

						issubsetk = subset(al.stream().mapToInt(p -> p).toArray(), al.size(), k);
						// HEre check if any subset is there whose sum is == k
						if (issubsetk) {
							System.out.println(al.size());
						} else {
							int sm = 0;
							for (int i : al) {
								sm += i;
							}
							sm = (int) sm / 2;

							// Here check if ......... sum == sm

							boolean issm2 = false;

							issm2 = subset(al.stream().mapToInt(p -> p).toArray(), al.size(), sm);

							if (issm2) {
								System.out.println(al.size());
							} else {

								for (int i = e + 1; i < a.length; i++) {
									bl.add(a[i]);
								}

//								System.out.println(al);
//								System.out.println(bl);

								ArrayList<Integer> s1 = new ArrayList<>();
								ArrayList<Integer> s2 = new ArrayList<>();
								s1.add(al.get(0));
								int sum3 = al.get(0), ind = 0;
								boolean f1 = false, f2 = false;
								for (int i = al.size() - 1; i >= 0; i--) {
									s1.add(al.get(i));

									sum3 += al.get(i);
									if (sum3 >= k) {
										ind = i;
										f1 = true;
										break;
									}
								}

//								System.out.println(s1);

								if (f1) {
									int sum4 = 0;
									for (int i = ind - 1; i >= 0; i--) {
										s2.add(al.get(i));
										sum4 += al.get(i);
										if (sum4 >= k) {
											f2 = true;
											break;
										}
									}

									if (f2)
										System.out.println(s1.size() + s2.size());
									else {
										boolean l2s = false;
										for (int j = 0; j < bl.size(); j++) {
											s2.add(bl.get(j));
											sum4 += bl.get(j);

											if (sum4 >= k) {
												System.out.println(s1.size() + s2.size());
												l2s = true;
												break;
											}

										}

										if (!l2s) {
											System.out.println(-1);
										}
									}
								} else
									System.out.println(-1);

							}
						}
					}
				}
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