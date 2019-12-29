package Searching;

public class PeakElement {

    public static void main(String[] args) {
        //suppose the array is infinite
        int arr[] = {10, 12, 15, 23, 23, 60, 63};
        int lowerBoundIndex = 0;
        int upperBoundIndex = arr.length -1;
        int peakElementPosition = getPeakElementIndex(arr, lowerBoundIndex, upperBoundIndex);
        if(peakElementPosition == -1)
            System.out.println(peakElementPosition);
        else
            System.out.println(arr[peakElementPosition]);
    }

    private static int getPeakElementIndex(int array[], int lowerBoundIndex, int upperBoundIndex){

        if(lowerBoundIndex > upperBoundIndex)
            return -1;

        int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;

        if(isMiddleIndexIsTheFirstElement(middleIndex)){
            if(isFirstElementIsAPeakElement(array))
                return middleIndex;
            return getPeakElementIndex(array, middleIndex + 1, upperBoundIndex);
        }
        else if(isMiddleIndexIsTheLastElement(middleIndex, array)) {
            if (isLastElementIsAPeakElement(array))
                return middleIndex;
            return getPeakElementIndex(array, lowerBoundIndex, middleIndex - 1);
        }
        else if(isMiddleIndexIsAPeakElement(middleIndex, array))
            return middleIndex;

        if (isRightElementOfMiddleIsGreaterThanMiddleElement(array, middleIndex)) {

            int peakElementIndex = getPeakElementIndex(array, lowerBoundIndex, middleIndex - 1);
            if (peakElementIndex != -1)
                return peakElementIndex;
            return getPeakElementIndex(array, middleIndex + 1, upperBoundIndex);
        }
        else{
            int peakElementIndex = getPeakElementIndex(array, middleIndex + 1, upperBoundIndex);
            if (peakElementIndex != -1)
                return peakElementIndex;
            return  getPeakElementIndex(array, lowerBoundIndex, middleIndex - 1);
        }
    }

    private static boolean isRightElementOfMiddleIsGreaterThanMiddleElement(int[] array, int middleIndex) {
        return array[middleIndex + 1] > array[middleIndex];
    }

    private static boolean isMiddleIndexIsAPeakElement(int middleIndex, int[] array) {
        return array[middleIndex] > array[middleIndex -1] &&
                array[middleIndex] > array[middleIndex + 1];
    }

    private static boolean isLastElementIsAPeakElement(int[] array) {
        int arrayLastPosition = array.length - 1;
        return array[arrayLastPosition] > array[arrayLastPosition - 1];
    }

    private static boolean isMiddleIndexIsTheLastElement(int middleIndex, int[] array) {
        return middleIndex == array.length - 1;
    }

    private static boolean isFirstElementIsAPeakElement(int[] array) {
        return array[0] > array[1];
    }

    private static boolean isMiddleIndexIsTheFirstElement(int middleIndex) {
        return middleIndex == 0;
    }
}
