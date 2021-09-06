import java.util.Arrays;

// average, best - O(nlogn)
// worst case - O(n2) (when always the first/last element is chosen as the pivot)
// worst case can be avoided by randomizing the pivot every time
// suited for arrays!!
public class QuickSort {

	// implementing best case (picking median element as the pivot)

	// 1. either choose the 1st element as the pivot <- implemented using this
	// 2. choose the last element as the pivot
	// 3. choose the middle element as the pivot

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void qsrt(int a[], int l, int h) {

		// this condition checks that there are at least 2 elements in the array!!
		if (l < h) {

			int pivot = partition(a, l, h);
			qsrt(a, l, pivot);
			qsrt(a, pivot + 1, h);

		}

	}

	public static int partition(int[] a, int l, int h) {

		int pivot = a[l];

		int i = l, j = h;

		while (i < j) {

			while (i < a.length && a[i] <= pivot) {
				i++;
			}

			while (j >= 0 && a[j] > pivot) {
				j--;
			}

			if (i < j) {
				swap(a, i, j);
			}
		}

		// swap a[l] with j (the new pivot element)
		swap(a, l, j);
		return j;

	}

	public static void main(String[] args) {

		int a[] = { 5, 12, 4, 1, 66, 31, 24 };

		qsrt(a, 0, a.length - 1);

		System.out.println(Arrays.toString(a));
	}
}
