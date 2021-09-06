
public class InsertionSort {
	// Simple sorting algorithm

	public static void insort(int[] a) {

		// O(n2)
		// can be reduced to log using binary search
		// best case is O(n) when the elements are already sorted!
		int n = a.length;

		for (int i = 1; i < n; i++) {
			int j = i - 1;
			int key = a[i];
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}

			a[j + 1] = key;

		}

		for (int x : a) {
			System.out.print(x + " ");
		}

	}

	public static void main(String[] args) {
		int a[] = { 5, 3, 2, 4, 1 };

		insort(a);

	}
}
