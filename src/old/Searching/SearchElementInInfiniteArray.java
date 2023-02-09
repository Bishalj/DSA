package old.Searching;

public class SearchElementInInfiniteArray {


    public static void main(String[] args) {
        //suppose the array is infinite
        int arr[] = {2,2,2,2, 3,3,3,3,3, 4,4, 5, 6,7};
        int searchNumber = 5;
        int upperBound = 1;
        boolean numberPresent = false;
        if(arr[0] == searchNumber){
            System.out.println(1);
            return;
        }
        while(upperBound < arr.length){
            upperBound = upperBound*2;
            if(upperBound > arr.length)
                upperBound = arr.length -1;

            if(arr[upperBound] == searchNumber){
                System.out.println(upperBound+1);
                return;
            }
            if(arr[upperBound] > searchNumber) {
                numberPresent = true;
                break;
            }else if(arr.length - 1 == upperBound){
                break;
            }

        }
        if(!numberPresent) {
            System.out.println(-1);
            return;
        }

        System.out.println(recursiveBinarySearch(arr, searchNumber, upperBound/2, upperBound));
    }

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
}
