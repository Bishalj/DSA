package Arrays;

public class ConsecutiveSubArrayWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {1,4,0,0,3,10,5};
        int k = 3;
        System.out.println(isSubArraySummationValid(arr, k) ? "Yes" : "No");
    }

    private static boolean isSubArraySummationValid(int[] arr, int k) {
        int frontIndex = 0, rearIndex = 0;
        int summationOfArraysValue = 0;
        while (rearIndex < arr.length){


            if(summationOfArraysValue > k){
                summationOfArraysValue -= arr[frontIndex++];
            }
            else {
                summationOfArraysValue += arr[rearIndex++];
            }

            if(summationOfArraysValue == k)
                return true;
        }

        return false;
    }


}
