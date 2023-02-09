package old.famous_interview.sort;

import old.utils.CommonUsedUtils;

public class QuickSort {
  public static void main(String[] args) {
	  //
	  int arr[] = {10, 90, 80 , 20, 15, 100, 22,70};
	  int arr1[] = {10, 90, 80 , 20, 15, 100, 22,70};
	  CommonUsedUtils.displayArray(arr);
//	  getPartition(arr, 0, arr.length-1);
	  sortLomuto(arr, 0, arr.length-1);
	  CommonUsedUtils.displayArray(arr);
	  sortHoare(arr1, 0, arr1.length-1);
	  CommonUsedUtils.displayArray(arr1);
  }

  private static void sortLomuto(int arr[], int low, int high){
  	if(low >= high)
  		return;

  	int partition = getLomutoPartition(arr, low, high);
  	sortLomuto(arr, low, partition-1);
  	sortLomuto(arr, partition+1, high);
  }

	private static void sortHoare(int arr[], int low, int high){
		if(low >= high)
			return;

		int partition = getHoarePartition(arr, low, high);
		sortHoare(arr, low, partition);
		sortHoare(arr, partition+1, high);
	}

	private static int getHoarePartition(int[] arr, int low, int high) {
  	    if(low >= high)
  	    	return high;
  	    int i= low, j=high, pivot = arr[i];
  	    while (true){
  	    	while (arr[i] < pivot)
  	    		i++;

  	    	while (arr[j] > pivot)
  	    		j--;

  	    	if(i >= j)
  	    		return j;

  	    	swap(arr, i, j);
        }
	}

	private static int getLomutoPartition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int index = low;
		for (int i=low; i<=high; i++){
			if(arr[i] < pivot)
				swap(arr, i, index++);
		}
		swap(arr, index, high);
		return index;
	}

	private static void swap(int[] arr, int i, int index) {
		int tmp = arr[i];
		arr[i] = arr[index];
		arr[index] = tmp;
	}
}
