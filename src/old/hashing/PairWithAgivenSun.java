package old.hashing;

import java.util.HashSet;
import java.util.Set;

public class PairWithAgivenSun {
    public static void main(String[] args) {
        int array [] = {2,5};
        int sumValueNeeded = 10;
        System.out.println(printTheNumberOfPairSumPresent(array, array.length, sumValueNeeded));

    }

    private static int printTheNumberOfPairSumPresent(int[] array, int length, int sumValueNeeded) {
        Set<Integer> pairSumDifferenceMap = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int pairSumDifference = sumValueNeeded - array[i];
            if(pairSumDifferenceMap.contains(pairSumDifference))
                return 1;
            else
                pairSumDifferenceMap.add(array[i]);

        }
        return 0;
    }
}
