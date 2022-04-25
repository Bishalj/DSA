package famous_interview.stack;

import java.util.Stack;

public class SpanProblem {
  public static void main(String[] args) {
	  int arr[] = {13,15,12,14,16,8,6,4,10,30};
	  stockSpan(arr);
	  int arr2[] = {10,20,30,40};
	  stockSpan(arr2);
	  int arr3[] = {40,30,20,10};
	  stockSpan(arr3);
  }

	private static void stockSpan(int[] arr) {
		Stack<IndexValue> stack = new Stack<>();
		for(int i = 0; i< arr.length; i++){
	      if(!stack.isEmpty() && stack.peek().value < arr[i]){
		      while(!stack.empty() && stack.peek().value < arr[i])
			      stack.pop();
	      }

			if(stack.isEmpty()){
				System.out.print(i + 1 + " ");
			}else{
				System.out.print(i - stack.peek().index + " ");
			}
			stack.push(new IndexValue(i, arr[i]));
		}
		System.out.println();
	}
}
class IndexValue{
	public int index;
	public int value;

	public IndexValue(int index, int value){
		this.index = index;
		this.value = value;
	}
}
