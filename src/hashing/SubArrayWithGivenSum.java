package hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int array[] = {8,3,1,5,-6,6,2,2};
        int sumNeeded = 4;
        System.out.println(isSubArrayWithZeroSumPresent(array, array.length, sumNeeded));
    }

    private static int isSubArrayWithZeroSumPresent(int[] array, int n, int sum) {
        int sumOfArrayElements =0;
        Map<Integer, Integer> map = new HashMap<>(array.length);
        int max =0;
        for (int i=0; i<array.length; i++) {
            /*Adding the displayMaximum as if the displayMaximum is the given number at any contiguous position
            then the displayMaximum goes back to the same number again
            Eg -> array = {-5,-8,6,13,3,-1};
                summationSet = {-5, -13, -7, 6, 9, 8}
                We check: -> given num = 22
                -5 - 22 = -27 not present in set
                -13 - 22 = -35 not present in set
                -7 - 22 = -29 not present in set
                6 - 22 = -16 not present in set
                9 - 22 = -13 PRESENT IN SET, therefore the summation number is present
            */
            int calculatedMaximunIndexDifference = 0;
            sumOfArrayElements  += array[i];
            int differenceValue = sumOfArrayElements - sum;

            if(sumOfArrayElements == sum)
                calculatedMaximunIndexDifference = i + 1;
            else if(map.get(differenceValue) != null)
                calculatedMaximunIndexDifference = i - map.get(differenceValue);
            else if(map.get(sumOfArrayElements) == null)
                map.put(sumOfArrayElements, i);

            if(calculatedMaximunIndexDifference > max)
                max = calculatedMaximunIndexDifference;

        }
        return max;

    }
}
