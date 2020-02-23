package Stack;

import java.util.Stack;

public class PreviousGreaterElement {

    public static void main(String[] args) {
        int arr[] = {15,10,18,12,4,6,2,8};
        printThePreviousGreaterElements(arr, arr.length);
    }

    private static void printThePreviousGreaterElements(int[] arr, int length) {
        Stack<Integer> stack = new Stack();
        int i =0;
        while(i<length) {
            while (!stack.isEmpty() && i < length && stack.peek() < arr[i])
                stack.pop();

            if (stack.empty())
                System.out.print("-1 ");
            else
                System.out.print(stack.peek()+" ");
            if (i < length)
                stack.push(arr[i]);
            i++;
        }
        System.out.println();
    }
}
