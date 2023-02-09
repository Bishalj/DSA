package old.Sorting;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {10, 80, 40, 90, 30, 50, 40, 70};
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
            if(isElementGreaterThanPivotElement(startIndex,pivotIndex, array)){
                swapElements(array, startIndex, pivotIndex);
                pivotIndex = startIndex;
                break;
            }
            startIndex++;
        }

        while(endIndex > pivotIndex){
            if(isElementLessThanPivotElement(endIndex, pivotIndex, array)){
                swapElements(array, endIndex, pivotIndex);
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

//    private static int getIndexOfPartitionedElement(int[] arr, int lowerBoundIndex, int upperBoundIndex) {
//        int pivotElementIndex = upperBoundIndex;
//                while(true){
//                    if(lowerBoundIndex >= upperBoundIndex)
//                        break;
//                    while(lowerBoundIndex < pivotElementIndex){
//                        if(arr[lowerBoundIndex] > arr[pivotElementIndex]) {
//                            swapElements(arr, lowerBoundIndex, pivotElementIndex);
//                            pivotElementIndex = lowerBoundIndex;
//                            break;
//                        }
//                        lowerBoundIndex++;
//                    }
//
//                    while(upperBoundIndex > pivotElementIndex){
//                        if(arr[pivotElementIndex] > arr[upperBoundIndex]) {
//                            swapElements(arr, upperBoundIndex, pivotElementIndex);
//                            pivotElementIndex = upperBoundIndex;
//                            break;
//                        }
//                        upperBoundIndex--;
//                    }
//                }
//                return pivotElementIndex;
//    }

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
