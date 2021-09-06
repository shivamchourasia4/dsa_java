import java.util.Arrays;

public class BubbleSort {

	//Simple sorting algorithm
	public static void bblsort(int a[]) {
		
		int n = a.length;
		
		//O(n2)
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n-i-1;j++) {
//				if(a[j]>a[j+1]) {
//					int temp = a[j];
//					a[j] = a[j+1];
//					a[j+1] = temp;
//				}
//			}
//		}
//		
//		for(int x: a) {
//			System.out.print(x+" ");
//		}	
		
	
	
//	Best case - O(n) (Stop when swapped)
	//modified bubble sort
	
	boolean swap = false;
	
	for(int i=0;i<n;i++) {
		
		for(int j=0;j<n-i-1;j++) {
			if(a[j]>a[j+1]) {
				int temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
				swap = true;
			}
		}
		
		if(!swap) {
			break;
		}
	}
	
	for(int x:a) {
		System.out.print(x+" ");
	}
	
	}
	
	
	
	public static void main(String[] args) {
		int a[] = {5,3,2,4,1};
		
		bblsort(a);
		
		Arrays.sort(a);
		
	}
}
