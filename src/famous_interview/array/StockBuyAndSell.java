package famous_interview.array;

import java.util.ArrayList;

public class StockBuyAndSell {
  public static void main(String[] args) {
  	  int arr[] = {1,3,5,2,8,4,1,5,6};
	  System.out.println(stockBuySell(arr, arr.length));
  }

	static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
		// code here
		final ArrayList<ArrayList<Integer> > res = new ArrayList();

		int i=0;
		while(i<n-1){
			while((i+1) < n && A[i] >= A[i+1])
				i++;
			if((i+1) >= n)
				return res;

			int start = i++;
			while((i+1) < n && A[i] < A[i+1])
				i++;
			int end = i;
			ArrayList<Integer> profit = new ArrayList();
			profit.add(start);
			profit.add(end);
			res.add(profit);
			i++;
		}
		return res;
	}
}
