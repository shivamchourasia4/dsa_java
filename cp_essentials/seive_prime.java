import java.util.Scanner;

class seive_prime

//static boolean[] primes = new boolean[1000002];
//static int[] count = new int[1000002];
//
//static void sieve() {
//	primes[0] = true;
//	primes[1] = true;
//
////	System.out.println(primes[2]);
////	for (int i = 2; i < 1000002; i++) {
////		primes[i] = true;
////	}
//
//	for (int i = 2; i * i < 1000002; i++) {
//		if (!primes[i]) {
//			for (int p = i * i; p < 1000002; p += i) {
//				primes[p] = true;
//			}
//		}
//	}
//
//	count[0] = 0;
//	count[1] = 0;
//
//	int cnt = 0;
//	for (int i = 2; i < 1000002; i++) {
//		if (!primes[i]) {
//			cnt++;
//		}
//		count[i] = cnt;
//	}
//
//}

{
	static boolean prime[] = new boolean[10000000];

	static void sieveOfEratosthenes(int n) {
		prime[0] = false;
		prime[1] = false;
		for (int i = 1; i < n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++)// for(int p = 2; p*p <=n; p++)
		{
			// If prime[p] is not changed, then it is a prime

			if (prime[p] == true) {
				System.out.print(p + ": ");
				// Update all multiples of p
				for (int i = p * p; i <= n; i += p) {
					prime[i] = false;
					System.out.print(i + " ");
				}
				System.out.println();
			}

		}
	}

	// Driver Program to test above function
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int l[] = new int[t];
		int r[] = new int[t];
		for (int i = 0; i < t; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		int mx = Integer.MIN_VALUE;
		for (int x : r) {
			mx = Math.max(mx, x);
		}
		sieveOfEratosthenes(mx);

		for (int i = 0; i < t; i++) {
			int c = 0, p = 0;
			int nl = l[i], rl = r[i];
			for (int j = nl; j <= rl; j++) {
				if (j == 1)
					continue;

				if (prime[j])
					p++;
				else
					c++;
			}
			System.out.println(c - p);
		}
		sc.close();
	}
}
