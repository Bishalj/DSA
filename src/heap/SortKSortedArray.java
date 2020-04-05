package heap;

import utils.CommonUsedUtils;

import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {
        int kSortedArray[] = {9,8,7,15,18};
        int k=2;
        sortTheKSortedArray(kSortedArray, k);
        CommonUsedUtils.displayArray(kSortedArray);
    }

    private static void sortTheKSortedArray(int[] kSortedArray, int k) {
        PriorityQueue<Integer>priorityQueue = new PriorityQueue<>();

        for(int i=0; i<=k; i++)
            priorityQueue.add(kSortedArray[i]);


        int index = 0;
        for(int i=k+1; i<kSortedArray.length; i++){
            kSortedArray[index++] = priorityQueue.poll();
            priorityQueue.add(kSortedArray[i]);
        }


        while (!priorityQueue.isEmpty())
            kSortedArray[index++] = priorityQueue.poll();

    }
}
