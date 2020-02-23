package queue;

public class MaximumSumInSubArrayOfSizeK {

    public static void main(String[] args) {
        int arr[] = {10, 8 , 5, 12, 15, 7 ,6};
        int k = 3;
        printMaximumSubArraySum(arr, k);
    }

    private static void printMaximumSubArraySum(int []arr, int k) {
        if(arr.length < k) {
            System.out.println(-1);
            return;
        }
        Dequeue dequeue = new Dequeue();

        for(int i=0; i<k; i++)
            dequeue.addEnd(arr[i]);

        dequeue.displayMaximum();

        for(int i=k; i<arr.length; i++){
            dequeue.removeFront();
            dequeue.addEnd(arr[i]);
            dequeue.displayMaximum();
        }
    }
}
