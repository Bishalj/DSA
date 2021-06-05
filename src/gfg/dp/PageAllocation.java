package gfg.dp;

public class PageAllocation {

	public int getMinimumPage(int n, int k, int arr[]){
		if(n == 1)
			return arr[0];
		if(k == 1)
			return sum(0, n-1, arr);

		int res = Integer.MAX_VALUE;
		for(int i=1; i<n; i++){
			res = Math.min(
					res,
					Math.max(
							getMinimumPage(i, k-1, arr),
							sum(i, n-1, arr)
					)
			);
		}
		return res;
	}

	private int sum(int a, int n, int[] arr) {
		int sum = 0;
		for(int i = a; i<=n; i++)
			sum += arr[i];
		return sum;
	}

  public static void main(String[] args) {
	  //
	  int arr[] = {10, 20, 30 ,40};
	  int k =2;
	  PageAllocation pageAllocation = new PageAllocation();
	  System.out.println(pageAllocation.getMinimumPage(arr.length, k ,arr));
  }
}
