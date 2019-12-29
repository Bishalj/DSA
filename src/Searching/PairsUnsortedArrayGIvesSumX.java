package Searching;

import java.util.HashSet;
import java.util.Set;

public class PairsUnsortedArrayGIvesSumX {


    public static void main(String[] args) {
        int array [] = {3,5,9,9,10,9,8} ;
        int pairSummationNumber = 17;
        System.out.println(isPairSumElementsPresent(array, pairSummationNumber));
    }

    private static boolean isPairSumElementsPresent(int[] array, int pairSummationNumber) {
        Set<Integer> differnceSumMap = new HashSet<Integer>();
        for (int i=0; i<array.length; i++){
            if(IsOtherPairElementPresentInSet(differnceSumMap.contains(array[i])))
                return true;
            int differenceWithPairSummationNumber = pairSummationNumber - array[i];
            differnceSumMap.add(differenceWithPairSummationNumber);
        }
        return false;
    }

    private static boolean IsOtherPairElementPresentInSet(boolean contains) {
        return contains;
    }
}
