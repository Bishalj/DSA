package famous_interview.array;

public class MaximumDifference {

	public static void main(String[] args) {
		int arr[] = {2,3,10,6,4,8,1};
		int max = arr[arr.length-1], diff = Integer.MIN_VALUE;
		for(int i=arr.length-2; i>=0; i--){
			if(max - arr[i] > diff)
				diff = max - arr[i];
			max = Math.max(max, arr[i]);
		}
		System.out.println(diff);
	}
}
