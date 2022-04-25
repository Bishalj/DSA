package famous_interview.sort;

import utils.CommonUsedUtils;

public class CountingSort {
  public static void main(String[] args) {
	  //
	  int arr[] = {2,9,9,50,1,0,1,2,4,5,5};
	  int k = 50;
	  CommonUsedUtils.displayArray(arr);
	  countingSort(arr, k);
	  CommonUsedUtils.displayArray(arr);
  }

  private static void countingSort(int[] arr, int k){
  	int tmp[] = new int[k+1];
    for (int i = 0; i<arr.length; i++)
	    tmp[arr[i]]++;

    int p=0;
    for(int i=0; i<tmp.length; i++){
    	for(int j=0; j<tmp[i]; j++)
    		arr[p++] = i;
    }
  }
}
