/* package codechef; // don't place package name! */

import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class primschef {
  static class fe {
    int src, dst;
    long wt;

    fe(int src, int dst, long wt) {
      this.src = src;
      this.dst = dst;
      this.wt = wt;
    }
  }

  public static void main(String[] args) {
    OutputStream outputstream = System.out;
    PrintWriter out = new PrintWriter(outputstream);
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int d = sc.nextInt();
    ArrayList<ArrayList<Integer>> cord = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      ArrayList<Integer> al = new ArrayList<>();
      for (int j = 0; j < d; j++) {
        al.add(sc.nextInt());
      }
      cord.add(al);
    }

    // System.out.println(cord);

    ArrayList<fe> ale = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        long crw = difw(cord.get(i), cord.get(j));
        fe cr = new fe(i, j, crw);
        // System.out.println("== "+cr);
        ale.add(cr);
      }
    }

    long fgr[][] = new long[n][n];
    for (int i = 0; i < ale.size(); i++) {
      fgr[ale.get(i).src][ale.get(i).dst] = ale.get(i).wt;
      fgr[ale.get(i).dst][ale.get(i).src] = ale.get(i).wt;
    }
    // System.out.println(fgr.length);
    fmst(fgr);
    out.close();
  }

  static long difw(ArrayList<Integer> a, ArrayList<Integer> b) {
    long ans = 0;
    for (int i = 0; i < a.size(); i++) {
      ans += Math.abs(a.get(i) - b.get(i));
    }
    return ans;
  }

  static void fmst(long fgr[][]) {
    int v = fgr.length;
    int[] p = new int[v];
    long[] k = new long[v];
    boolean set[] = new boolean[v];

    for (int i = 0; i < v; i++) {
      k[i] = Integer.MIN_VALUE;
      set[i] = false;
    }

    k[0] = 0;
    p[0] = -1;

    long cr = kmax(v, k, set);
    // System.out.println("> "+cr);
    // int r = (int)cr;
    for (int cnt = 0; cnt < v - 1; cnt++) {
      set[(int) cr] = true;
    }

    for (int j = 0; j < v; j++) {
      if (fgr[(int) cr][j] != 0 && set[j] == false && fgr[(int) cr][j] > k[j]) {
        p[j] = (int) cr;
        k[j] = fgr[(int) cr][j];
      }
    }

    long an = 0;
    for (int i = 1; i < v; i++) {
      // System.out.println(">+ "+fgr[p[i]][i]);
      an += fgr[i][p[i]];
    }
    System.out.println(an);
  }

  static long kmax(int v, long[] k, boolean[] set) {
    long max = Integer.MIN_VALUE;
    int ind = -1;
    for (int i = 0; i < v; i++) {
      if (set[i] == false && k[i] > max) {
        max = k[i];
        ind = i;
      }
    }
    return ind;
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
