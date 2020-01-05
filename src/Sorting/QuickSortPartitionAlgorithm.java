package Sorting;

public class QuickSortPartitionAlgorithm {
    public static void main(String[] args) {
        int array[] = {50, 40, 80, 10, 90, 30, 60};
        int startIndex = 0;
        int endIndex = array.length - 1;
        int pivotIndex = 0;
        displayArray(array);
        System.out.println(partitionArrayUsingQuickSort(array, startIndex, pivotIndex, endIndex));
        displayArray(array);
    }

    private static int partitionArrayUsingQuickSort(int[] array, int startIndex, int pivotIndex, int endIndex) {

        if(startIndex >= endIndex)
            return pivotIndex;

        while(startIndex < pivotIndex){
            if(isElementGreaterThanPivotElement(startIndex,pivotIndex, array)){
                swapElements(startIndex, pivotIndex, array);
                pivotIndex = startIndex;
                break;
            }
            startIndex++;
        }

        while(endIndex > pivotIndex){
            if(isElementLessThanPivotElement(endIndex, pivotIndex, array)){
                swapElements(endIndex, pivotIndex, array);
                pivotIndex = endIndex;
                break;
            }
            endIndex--;
        }
        return partitionArrayUsingQuickSort(array, startIndex, pivotIndex, endIndex);
    }

    private static boolean isElementGreaterThanPivotElement(int startIndex, int pivotIndex, int array[]) {
        return array[startIndex] > array[pivotIndex];
    }

    private static boolean isElementLessThanPivotElement(int endIndex, int pivotIndex, int array[]) {
        return array[endIndex] < array[pivotIndex];
    }

    private static void swapElements(int indexOne, int indexTwo, int array[]) {
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
