package old.heap;

import java.util.PriorityQueue;

public class MaximumItemsWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {9,8,7,15,18};
        int sum=40;

        System.out.println(countOfMaximumItemsWithGivenSum(arr, sum));
    }

    private static int countOfMaximumItemsWithGivenSum(int[] arr, int sum) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }

        int count = 0;
        while (!priorityQueue.isEmpty()){
            sum = sum - priorityQueue.poll();
            if(sum < 0)
                return count;
            count++;
        }
        return arr.length;
    }
}
