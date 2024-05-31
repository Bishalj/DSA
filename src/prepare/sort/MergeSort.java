package prepare.sort;

import prepare.common.DisplayUtils;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {1,4,1, 4,2,7,14, 2,5,8,9,11,12,199,166,246,16,17};
		mergeSort( arr, 0, arr.length-1);
		DisplayUtils.array(arr);
	}

	private static void mergeSort(int arr[], int low, int high){
		if(high>low){
			int mid = low + (high-low)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(low, mid, high, arr);
		}
	}

	private static void merge(int low, int mid, int high, int arr[]){
		int n1=mid-low+1, n2=high-mid;
		int lowArr[] = new int[mid-low+1];
		int highArr[] = new int[high-mid];
		for(int i=0; i<n1; i++)
			lowArr[i] = arr[i+low];
		for(int i=0; i<n2; i++)
			highArr[i] = arr[i+mid+1];

		int i=0,j=0, index=low;
		while(i<n1 && j<n2){
			if(lowArr[i] <= highArr[j])
				arr[index++] = lowArr[i++];
			else
				arr[index++] = highArr[j++];
		}

		while(i<n1)
			arr[index++] = lowArr[i++];

		while(j<n2)
			arr[index++] = highArr[j++];
	}
}
