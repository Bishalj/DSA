package old.Sorting;

public class SegregateArrayWithTwoTypeOfElements {

    public static void main(String[] args) {
        int arr[] = {0, 1, 1 ,0, 1,0,1,1,0,0,0,0,1,0,1,1,0,1,1,1,1,1,1,0};
        int lowerBoundIndex = 0;
        int upperBoundIndex = arr.length-1;
        displayArray(arr);
        quickSort(arr, lowerBoundIndex, upperBoundIndex);
        displayArray(arr);
    }

    private static void quickSort(int[] arr, int lowerBoundIndex, int upperBoundIndex) {

        if(lowerBoundIndex >= upperBoundIndex)
            return;

        int partitionElementIndex = partitionArrayUsingQuickSort(arr, lowerBoundIndex, upperBoundIndex, upperBoundIndex);
        quickSort(arr, lowerBoundIndex, partitionElementIndex -1);
        quickSort(arr, partitionElementIndex + 1, upperBoundIndex);
    }

    private static int partitionArrayUsingQuickSort(int[] array, int startIndex, int pivotIndex, int endIndex) {

        if(startIndex >= endIndex)
            return pivotIndex;

        while(startIndex < pivotIndex){
            if(isElementValueOne(startIndex,array)){
                swapElements(array, startIndex, pivotIndex);
                pivotIndex = startIndex;
                break;
            }
            startIndex++;
        }

        while(endIndex > pivotIndex){
            if(isElementValueZero(endIndex, array)){
                swapElements(array, endIndex, pivotIndex);
                pivotIndex = endIndex;
                break;
            }
            endIndex--;
        }
        return partitionArrayUsingQuickSort(array, startIndex, pivotIndex, endIndex);
    }

    private static boolean isElementValueOne(int startIndex, int array[]) {
        return array[startIndex] == 1;
    }

    private static boolean isElementValueZero(int endIndex, int[] array) {
        return array[endIndex] == 0;
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
