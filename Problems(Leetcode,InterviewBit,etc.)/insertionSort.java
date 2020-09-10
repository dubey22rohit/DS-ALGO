
public class insertionSort {
//	Worst Case Time Complexity [ Big-O ]: O(n2)
//	Best Case Time Complexity [Big-omega]: O(n)
//	Average Time Complexity [Big-theta]: O(n2)
	
	public static void insertionSort(int[] arr) {
	int n = arr.length;
	int key = Integer.MIN_VALUE;
	for(int i = 1;i<n;i++) {
		key = arr[i];
		int j = i - 1;
		while(j >=0 && arr[j] > key) {
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = key;
	}
		
}
	public static void main(String[] args) {
		int arr[] = {9,5,6,1,0,3,4,1};
		insertionSort(arr);
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
