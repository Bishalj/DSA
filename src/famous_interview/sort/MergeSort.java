package famous_interview.sort;

import utils.CommonUsedUtils;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
	  //
	  int a[] = {2, 10, 15, 20};
	  int b[] = {1, 5, 8, 10, 11, 14,40,50};
	  CommonUsedUtils.displayArray(mergeTwoSortedArray(a,b));

	  int a1[] = {1, 3, 5, 6, 2, 4, 8, 16};
	  CommonUsedUtils.displayArray(a1);
	  mergeArray(a1, 0, 3, a1.length-1);
	  CommonUsedUtils.displayArray(a1);
	  int a2[] = {1, 30, 5, 12, 2, 4, 8, 16};
	  int totalInversion1 = mergeSort(a2, 0, a2.length-1);
	  System.out.println("total inversion " + totalInversion1);
	  CommonUsedUtils.displayArray(a2);


	  int b2[] = {2,4,1,3,5};
	  int totalInversion2 = mergeSort(b2, 0, b2.length-1);
	  System.out.println("total inversion " + totalInversion2);


	  int b3[] = {2,5,8,11,3,6,9,3};
	  int totalInversion3 = mergeSort(b3, 0, b3.length-1);
	  System.out.println("total inversion " + totalInversion3);

  }

  private static int mergeSort(int arr[], int low, int high){
  	int totalInversion = 0;
  	if(low >= high)
  		return totalInversion;
  	int mid = low + ((high-low)/2);
	  totalInversion += mergeSort(arr, low, mid);
	  totalInversion += mergeSort(arr, mid+1, high);
	  totalInversion += mergeArray(arr, low, mid, high);

	  return totalInversion;
  }

	private static int mergeArray(int[] arr, int low, int mid, int high) {
		int leftSize = mid - low + 1, rightSize = high - mid, lc=0,rc=0;
		int left[] = new int[leftSize];
		int right[] = new int[rightSize];

		for(int i=low; i<=mid; i++)
			left[i-low] = arr[i];

		for(int i=mid+1; i<=high; i++)
			right[i-(mid+1)] = arr[i];

		return mergeTwoSortedArray2(arr, left, right, low);
	}

	private static int mergeTwoSortedArray2(int arr[], int left[], int right[], int index){
		int i=0, j=0;
		int totalInversion = 0;
		while (i<left.length && j<right.length){
			if(left[i] <= right[j])
				arr[index++] = left[i++];
			else{
				totalInversion += left.length - i;
				arr[index++] = right[j++];
			}
		}

		while (i<left.length)
			arr[index++] = left[i++];

		while (j<right.length)
			arr[index++] = right[j++];
		return totalInversion;
	}

	private static int[] mergeTwoSortedArray(int a[], int b[]){
	int[] res = new int[a.length+b.length];
	int i=0, j=0, c=0;

	while (i<a.length && j<b.length){
	    if(a[i] < b[j])
	        res[c++] = a[i++];
	    else
		    res[c++] = b[j++];
	}

	  while (i<a.length)
		  res[c++] = a[i++];

	  while (j<b.length)
		  res[c++] = b[j++];
	return res;
  }
}
