
public class SortingAlgorithms {

	public static void main(String[] args) {
		SortingAlgorithms sortAlgo = new SortingAlgorithms();

		int[] arrayToSort = { 29, 9, 6, 60, 80, 2, 10, 110 };
		// insertionSort(arrayToSort);
//		bubbleSort(arrayToSort);
//		mergeSort(arrayToSort, 0, arrayToSort.length -1);
		quickSort(arrayToSort, 0, arrayToSort.length -1);

		System.out.println("Sorted array:");
		for (int i = 0; i < arrayToSort.length; i++) {
			System.out.print(arrayToSort[i] + " ");
		}

	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			
			quickSort(arr, low, pi -1);
			quickSort(arr, pi+1, high);
		}
	}

	public static int partition(int[] arr, int low, int high) {
		int pi = arr[high];
		
		int i = low - 1;
		
		for (int j = low; j <= high -1; j++) {
			if (arr[j] <= pi) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		int temp = arr[i +1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		
		return i+1;
	}
	
	public static void insertionSort(int[] arr) {
		int i;
		int key;
		int j = 0;

		for (i = 1; i < arr.length; i++) {
			key = arr[i];
			j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}

			arr[j + 1] = key;
		}
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (r + l)/2;
			
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			
			merge(arr, l , m, r);
		}
	}
	
	public static void merge(int[] arr, int l, int m, int r) {
		int n1 = m -l +1; 
		int n2 = r - m;
		
		int left[] = new int[n1];
		int right[] = new int[n2];
		
		for (int i = 0; i < n1; i++) {
			left[i] = arr[l+i];
		} 
		
		for (int i = 0; i < n2; i++) {
			right[i] = arr[m +1 +i];
		}
		
		int i = 0; 
		int j = 0;
		
		int k = l;
		
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while (j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int j = 0; j < arr.length ; j++) {
			for (int i = 0; i < arr.length - j -1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

}
