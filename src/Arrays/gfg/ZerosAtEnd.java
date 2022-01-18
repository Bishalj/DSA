package Arrays.gfg;


import utils.CommonUsedUtils;

import static utils.CommonUsedUtils.swap;

public class ZerosAtEnd {

  public static void main(String[] args) {
	  int arr[] = {20,0,4,0,5,6,7,0,7,5};
	  placeZeroAtEnd(arr);
	  CommonUsedUtils.displayArray(arr);
  }

	private static void placeZeroAtEnd(int[] arr) {
		int front = -1, rear = 0;
		while(rear < arr.length){
			if(arr[rear] != 0)
				swap(arr, ++front,rear);
			rear++;
		}
	}
}
