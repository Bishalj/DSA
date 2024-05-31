package prepare.sort;

import prepare.common.DisplayUtils;

public class CountInversionInArray {

	public static void main(String[] args) {
		int arr[] = {2,4,1,3,5};
		int result = mergeSort( arr, 0, arr.length-1);
		DisplayUtils.array(arr);
		System.out.println("Number of Inversions: " + result);
		int result2 = mergeSort( new int[]{10,20,30,40}, 0, 3);
		System.out.println("Number of Inversions: " + result2);

		int result3 = mergeSort( new int[]{40,30,20,10}, 0, 3);
		System.out.println("Number of Inversions: " + result3);
	}

	private static int mergeSort(int arr[], int low, int high){
		int result = 0;
		if(high>low){
			int mid = low + (high-low)/2;
			result += mergeSort(arr, low, mid);
			result += mergeSort(arr, mid+1, high);
			result += merge(low, mid, high, arr);
		}
		return result;
	}

	private static int merge(int low, int mid, int high, int arr[]){
		int n1=mid-low+1, n2=high-mid;
		int lowArr[] = new int[mid-low+1];
		int highArr[] = new int[high-mid];
		for(int i=0; i<n1; i++)
			lowArr[i] = arr[i+low];
		for(int i=0; i<n2; i++)
			highArr[i] = arr[i+mid+1];

		int i=0,j=0, index=low, result=0;
		while(i<n1 && j<n2){
			if(lowArr[i] <= highArr[j])
				arr[index++] = lowArr[i++];
			else {
				arr[index++] = highArr[j++];
				result += (n1-i);
			}
		}

		while(i<n1)
			arr[index++] = lowArr[i++];

		while(j<n2)
			arr[index++] = highArr[j++];
		return result;
	}
}
