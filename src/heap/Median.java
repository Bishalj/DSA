package heap;

import java.util.*;

public class Median {
    public static void main(String[] args) {
        int arr[] = {25,7,10,15,20};
        printTheMedian(arr);
    }

    private static void printTheMedian(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        if(arr.length == 0)
            return;
        maxHeap.add(arr[0]);
        System.out.print(arr[0] + " ");
        for (int i = 1; i < arr.length; i++) {
            if(i%2 != 0){
                if(maxHeap.peek() > arr[i]){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(arr[i]);
                }else{
                    minHeap.add(arr[i]);
                }
                System.out.print((maxHeap.peek() + minHeap.peek())*1.0/2 + " ");
            }else{
                if(minHeap.peek() < arr[i]){
                    maxHeap.add(minHeap.poll());
                    minHeap.add(arr[i]);
                }else{
                    maxHeap.add(arr[i]);
                }
                System.out.print(maxHeap.peek() + " ");
            }

        }

    }
}
