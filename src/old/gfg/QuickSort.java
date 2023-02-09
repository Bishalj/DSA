package old.gfg;

import old.utils.CommonUsedUtils;

public class QuickSort {

  private int findPartition(int low, int high, int arr[]) {
    int pivot = arr[high];
    int j = low;
    while (j <= high - 1) {
      if (arr[j] < pivot) {
        swapArr(low, j, arr);
        low++;
      }
      j++;
    }
    System.out.println("j= " + j);
    swapArr(low, j, arr);
    return low;
  }

  private void swapArr(int low, int j, int[] arr) {
    int tmp = arr[low];
    arr[low] = arr[j];
    arr[j] = tmp;
  }

  private int sort(int low, int high, int arr[], int k ){
      while(low <= high){
          int partition = findPartition(low, high, arr);
          if(partition == k-1)
              return arr[partition];
          if(partition > k-1){
              high= partition-1;
          }else{
              low = partition+1;
          }
      }
      return -1;
  }

  public static void main(String[] args) {
    int arr[] = {10, 12, 5, 1, 90, 9};
    int k = 4;
    int low = 0;
    int high = arr.length - 1;
    QuickSort quickSort = new QuickSort();
    int val = quickSort.sort(low, high, arr, k);
    System.out.println("Kth Smallest: " + val);
    CommonUsedUtils.displayArray(arr);
  }
}
