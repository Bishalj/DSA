package old.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArrayWithGivenSum {
    public static void main(String[] args) {
        int array[] = {8,3,7};
        int sumNeeded = 15;
        System.out.println(isSubArrayWithZeroSumPresent(array, array.length, sumNeeded));
    }

    private static int isSubArrayWithZeroSumPresent(int[] array, int n, int sum) {
        int sumOfArrayElements =0;
        Map<Integer, Integer> map = new HashMap<>(array.length);
        int max =0;
        for (int i=0; i<array.length; i++) {
            int calculatedMaximunIndexDifference = 0;
            sumOfArrayElements  += array[i];
            int differenceValue = sumOfArrayElements - sum;

            if(sumOfArrayElements == sum)
                calculatedMaximunIndexDifference = i + 1;
            else if(map.get(differenceValue) != null)
                calculatedMaximunIndexDifference = i - map.get(differenceValue);

            if(map.get(sumOfArrayElements) == null)
                map.put(sumOfArrayElements, i);

            if(calculatedMaximunIndexDifference > max)
                max = calculatedMaximunIndexDifference;

        }
        return max;

    }
}
