package famous_interview.stack;

import java.util.Stack;

public class PreviousGreater {
  public static void main(String[] args) {
	  int arr[] = {15 , 10 , 18, 12, 5, 7, 2, 1, 13};
	  previousGreater(arr);
  }

  private static void previousGreater(int arr[]){
  	Stack<Integer> stack = new Stack<>();
    for (int i = 0; i<arr.length; i++) {
	    while (!stack.isEmpty() && stack.peek() <= arr[i])
	    	stack.pop();

	    if(stack.isEmpty())
	    	System.out.print("-1 ");
	    else
	    	System.out.print(stack.peek() + " ");

	    stack.add(arr[i]);
    }
    System.out.println();
  }
}
