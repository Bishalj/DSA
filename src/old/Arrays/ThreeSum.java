package old.Arrays;

import java.util.Arrays;

public class ThreeSum {
  public static void main(String[] args) {
	  int arr1[] = {3,5,2,653,24,52,53,5,3,2};
	  int sum = 12;
	  print3Sum(arr1, sum);
  }


	private static void print3Sum(int[] nums, int sum) {
		Arrays.sort(nums);
		for(int i=0; i<nums.length-2; i++){
			int low = i+1, high = nums.length-1;
			while(low < high){
				if(nums[low] + nums[high] + nums[i] > sum)
					high--;
				else if(nums[low] + nums[high] + nums[i] < sum)
					low++;
				else{
					System.out.println("a= "+nums[i] + " , b= " + nums[low] + " , c=" +nums[high] );
					return;
				}
			}
		}
	}
}
