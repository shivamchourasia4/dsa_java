import java.util.Arrays;

public class MergeSort {

	// O(nlogn)
	public static void mergesort(int a[], int l, int h) {

		// makes sure there is at least 2 elements
		if (h > l) {

			int mid = l + (h - l) / 2;

			mergesort(a, l, mid);
			mergesort(a, mid + 1, h);
			merge(a, l, mid, h);

		}

	}

	public static void merge(int a[], int l, int m, int h) {

		int s1 = m - l + 1;
		int s2 = h - m;

		int[] sub1 = new int[s1];
		int[] sub2 = new int[s2];

		for (int i = 0; i < s1; i++) {
			sub1[i] = a[l + i];
		}

		for (int j = 0; j < s2; j++) {
			sub2[j] = a[m + 1 + j];
		}

		int i = 0, j = 0;

		int k = l;
		while (i < s1 && j < s2) {
			if (sub1[i] <= sub2[j]) {
				a[k] = sub1[i];
				i++;
			} else {
				a[k] = sub2[j];
				j++;
			}

			k++;
		}

		while (i < s1) {
			a[k] = sub1[i];
			i++;
		}

		while (j < s2) {
			a[k] = sub2[j];
			j++;
		}

	}

	public static void main(String[] args) {
		int a[] = { 10, 7, 8, 9, 1, 5 };

		mergesort(a, 0, a.length - 1);

		System.out.println(Arrays.toString(a));
	}
}
