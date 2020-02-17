package Stack;

import java.util.HashMap;
import java.util.Map;

public class StockSpanProblem {

    public static void main(String[] args) {
        int array[] = {1,2,3,1,1,2,7,1,2,10,1,2,3,1,2,16,1,2,1,1,2,3,1,1,1,4,1,10,13,1,2,1,4,18,1,1,3,4,1,24,1,2,1,2,3,6,1,2,3,1,11,12,1,2,3,4,1,6,1,1,2,3,4,6,1,66,1,2,1,2,1,1,2,1,1,5,77,1,1,1,4,5,1,1,1,2,3,4,1,1,7,1,11,1,1,1,2,3,5,23,1,1,2,1,4,1,1,2,8,1,10,1,1,14,1,1,17,18,1,2,3,1,2,1,4,1,6,1,2,3,1,1,2,134};
        printTheStockSpanDays(array, array.length);
    }

    private static void printTheStockSpanDays(int[] array, int length) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        Map<Integer, Integer> leastCountMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(stack.empty() || stack.peek() > array[i]) {
                stack.push(array[i]);
                leastCountMap.put(array[i], 1);
                System.out.print(1 + " ");
            }
            else{
                int count = 1;
                while(!stack.empty() &&  stack.peek() <= array[i]){
                    if(leastCountMap.get(stack.peek()) == null)
                        count++;
                    else
                        count += leastCountMap.get(stack.peek());
                    stack.pop();
                }
                stack.push(array[i]);
                System.out.print(count + " ");
                leastCountMap.put(array[i], count);
            }
        }
    }
}
