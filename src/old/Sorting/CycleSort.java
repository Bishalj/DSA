package old.Sorting;

public class CycleSort {
    public static void main(String[] args) {
        int array [] = {20, 40, 50, 10, 30};
        displayArray(array);
        System.out.println(getMinimumNumberOfSwapsRequiredToSortAnArray(array));
        displayArray(array);
    }

    private static int getMinimumNumberOfSwapsRequiredToSortAnArray(int[] array) {
        int currentIndex = 0;

        int numberOfSwapsRequired = 0;
        for(int i=0; i<array.length; i++){
            int numberOfElementGreaterThanCurrentElement = 0;
            for(int j=0; j<array.length; j++){
                if(array[currentIndex] > array[j])
                    numberOfElementGreaterThanCurrentElement++;
            }
            if(currentIndex != numberOfElementGreaterThanCurrentElement){
                numberOfSwapsRequired++;
                swapElements(array, currentIndex, numberOfElementGreaterThanCurrentElement);
            }else {
                currentIndex++;
            }
        }
        return numberOfSwapsRequired;
    }


    private static void swapElements(int array[], int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private static void displayArray(int[] array) {
        for (int element: array)
            System.out.print(element + " ");
        System.out.println();
    }
}
