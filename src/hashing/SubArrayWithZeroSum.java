package hashing;

import java.util.*;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        int array[] = {5,6,0,8};
        System.out.println(isSubArrayWithZeroSumPresent(array, array.length));
    }

    private static boolean isSubArrayWithZeroSumPresent(int[] array, int n) {
        int sumOfArrayElements =0;
        Set<Integer> set = new HashSet<>(array.length);
        for (Integer value : array) {
            /*Adding the sum as if the sum is zero at any contiguous position
            then the sum goes back to the same number again
            Eg -> array = {1, 4, 13, -3, -10, 5}
                summationSet = {1, 5, 18, 15, 5, 10}
                as 5 gets repeated only because the summation is zero
            */
            sumOfArrayElements += value;
            if(sumOfArrayElements == 0 || set.contains(sumOfArrayElements))
                return true;

            set.add(sumOfArrayElements);
        }
        return false;

    }

    private static boolean isArrayElementZero(Integer value) {
        return value.equals(0);
    }
}
