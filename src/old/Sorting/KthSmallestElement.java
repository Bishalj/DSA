package old.Sorting;


public class KthSmallestElement {

    public static void main(String[] args) {
        int array [] = {30, 20, 5, 10, 8};
        int kthIndex=2;
        if( kthIndex > array.length - 1 || kthIndex < 0)
            return;
        displayArray(array);
        getTheSmallestKthIndexElementUsingQuickSort(0, array.length - 1 , array, kthIndex);
        displayArray(array);
        System.out.println("Kth Index element -> "+ array[kthIndex]);
    }

    public static void getTheSmallestKthIndexElementUsingQuickSort(int lowerBoundIndex, int upperBoundIndex, int[] array, int kthIndex) {
        if(lowerBoundIndex >= upperBoundIndex)
                return;

        int partitionElementIndex = getTheSmallestKthIndexElement(lowerBoundIndex, upperBoundIndex,array, kthIndex);
        if(partitionElementIndex == kthIndex)
            return;
        else if(partitionElementIndex > kthIndex)
            getTheSmallestKthIndexElementUsingQuickSort(lowerBoundIndex, partitionElementIndex - 1, array, kthIndex);
        else
        getTheSmallestKthIndexElementUsingQuickSort( partitionElementIndex + 1, upperBoundIndex, array, kthIndex);

    }

    private static int getTheSmallestKthIndexElement(int lowerBoundIndex, int upperBoundIndex, int[] array, int kthIndex) {
        int pivotIndex = upperBoundIndex;
        while (true){
            if(lowerBoundIndex >= upperBoundIndex)
                break;
            while(lowerBoundIndex < pivotIndex){
                if(array[lowerBoundIndex] > array[pivotIndex]){
                    swapElements(array, lowerBoundIndex, pivotIndex);
                    pivotIndex = lowerBoundIndex;
                    break;
                }
                lowerBoundIndex++;
            }
            System.out.println("------------------Left Part ---------------------");
            System.out.println("Lower Bound: "+lowerBoundIndex);
            System.out.println("Pivot Bound: "+pivotIndex);
            System.out.println("Upper Bound: "+upperBoundIndex);
            displayArray(array);

            while(upperBoundIndex > pivotIndex){
                if(array[upperBoundIndex] < array[pivotIndex]){
                    swapElements(array, upperBoundIndex, pivotIndex);
                    pivotIndex = upperBoundIndex;
                    break;
                }
                upperBoundIndex--;
            }
            System.out.println("------------------right Part ---------------------");
            System.out.println("Lower Bound: "+lowerBoundIndex);
            System.out.println("Pivot Bound: "+pivotIndex);
            System.out.println("Upper Bound: "+upperBoundIndex);
            displayArray(array);
        }
        return pivotIndex;
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
