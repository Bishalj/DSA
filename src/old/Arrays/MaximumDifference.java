package old.Arrays;

public class MaximumDifference {

    public static void main(String[] args) {
        int arr[]= {3, 9, 2,11,1};
        System.out.println(getTheMaximumDifference(arr));
    }

    private static int getTheMaximumDifference(int[] arr) {

        int n = arr.length, maxValue = 0;
        if(n < 2)
            return 0;

        int maxDifference = arr[n - 1] - arr[n - 2];
        if(maxDifference > 0)
            maxValue = arr[n - 1];
        else
            maxValue = arr[n - 2];

        for(int i= n-3; i>=0; i--){
            int tempDifference = maxValue - arr[i];
            if(tempDifference < 0) {
                maxValue = arr[i];
            }
            if(tempDifference > maxDifference)
                maxDifference = tempDifference;
        }

        return maxDifference;
    }
}
