package Sorting;

public class MergeSort {

    public static void main(String[] args) {
        int array[] = { 10, 5, 30, 15, 7, 8, 2, 12, 17, 31};
        int lowerBoundIndex = 0;
        int upperBoundIndex = array.length - 1;
        displayArray(array);
        mergeSort(array, lowerBoundIndex, upperBoundIndex);
        displayArray(array);
    }

    private static void mergeSort(int[] array, int lowerBoundIndex, int upperBoundIndex) {

        if(lowerBoundIndex >= upperBoundIndex)
            return;

        int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;

        mergeSort(array, lowerBoundIndex, middleIndex);
        mergeSort(array, middleIndex + 1, upperBoundIndex);
        mergeArray(array, lowerBoundIndex, middleIndex, upperBoundIndex);
    }

    private static void mergeArray(int[] array, int lowerBoundIndex, int middleIndex, int upperBoundIndex) {
        int leftArray[] = new int[middleIndex - lowerBoundIndex + 1];
        int rightArray[] = new int[upperBoundIndex - middleIndex];
        int leftArraySize = leftArray.length;
        int rightArraySize = rightArray.length;
        for(int i=0; i<leftArraySize; i++)
            leftArray[i] = array[ lowerBoundIndex + i];

        for(int j=0; j<rightArraySize; j++)
            rightArray[j] = array[middleIndex + j + 1];

        int leftArrayStartIndex = 0;
        int rightArrayStartIndex = 0;
        int newArrayIndex = lowerBoundIndex;
        while(leftArrayStartIndex < leftArraySize && rightArrayStartIndex < rightArraySize){
            if(leftArray[leftArrayStartIndex] < rightArray[rightArrayStartIndex])
                array[newArrayIndex++] = leftArray[leftArrayStartIndex++];
            else
                array[newArrayIndex++] = rightArray[rightArrayStartIndex++];
        }

        while(leftArrayStartIndex < leftArraySize)
            array[newArrayIndex++] = leftArray[leftArrayStartIndex++];

        while(rightArrayStartIndex < rightArraySize)
            array[newArrayIndex++] = rightArray[rightArrayStartIndex++];
    }

    private static void displayArray(int[] array) {
        for (int element: array)
            System.out.print(element + " ");
        System.out.println();
    }
}
