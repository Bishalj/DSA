package Arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        int arr[] = {5,-10,6,90,3};
        int k = 2;
        System.out.println(getTheMaximumSum(arr, k));
    }

    private static int getTheMaximumSum(int[] arr, int k) {
        int result , tmpResult=0;
        for(int i=0; i<arr.length; i++){
            tmpResult += arr[i];
        }
        result = tmpResult;
        for(int i=k; i<arr.length; i++){
            tmpResult += arr[i] - arr[i-k];
            if(tmpResult > result)
                result = tmpResult;
        }

        return result;
    }
}
