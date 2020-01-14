package Searching;

public class SmallestPossibleMissingNumber {

    public static void main(String[] args) {
        int array [] ={36,20,44,-5,8,2,-42,36,48,-45,-37,-6,-20,-29,-3,-43,8,-50,
                28,-21,-43,8,3,29,-43,22,25,-40,-48,-46,-42,-10,-24,-48,36,35,-44,-4,-27,-46,1,-13,-49,-17,-40,-2,42};
        displayArray(array);
        System.out.println(missingNumber(array));
    }

    private static int missingNumber(int[] array) {

        //as smallest element can be smallest positive element missing in the array
        int startingIndex = 0;
        while(startingIndex < array.length){
            if(!isElementPresentInCorrectIndex(startingIndex, array))
                startingIndex++;
//            displayArray(array);
        }

        for (int i = 0; i < array.length; i++) {
            if(isValueNotPresentInCorrectIndex(array[i] - 1, i))
                return i+1;
        }
        return array.length + 1;
    }

    private static void displayArray(int[] array) {
        for (int value :
                array) {
            System.out.print(value +" ");
        }
        System.out.println();
    }

    private static boolean isElementPresentInCorrectIndex(int startingIndex, int[] array) {

        if(isArrayValueInvalid(startingIndex, array))
            return false;

        if(isDuplicateElementAlreadyPresentInCorrectPosition(startingIndex, array))
            return false;
        // as value should be present in value - 1th position
        if(isValueNotPresentInCorrectIndex(array[startingIndex] - 1, startingIndex)) {
            swapElementWithCorrectIndexPosition(startingIndex, array[startingIndex] -1, array);
            return true;
        }
        return false;

    }

    private static boolean isDuplicateElementAlreadyPresentInCorrectPosition(int startingIndex, int[] array) {
        return (array[startingIndex] == array[array[startingIndex]-1]);
    }

    private static boolean isValueNotPresentInCorrectIndex(int i, int startingIndex) {
        return i != startingIndex;
    }

    private static boolean isArrayValueInvalid(int startingIndex, int[] array) {
        return array[startingIndex] <= 0 || array[startingIndex] > array.length;
    }

    private static void swapElementWithCorrectIndexPosition(int indexOne, int indexTwo, int[] array) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
