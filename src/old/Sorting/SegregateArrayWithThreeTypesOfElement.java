package old.Sorting;

public class SegregateArrayWithThreeTypesOfElement {

    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,2};
        int lowerBoundIndex = 0;
        int upperBoundIndex = arr.length-1;
        int valueOfPivotElement = 1;
        displayArray(arr);
        quickSort(arr, lowerBoundIndex, upperBoundIndex, valueOfPivotElement);
        displayArray(arr);
    }

    private static void quickSort(int[] arr, int lowerBoundIndex, int upperBoundIndex, int valueOfPivotElement) {

        if(lowerBoundIndex >= upperBoundIndex)
            return;
        int pivotElementIndex = -1;
        for(int i=0; i<=upperBoundIndex; i++){
            if(arr[i] == valueOfPivotElement) {
                pivotElementIndex = i;
                break;
            }
        }
        if(pivotElementIndex == -1)
            return;
        int partitionElementIndex = partitionArrayUsingQuickSort(arr, lowerBoundIndex, pivotElementIndex, upperBoundIndex);
    }

    private static int partitionArrayUsingQuickSort(int[] array, int startIndex, int pivotIndex, int endIndex) {

        if(startIndex >= endIndex)
            return pivotIndex;

        while(startIndex < pivotIndex){
            if(isElementGreaterThanEqualsToPivot(startIndex, pivotIndex, array)){
                swapElements(array, startIndex, pivotIndex);
                pivotIndex = startIndex;
                break;
            }
            startIndex++;
        }

        while(endIndex > pivotIndex){
            if(isElementLessThanPivot(endIndex, pivotIndex, array)){
                swapElements(array, endIndex, pivotIndex);
                pivotIndex = endIndex;
                break;
            }
            endIndex--;
        }
        return partitionArrayUsingQuickSort(array, startIndex, pivotIndex, endIndex);
    }

    private static boolean isElementGreaterThanEqualsToPivot(int startIndex, int pivot, int array[]) {
        return array[startIndex] == 1 || array[startIndex] == 2;
    }

    private static boolean isElementLessThanPivot(int endIndex, int pivot, int[] array) {
        return array[endIndex] == 0 || array[endIndex] == 1 ;
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
