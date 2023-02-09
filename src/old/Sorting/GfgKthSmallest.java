package old.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class GfgKthSmallest {
    public static void main (String[] args)throws IOException {
        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        for(int i=0; i<numberOfTestCases; i++){
            final int arraySize = Integer.parseInt(br.readLine());
            int array[] = convertToIntegerArray (br.readLine().split(" "));
            final int kthIndex = Integer.parseInt(br.readLine()) - 1;
            KthSmallestElement.getTheSmallestKthIndexElementUsingQuickSort(0, arraySize-1, array, kthIndex);
            System.out.println(array[kthIndex]);
        }
    }

    private static int[] convertToIntegerArray(String[] s) {
        int integerArray[] = new int[s.length];
        for (int i=0; i<s.length; i++){
            integerArray[i] = Integer.parseInt(s[i]);
        }
        return integerArray;
    }
}

/*package whatever //do not write package name here */


class GFG {
    public static void main (String[] args)throws IOException {
        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        for(int i=0; i<numberOfTestCases; i++){
            final int arraySize = Integer.parseInt(br.readLine());
            int array[] = convertToIntegerArray (br.readLine().split(" "));
            final int kthIndex = Integer.parseInt(br.readLine()) - 1;
            getTheSmallestKthIndexElementUsingQuickSort(0, arraySize-1, array, kthIndex);
            System.out.println(array[kthIndex]);
        }
    }

    private static int[] convertToIntegerArray(String[] s) {
        int integerArray[] = new int[s.length];
        for (int i=0; i<s.length; i++){
            integerArray[i] = Integer.parseInt(s[i]);
        }
        return integerArray;
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
//            System.out.println("------------------Left Part ---------------------");
//            System.out.println("Lower Bound: "+lowerBoundIndex);
//            System.out.println("Pivot Bound: "+pivotIndex);
//            System.out.println("Upper Bound: "+upperBoundIndex);
//            displayArray(array);

            while(upperBoundIndex > pivotIndex){
                if(array[upperBoundIndex] < array[pivotIndex]){
                    swapElements(array, upperBoundIndex, pivotIndex);
                    pivotIndex = upperBoundIndex;
                    break;
                }
                upperBoundIndex--;
            }
//            System.out.println("------------------right Part ---------------------");
//            System.out.println("Lower Bound: "+lowerBoundIndex);
//            System.out.println("Pivot Bound: "+pivotIndex);
//            System.out.println("Upper Bound: "+upperBoundIndex);
//            displayArray(array);
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

