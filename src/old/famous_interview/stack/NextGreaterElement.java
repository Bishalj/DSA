package old.famous_interview.stack;

import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args){
		int arr[] = {15 , 10 , 18, 12, 5, 7, 2, 1, 13};
		nextGreaterElement(arr);
	}

	private static void nextGreaterElement(int arr[]){
		Stack<Integer> stack = new Stack<>();
		int res[] = new int[arr.length];
		for (int i = arr.length-1; i>=0; i--) {
			while (!stack.isEmpty() && stack.peek() <= arr[i])
				stack.pop();

			if(stack.isEmpty())
				res[i] = -1;
			else
				res[i] = stack.peek();

			stack.add(arr[i]);
		}

		for(int val: res)
			System.out.print(val + " ");
		System.out.println();
	}
}



interface a1{
	void display();
	default void display1(){

	}
}
interface a2{
	void display();
	default void display1(){

	};
}

