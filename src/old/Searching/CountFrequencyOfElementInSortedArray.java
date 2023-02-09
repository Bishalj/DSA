package old.Searching;

public class CountFrequencyOfElementInSortedArray {

    public static void main(String[] args) {
        int arr[] = {1,1,1,1,1,1};
        int searchNumber = 1;
        int leftMostIndex = getTheLeftMostOccurenceOfTheElement(arr, searchNumber, 0, arr.length -1);

        if(leftMostIndex == 0) {
            System.out.println("Result: " + leftMostIndex);
            return;
        }


        int rightMostIndex = getTheRightMostOccurenceOfTheElement(arr, searchNumber, leftMostIndex, arr.length -1);

        System.out.println("Left Most Index: " + leftMostIndex);
        System.out.println("Right Most Index: " + rightMostIndex);
        System.out.println(
                rightMostIndex  - leftMostIndex + 1
        );
    }

    //recursive
    private static int getTheLeftMostOccurenceOfTheElement(int array[], int searchNumber, int lowerBoundIndex, int upperBoundIndex){

        if(lowerBoundIndex > upperBoundIndex)
            return 0;

        int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;
        if(array[middleIndex] == searchNumber && ( middleIndex == 0 || array[middleIndex -1] != searchNumber) )
            return middleIndex + 1;

        else if(array[middleIndex] >= searchNumber)
            return getTheLeftMostOccurenceOfTheElement(array, searchNumber, lowerBoundIndex, middleIndex - 1);
        else
            return getTheLeftMostOccurenceOfTheElement(array, searchNumber, middleIndex + 1, upperBoundIndex);
    }

    private static int getTheRightMostOccurenceOfTheElement(int array[], int searchNumber, int lowerBoundIndex, int upperBoundIndex){

        if(lowerBoundIndex > upperBoundIndex)
            return 0;

        int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;
        if(array[middleIndex] == searchNumber && ( (middleIndex == array.length - 1)  || array[middleIndex +1] != searchNumber) )
            return middleIndex + 1;

        else if(array[middleIndex] > searchNumber)
            return getTheRightMostOccurenceOfTheElement(array, searchNumber, lowerBoundIndex, middleIndex - 1);
        else
            return getTheRightMostOccurenceOfTheElement(array, searchNumber, middleIndex + 1, upperBoundIndex);
    }
}
