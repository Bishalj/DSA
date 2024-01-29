package crack_google.gfg.recursion;

public class SubsetProblem {
	public static void main(String[] args) {
		int arr[] = {1,2,5};
		int sum = 0;
		System.out.println(subsetSumCount(arr, sum,  0));
	}

	private static int subsetSumCount(int[] arr, int sum, int index) {
		if(sum == 0)
			return 1;
		else if(index == arr.length)
			return 0;
		return subsetSumCount(arr, sum-arr[index], index+1) +
				subsetSumCount(arr, sum, index+1);
	}

}
