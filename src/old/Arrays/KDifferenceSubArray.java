package old.Arrays;

import java.util.Deque;
import java.util.LinkedList;

public class KDifferenceSubArray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 6, 7 };
        int k = 2;
        System.out.println(getTheMaxSubarrayLength(arr, k));
    }

    public static int getTheMaxSubarrayLength(int arr[],
                                             int k)
    {
        // Stores the maximum length subarray so far
        int maxLength = 0;

        Deque<Integer> maxHeap = new LinkedList<>();
        Deque<Integer> minHeap = new LinkedList<>();

        // Marks to the beginning and end
        // pointer for current subarray
        int beg = 0, end = 0;

        while (end < arr.length) {

            // Stores the current element being
            // added to the subarray
            int currEl = arr[end];

            // Remove indices of all elements smaller
            // than or equal to current from maxHeap
            while (maxHeap.size() > 0 &&
                    arr[maxHeap.peekLast()] <= currEl)
                maxHeap.removeLast();

            // Add current element's index to maxHeap
            maxHeap.addLast(end);

            // Remove indices of all elements larger
            // than or equal to current from minHeap
            while (minHeap.size() > 0 &&
                    arr[minHeap.peekLast()] >= currEl)
                minHeap.removeLast();

            // Add current element's index to minHeap
            minHeap.addLast(end);

            // Index of maximum of current subarray
            int maxOfSub = arr[maxHeap.peekFirst()];

            // Index of minimum of current subarray
            int minOfSub = arr[minHeap.peekFirst()];

            // check if the largest possible difference
            // between a pair of elements <= k
            if (maxOfSub - minOfSub <= k) {
                // Length of current subarray
                int currLength = end - beg + 1;

                // Update maxLength
                if (maxLength < currLength)
                    maxLength = currLength;
            }

            else {
                // If current subarray doesn't satisy
                // the condition then remove the starting
                // element from subarray that satisy
                // increment the beginning pointer
                beg++;

                // Remove elements from heaps that
                // are not in the subarray anymore
                while (minHeap.size() > 0 &&
                        minHeap.peekFirst() < beg)
                    minHeap.removeFirst();

                while (maxHeap.size() > 0 &&
                        maxHeap.peekFirst() < beg)
                    maxHeap.removeFirst();
            }

            end++;
        }

        // Return the final answer
        return maxLength;
    }
}
