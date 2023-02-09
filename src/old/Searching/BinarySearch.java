package old.Searching;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {2,2,2,2, 3,3,3,3,3, 4,4, 5, 6,6,6,7,7,7, 7};
        int searchNumber = 3;
        System.out.println(recursiveBinarySearch(arr, searchNumber, 0, arr.length -1));
    }

    //recursive
    private static int recursiveBinarySearch(int array[], int searchNumber, int lowerBoundIndex, int upperBoundIndex){

        if(lowerBoundIndex > upperBoundIndex)
            return -1;

        int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;
        if(array[middleIndex] == searchNumber)
            return middleIndex+1;

        else if(array[middleIndex] > searchNumber)
            return recursiveBinarySearch(array, searchNumber, lowerBoundIndex, middleIndex - 1);
        else
            return recursiveBinarySearch(array, searchNumber, middleIndex + 1, upperBoundIndex);
    }

    //iterative
    private static int getTheIndexOfSearchNumberInArray(int array[], int searchNumber){
        int lowerBoundIndex = 0;
        int upperBoundIndex = array.length -1;

        while(lowerBoundIndex <= upperBoundIndex){
            int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;

            if(array[middleIndex] == searchNumber)
                return middleIndex+1;
            else if(array[middleIndex] > searchNumber)
                upperBoundIndex = middleIndex - 1;
            else
                lowerBoundIndex = middleIndex + 1;

        }
        return -1;
    }
}
