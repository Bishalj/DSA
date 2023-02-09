package old.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int array[] = {7,4,5,2,6,3,8,1};
        displayArray(array);
        sortTheArrayUsingInsertionSort(array);

    }

    private static void displayArray(int[] array) {
        for (int element: array)
            System.out.print(element + " ");
        System.out.println();
    }

    private static void sortTheArrayUsingInsertionSort(int[] array) {
        for(int i=1; i<array.length; i++){
            int tempElement = array[i];
            int j = i-1;
            while (j >=0 && array[j] > tempElement) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = tempElement;
        }
        displayArray(array);
    }
}
