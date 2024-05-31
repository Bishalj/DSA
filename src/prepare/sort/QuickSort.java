package prepare.sort;

import prepare.common.DisplayUtils;

import static old.utils.CommonUsedUtils.swap;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {10,80,30,90,40,50,70};
		DisplayUtils.array(arr);
		quickSortOperation(arr, 0, arr.length-1);
		DisplayUtils.array(arr);
	}
	private static void quickSortOperation(int arr[], int low, int high){
		if(low<high){
			int partition = lomutoPartition(arr, low, high);
			quickSortOperation(arr, low, partition-1);
			quickSortOperation(arr, partition+1, high);
		}
	}
	private static int lomutoPartition(int arr[], int low, int high){
		int pivot = arr[high];
		int i=low;
		for(int j=low; j<=high; j++){
			if(arr[j]<pivot){
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, high);
		return i;
	}
}
