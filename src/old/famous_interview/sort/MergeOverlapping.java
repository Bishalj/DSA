package old.famous_interview.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlapping {
  public static void main(String[] args) {
	  //
	  int arr[][] = {
			  {1,3},
			  {3,4},
			  {5,7},
			  {6,8}
	  };

	  int arr2[][] = {
			  {7,9},
			  {6,10},
			  {4,5},
			  {1,3},
			  {2,4}
	  };

	  List<List<Integer>> result = getMergedTimelines(arr);
	  System.out.println(result);

	  List<List<Integer>> result2 = getMergedTimelines(arr2);
	  System.out.println(result2);
  }

	private static List<List<Integer>> getMergedTimelines(int[][] arr) {
  	    List<List<Integer>> result = new ArrayList<>();
  	    if(arr == null || arr.length == 0)
  	    	return result;

        Arrays.sort(arr, (a1,a2) -> a2[0] < a1[0] ? 1 : -1);
        int start = arr[0][0], end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
               if(end < arr[i][0]){
               	   addValidOverlap(result, start, end);
	               start = arr[i][0];
	               end = arr[i][1];
               }else
               	end = Math.max(end, arr[i][1]);
        }
        return addValidOverlap(result, start, end);
	}

	private static List<List<Integer>> addValidOverlap(List<List<Integer>> result, int start, int end) {
		List<Integer> list = new ArrayList();
		list.add(start);
		list.add(end);
		result.add(list);
		return result;
	}
}
