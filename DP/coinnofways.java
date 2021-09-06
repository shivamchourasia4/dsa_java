import java.util.Scanner;

public class coinnofways {

	public static int srtafn(int a[], int sum, int n) {
		int t[][] = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 & j != 0) {
					t[i][j] = 0;
					continue;
				}
				if (j == 0) {
					t[i][j] = 1;
					continue;
				} else if (a[i - 1] <= j) {
					t[i][j] = t[i][j - a[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		return t[n][sum];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("sum: ");
		int sum = sc.nextInt();
		int ans = srtafn(a, sum, n);
		System.out.println(ans);
		sc.close();
	}
}