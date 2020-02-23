package Stack;

import utils.CommonUsedUtils;

import java.util.Stack;

public class NotGreaterElement {

    public static void main(String[] args) {
        int arr[] = {5,15,10,8,6,11,5,12};
        int greaterElement[] = new int[arr.length];
        CommonUsedUtils.displayArray(arr);
        printTheGreaterElements(arr, arr.length, greaterElement);
        CommonUsedUtils.displayArray(greaterElement);
    }

    private static void printTheGreaterElements(int[] arr, int length, int[] greaterElement) {
        Stack<Integer> stack = new Stack<>();
        for (int i = length -1; i >=0 ; i--) {

            while(!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();


            if(stack.isEmpty())
                greaterElement[i] = -1;
            else
                greaterElement[i] = stack.peek();

            stack.push(arr[i]);
        }
    }
}
