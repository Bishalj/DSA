package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqualZeroAndOne {

    public static void main(String[] args) {
        int arr[] = {1,0,1,1,1,0,0};
        System.out.println(getTheLongestSubarrayLength(arr, arr.length));
    }

    private static int getTheLongestSubarrayLength(int[] arr, int length) {

        Map<Integer, Integer> summationValueLocationMap = new HashMap<>(arr.length);

        /*Assume 0 as -1
        * So whenever the sum value is zero the the count of number of 1's & 0's are same
        * And if the sum value exists previously then the count value 1's and 0's from that position to the current position is same
        * */

        int sum = 0, longestSubarrayLength = 0, tempSubArrayLength = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0)
                sum += -1;
            else
                sum += 1;

            if(isSumPresentInMap(summationValueLocationMap, sum))
                tempSubArrayLength = i - summationValueLocationMap.get(sum);
            else if (isSummationValueZero(sum))
                tempSubArrayLength = i+1;
            else
                summationValueLocationMap.put(sum, i);

            if(isTheCurrentResultLengthGreaterThanPreviousLongestLength(longestSubarrayLength, tempSubArrayLength))
                longestSubarrayLength = tempSubArrayLength;

        }
        return longestSubarrayLength;
    }

    private static boolean isTheCurrentResultLengthGreaterThanPreviousLongestLength(int longestSubarrayLength, int tempSubArrayLength) {
        return tempSubArrayLength > longestSubarrayLength;
    }

    private static boolean isSummationValueZero(int sum) {
        return sum == 0;
    }

    private static boolean isSumPresentInMap(Map<Integer, Integer> summationValueLocationMap, int sum) {
        return summationValueLocationMap.get(sum) != null;
    }
}
