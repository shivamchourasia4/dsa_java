import java.util.Scanner;

public class subsetsum {

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

		// for(int i=0;i<n+1;i++)
		// {
		// for(int j=0;j<sum+1;j++)
		// {
		// System.out.print(t[i][j]+" ");
		// }
		// System.out.println();
		// }

//        ArrayList<Integer> p = new ArrayList<>();
//        printSubsetsRec(a, n, sum, p);
		return t[n][sum];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("Enter the sum: ");
		int sum = sc.nextInt();

		boolean ans = subset(a, n, sum);
		System.out.println(ans);
		sc.close();
	}
}

/*
 * printing elements of subset :!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! static void
 * disp(ArrayList<Integer> v) { System.out.println(v); }
 * 
 * static void printsubset(int arr[],int i,int sum,ArrayList<Integer> p) {
 * //System.out.println("in "+(i)+" "+sum+" a> "+arr[i-1]); if(sum==0&&i==0) {
 * System.out.println("HERE"); disp(p); p.clear(); return; } if(arr[i-1]>sum) {
 * printsubset(arr, i-1, sum, p); } if(sum>=arr[i-1]&&t[i-1][sum-arr[i-1]]) {
 * p.add(arr[i-1]); printsubset(arr, i-1, sum-arr[i-1], p); } else
 * if(sum>=arr[i-1]&&!t[i-1][sum-arr[i-1]]) { printsubset(arr, i-1, sum, p); } }
 * 
 * 
 * 
 * 
 * import java.io.*; import java.util.*;
 * 
 * class frcodechef { static boolean t[][] = new boolean[241][998244353]; static
 * ArrayList<Integer> p = new ArrayList<>();
 * 
 * static void printsubset(int arr[],int i,int sum) {
 * //System.out.println("in "+(i)+" "+sum+" a> "+arr[i-1]); if(sum==0&&i==0) {
 * // System.out.println("HERE"); // disp(p); // p.clear(); return; }
 * if(arr[i-1]>sum) { printsubset(arr, i-1, sum); }
 * if(sum>=arr[i-1]&&t[i-1][sum-arr[i-1]]) { p.add(arr[i-1]); printsubset(arr,
 * i-1, sum-arr[i-1]); } else if(sum>=arr[i-1]&&!t[i-1][sum-arr[i-1]]) {
 * printsubset(arr, i-1, sum); } } static void gendp(int a[],int sum,int n) {
 * for(int i=0;i<n+1;i++) { for(int j=0;j<sum+1;j++) { if(i==0&&j==0) { t[i][j]
 * = true; continue; } if(i==0) { t[i][j] = false; continue; } if(j==0) {
 * t[i][j] = true; continue; } if(a[i-1]<=j) { t[i][j] =
 * t[i-1][j-a[i-1]]||t[i-1][j]; } else{ t[i][j] = t[i-1][j]; } } } } public
 * static void main(String[] args) { OutputStream outputStream = System.out;
 * PrintWriter out = new PrintWriter(outputStream); FastReader sc = new
 * FastReader(); int n = sc.nextInt(); int a[] = new int[n]; //
 * System.out.println("Enter the elements: "); for(int i=0;i<n;i++) { a[i] =
 * sc.nextInt(); } gendp(a, 998244353, n); int q = sc.nextInt(); while(q-->0) {
 * int qi = sc.nextInt(); int sum = qi%998244353; printsubset(a,n,sum); long
 * y=0; for(int i=0;i<p.size();i++) { y+=(int)Math.pow(2,p.get(i)-1); }
 * out.print(y%(int)Math.pow(2, 60)+" ");
 * out.print((int)Math.floor(y/(int)Math.pow(2, 60))%(int)Math.pow(2, 60)+" ");
 * out.print((int)Math.floor(y/(int)Math.pow(2, 120))%(int)Math.pow(2, 60)+" ");
 * out.println((int)Math.floor(y/(int)Math.pow(2, 180))%(int)Math.pow(2, 60));
 * p.clear(); } out.close(); }
 * 
 * 
 * 
 * 
 * static class FastReader { BufferedReader br; StringTokenizer st;
 * 
 * public FastReader() { br = new BufferedReader(new
 * InputStreamReader(System.in)); }
 * 
 * String next() { while (st == null || !st.hasMoreElements()) { try { st = new
 * StringTokenizer(br.readLine()); } catch (IOException e) {
 * e.printStackTrace(); } } return st.nextToken(); }
 * 
 * int nextInt() { return Integer.parseInt(next()); }
 * 
 * long nextLong() { return Long.parseLong(next()); }
 * 
 * double nextDouble() { return Double.parseDouble(next()); }
 * 
 * String nextLine() { String str = ""; try { str = br.readLine(); } catch
 * (IOException e) { e.printStackTrace(); } return str; } } }
 * 
 */