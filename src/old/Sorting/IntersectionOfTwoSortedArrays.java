package old.Sorting;

public class IntersectionOfTwoSortedArrays {

    public static void main(String[] args) {
        int sortedArrayOne[] = {0,1,1,3,3,3,4};
        int sortedArrayTwo[] = {1,1,1,1,1,1,1,1,1,3,4,4,4,4,5,7};

        printTheIntersectionNumbers(sortedArrayOne, sortedArrayTwo);
    }


    private static void printTheIntersectionNumbers(int[] sortedArrayOne, int[] sortedArrayTwo) {

        int arrayOneIndex = 0, arrayTwoIndex = 0;
        boolean isIndexNeededToBeConsider = true;
        while (arrayOneIndex < sortedArrayOne.length && arrayTwoIndex < sortedArrayTwo.length){
            if(sortedArrayOne[arrayOneIndex] == sortedArrayTwo[arrayTwoIndex]){
                if(isIndexNeededToBeConsider)
                    System.out.println(sortedArrayOne[arrayOneIndex]);
                arrayOneIndex++;
                arrayTwoIndex++;
                isIndexNeededToBeConsider=false;

            }else if (sortedArrayOne[arrayOneIndex] < sortedArrayTwo[arrayTwoIndex]) {
                arrayOneIndex++;
                isIndexNeededToBeConsider = true;
            }
             else {
                arrayTwoIndex++;
                isIndexNeededToBeConsider = true;
            }
        }

    }
}
