package old.Sorting;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int arrayOne[] = {10, 15, 20, 40};
        int arrayTwo[] = {5, 6, 6, 10, 15
        };
        displayArray(getMergedArray(arrayOne, arrayTwo));

    }

    private static void displayArray(int[] array) {
        for (int element: array)
            System.out.print(element + " ");
        System.out.println();
    }

    private static int[] getMergedArray(int[] arrayOne, int[] arrayTwo) {
        int firstArrayIndex = 0, secondArrayIndex = 0;
        int mergedArray[] = new int[arrayOne.length+arrayTwo.length];

        while(firstArrayIndex < arrayOne.length && secondArrayIndex < arrayTwo.length){
            if(arrayOne[firstArrayIndex] < arrayTwo[secondArrayIndex])
                mergedArray[firstArrayIndex + secondArrayIndex] = arrayOne[firstArrayIndex++];
            else
                mergedArray[firstArrayIndex + secondArrayIndex] = arrayTwo[secondArrayIndex++];
        }

        while (firstArrayIndex < arrayOne.length)
            mergedArray[firstArrayIndex + secondArrayIndex] = arrayOne[firstArrayIndex++];

        while(secondArrayIndex < arrayTwo.length)
                mergedArray[firstArrayIndex + secondArrayIndex] = arrayTwo[secondArrayIndex++];

        return mergedArray;
    }

}
