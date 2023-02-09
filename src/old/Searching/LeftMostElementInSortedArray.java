package old.Searching;

public class LeftMostElementInSortedArray {

    public static void main(String[] args) {
        int arr[] = {2,2,2,2, 3,3,3,3,3, 4,4, 5, 6,6,6,7,7,7, 7};
        int searchNumber = 3;
        System.out.println(recursiveBinarySearch(arr, searchNumber, 0, arr.length -1));
    }

//Second Approach
    private static int recursiveBinarySearch(int array[], int searchNumber, int lowerBoundIndex, int upperBoundIndex){

        if(lowerBoundIndex > upperBoundIndex)
            return -1;

        int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;
        if(array[middleIndex] == searchNumber && ( middleIndex ==0 || array[middleIndex - 1] != searchNumber))
            return middleIndex + 1;

        else if(array[middleIndex] >= searchNumber)
            return recursiveBinarySearch(array, searchNumber, lowerBoundIndex, middleIndex - 1);
        else
            return recursiveBinarySearch(array, searchNumber, middleIndex + 1, upperBoundIndex);
    }

    //First Approach
    private static int recursiveBinarySearch(int array[], int searchNumber, int lowerBoundIndex, int upperBoundIndex, int result){

        if(lowerBoundIndex > upperBoundIndex)
            return result;

        int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;
        if(array[middleIndex] == searchNumber)
            return recursiveBinarySearch(array, searchNumber, lowerBoundIndex, middleIndex -1, middleIndex+1);

        else if(array[middleIndex] > searchNumber)
            return recursiveBinarySearch(array, searchNumber, lowerBoundIndex, middleIndex - 1, result);
        else
            return recursiveBinarySearch(array, searchNumber, middleIndex + 1, upperBoundIndex, result);
    }
}
