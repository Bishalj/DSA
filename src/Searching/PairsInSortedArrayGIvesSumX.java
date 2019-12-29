package Searching;


public class PairsInSortedArrayGIvesSumX {

    public static void main(String[] args) {
        int array [] = {2,5,8,12,30} ;
        int pairSummationNumber = 30;
        System.out.println(isPairSumElementsPresent(array, pairSummationNumber));
    }

    private static boolean isPairSumElementsPresent(int[] array, int pairSummationNumber) {
        int startIndex = 0, endIndex = array.length - 1;
        while (startIndex < endIndex){
            int calculatedPairSumOfElements = array[startIndex] + array[endIndex];
            if(calculatedPairSumOfElements == pairSummationNumber){
                System.out.println("Start Index - End Index: " + (startIndex+1) + " - " + (endIndex + 1));
                return true;
            }else if(calculatedPairSumOfElements > pairSummationNumber)
                endIndex--;
            else
                startIndex++;
        }
        return false;
    }
}
