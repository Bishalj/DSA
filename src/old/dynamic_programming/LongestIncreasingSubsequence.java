package old.dynamic_programming;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int arr[] = {3,7,2,3,4,5,11,9,10};
        int index = 0;
        int lastValue = Integer.MIN_VALUE;
        System.out.println(getTheLongestIncreasingSubsequence(arr, index, lastValue));
    }

    private static int getTheLongestIncreasingSubsequence(int[] arr, int index, int lastValue) {
        if(index == arr.length)
            return 0;

        int lengthIncluding =0;
        if(arr[index] > lastValue)
            lengthIncluding = 1 + getTheLongestIncreasingSubsequence(arr, index+1, arr[index]);

        int lengthExcluding = getTheLongestIncreasingSubsequence(arr, index+1, lastValue);
        if(lengthExcluding > lengthIncluding)
            return lengthExcluding;

        return lengthIncluding;
    }
}