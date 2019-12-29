package Searching;

public class TripletSum {

    public static void main(String[] args) {
        int array [] = {2, 3, 4, 8, 9, 20, 40} ;
        int tripletSummationNumber = 32;
        System.out.println(isTripletSumElementsPresent(array, tripletSummationNumber));
    }

    private static boolean isTripletSumElementsPresent(int[] array, int tripletSummationNumber) {
        int startIndex = 0, endIndex = array.length - 1;
        while (startIndex < endIndex) {
            int numberRequiredForTripletSum = tripletSummationNumber - (array[startIndex] + array[endIndex]);
            if(numberRequiredForTripletSum < 0)
                endIndex--;
            else if (iscalculatedPairSumOfElementsATripletSum(numberRequiredForTripletSum, startIndex + 1, endIndex - 1, array))
                return true;
            else
                startIndex++;
        }
        return false;
    }

    private static boolean iscalculatedPairSumOfElementsATripletSum(int numberRequiredForTripletSum, int startIndex, int endIndex, int[] array) {
        for (int i=startIndex; i<=endIndex; i++){
            if(array[i] == numberRequiredForTripletSum) {
                System.out.println("The Start Element is: "+ array[startIndex-1]);
                System.out.println("The Middle Element is: "+ array[i]);
                System.out.println("The End Element is: "+ array[endIndex+1]);
                return true;
            }
        }
        return false;
    }



}
