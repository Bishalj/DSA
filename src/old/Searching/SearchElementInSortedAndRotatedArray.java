package old.Searching;

public class SearchElementInSortedAndRotatedArray {


    public static void main(String[] args) {
        //suppose the array is infinite
        int arr[] = {10, 20, 40, 50, 60, 70,8};
        int searchNumber = 0;
        int lowerBoundIndex = 0;
        int upperBoundIndex = arr.length -1;

        int pivotElementIndex = getPivotElementIndex(arr, lowerBoundIndex, upperBoundIndex);
        int rotationAdjustedLowerBoundIndex = lowerBoundIndex + pivotElementIndex;
        int rotationAdjustedUpperBoundIndex = upperBoundIndex + pivotElementIndex;
        System.out.println("Pivot Element Index is: " + pivotElementIndex);
        System.out.println(recursiveBinarySearch(arr, searchNumber, rotationAdjustedLowerBoundIndex, rotationAdjustedUpperBoundIndex));
    }

    private static int getPivotElementIndex(int[] arr, int lowerBoundIndex, int upperBoundIndex) {
        int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;
        if(lowerBoundIndex > upperBoundIndex)
            return 0;
        if(middleIndex != 0 && arr[middleIndex] < arr[middleIndex - 1])
            return middleIndex;

        if(arr[0] < arr[middleIndex])
            return getPivotElementIndex(arr, middleIndex + 1, upperBoundIndex);
        else
            return getPivotElementIndex(arr, lowerBoundIndex, middleIndex - 1);


    }

    private static int recursiveBinarySearch(int array[], int searchNumber, int lowerBoundIndex, int upperBoundIndex){

        if(lowerBoundIndex > upperBoundIndex)
            return -1;

        int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;
        if(array[middleIndex%array.length] == searchNumber)
            return middleIndex%array.length +1;

        else if(array[middleIndex%array.length] > searchNumber)
            return recursiveBinarySearch(array, searchNumber, lowerBoundIndex, middleIndex - 1);
        else
            return recursiveBinarySearch(array, searchNumber, middleIndex + 1, upperBoundIndex);
    }
}
