package hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int array[] = {8,3,1,5,-6,6,2,2};
        int sumNeeded = 4;
        System.out.println(isSubArrayWithZeroSumPresent(array, array.length, sumNeeded));
    }

    private static int isSubArrayWithZeroSumPresent(int[] array, int n, int sumNeeded) {
        int sumOfArrayElements =0;
        Map<Integer, Integer> map = new HashMap<>(array.length);
        int max =0;
        for (int i=0; i<array.length; i++) {
            /*Adding the sum as if the sum is the given number at any contiguous position
            then the sum goes back to the same number again
            Eg -> array = {-5,-8,6,13,3,-1};
                summationSet = {-5, -13, -7, 6, 9, 8}
                We check: -> given num = 22
                -5 - 22 = -27 not present in set
                -13 - 22 = -35 not present in set
                -7 - 22 = -29 not present in set
                6 - 22 = -16 not present in set
                9 - 22 = -13 PRESENT IN SET, therefore the summation number is present
            */
            sumOfArrayElements += array[i]; int res=0;
            int differenceValue = sumOfArrayElements - sumNeeded;
            if(sumOfArrayElements == sumNeeded)
                res = i+1;

            if(map.get(differenceValue) == null) {
                map.put(sumOfArrayElements, i);
            }
            if(map.get(differenceValue) != null){
                res = i - map.get(differenceValue);

            }
            if( res > max)
                max = res;;

        }
        return max;

    }
}
