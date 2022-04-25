package famous_interview.array;

public class TrappingRainWater {

  public static void main(String[] args) {
	  int arr[] ={3,0,0,2,0,4};
	  System.out.println(trappingWater(arr, arr.length));
  }

	static int trappingWater(int arr[], int n) {
		int left = 0, right = n-1, leftMax = arr[0], rightMax = arr[n-1], water = 0;

		while(left < right){
			if(arr[left] < arr[right]){
				if(leftMax >= arr[left])
					water += leftMax - arr[left];
				leftMax = Math.max(leftMax, arr[left++]);
			}else{
				if(rightMax > arr[right])
					water += rightMax - arr[right];
				rightMax = Math.max(rightMax, arr[right--]);
			}
		}
		return water;

	}
}
