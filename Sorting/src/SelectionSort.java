
public class SelectionSort {
	//Simple sorting algorithm
	public static void selsort(int []a) {
		
		int n = a.length;
		
		
		//O(n2)
		for(int i=0;i<n-1;i++) {
			
			
			int min_index = i;
			
			for(int j=i+1;j<n;j++) {
				if(a[j]<a[i]) {
					min_index = j;
				}
			}
			
			int temp = a[min_index];
			a[min_index] = a[i];
			a[i] = temp;
			
			
		}
		
		for(int x: a) {
			System.out.print(x+" ");
		}
		
		
		
	}
	
	public static void main(String[] args) {
		int a[] = {1,5,3,4,2};
		
		selsort(a);
	}
}
