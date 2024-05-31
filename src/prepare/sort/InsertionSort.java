package prepare.sort;

import prepare.common.DisplayUtils;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int a[] = {1,6,3,8,95,43,6573,436,42};
		insertionSort(a);
		DisplayUtils.array(a);
	}

	private static void insertionSort(int[] a) {
		for(int i=1; i<a.length; i++){
			int j=i-1;
			while(j>=0 && a[j]>a[j+1])
				swapElements(a, j+1, j--);
		}
	}

	public static void swapElements(int array[], int indexOne, int indexTwo) {
		int temp = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = temp;
	}
}
