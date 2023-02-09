package old.Searching;

import old.utils.CommonUsedUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MinimumNuberOfPages {

//    public static void main(old.String[] args)throws IOException {
//        InputStream in;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int testCases = Integer.parseInt(br.readLine());
//        for (int i = 0; i < testCases; i++) {
//            int arraySize = Integer.parseInt(br.readLine());
//            old.String array[]= br.readLine().split(" ");
//            int intehgerArray[] = getIntegerArray(array);
//            int k = Integer.parseInt(br.readLine());
//            int numberOfFieldsToBeSorted = arraySize - k;
//            getTheSmallestKthIndexElementUsingQuickSort(0, arraySize-1, intehgerArray, numberOfFieldsToBeSorted);
//            int displayMaximum = 0;
//            for(int j=0; j< numberOfFieldsToBeSorted; j++){
//                if(j<=numberOfFieldsToBeSorted)
//                    displayMaximum += intehgerArray[j];
//                else if(intehgerArray[j] > displayMaximum)
//                    displayMaximum = intehgerArray[j];
//            }
//            System.out.println(displayMaximum);
//        }
//
//    }
//
    private static int[] getIntegerArray(String[] array) {
        int arr[] =new int [array.length];
        for (int i = 0; i <array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        return arr;
    }
//
//    public static void getTheSmallestKthIndexElementUsingQuickSort(int lowerBoundIndex, int upperBoundIndex, int[] array, int kthIndex) {
//        if(lowerBoundIndex >= upperBoundIndex)
//            return;
//
//        int partitionElementIndex = getTheSmallestKthIndexElement(lowerBoundIndex, upperBoundIndex,array, kthIndex);
//        if(partitionElementIndex == kthIndex)
//            return;
//        else if(partitionElementIndex > kthIndex)
//            getTheSmallestKthIndexElementUsingQuickSort(lowerBoundIndex, partitionElementIndex - 1, array, kthIndex);
//        else
//            getTheSmallestKthIndexElementUsingQuickSort( partitionElementIndex + 1, upperBoundIndex, array, kthIndex);
//
//    }
//
//    private static int getTheSmallestKthIndexElement(int lowerBoundIndex, int upperBoundIndex, int[] array, int kthIndex) {
//        int pivotIndex = upperBoundIndex;
//        while (true){
//            if(lowerBoundIndex >= upperBoundIndex)
//                break;
//            while(lowerBoundIndex < pivotIndex){
//                if(array[lowerBoundIndex] > array[pivotIndex]){
//                    swapElements(array, lowerBoundIndex, pivotIndex);
//                    pivotIndex = lowerBoundIndex;
//                    break;
//                }
//                lowerBoundIndex++;
//            }
//
//            while(upperBoundIndex > pivotIndex){
//                if(array[upperBoundIndex] < array[pivotIndex]){
//                    swapElements(array, upperBoundIndex, pivotIndex);
//                    pivotIndex = upperBoundIndex;
//                    break;
//                }
//                upperBoundIndex--;
//            }
//        }
//        return pivotIndex;
//    }
//
//    private static void swapElements(int array[], int indexOne, int indexTwo) {
//        int temp = array[indexOne];
//        array[indexOne] = array[indexTwo];
//        array[indexTwo] = temp;
//    }

    public static void main(String[] args)throws IOException {
        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int arraySize = Integer.parseInt(br.readLine());
            String array[] = br.readLine().split(" ");
            int intehgerArray[] = getIntegerArray(array);
            int k = Integer.parseInt(br.readLine());
            int numberOfFieldsToBeSorted = arraySize - k;
            System.out.println(getTheSmallestKthIndexElementUsingQuickSort1  (arraySize, intehgerArray, numberOfFieldsToBeSorted));
        }
    }

    private static int getTheSmallestKthIndexElementUsingQuickSort1(int arraySize, int[] intehgerArray, int numberOfFieldsToBeSorted) {
        int tmpSum = 0;
        for(int i=0; i<arraySize-numberOfFieldsToBeSorted+1; i++){
            tmpSum += intehgerArray[i];
        }
        int maximumSum = tmpSum;
        CommonUsedUtils.displayArray(intehgerArray);
        for(int i=arraySize - numberOfFieldsToBeSorted + 1; i<arraySize; i++) {
            System.out.println("i: "+ i);
            if (intehgerArray[i - (arraySize - numberOfFieldsToBeSorted + 1)] < tmpSum + intehgerArray[i])
                maximumSum = intehgerArray[i - (arraySize - numberOfFieldsToBeSorted + 1)];
            if (tmpSum < intehgerArray[i])
                maximumSum = intehgerArray[i];
            if(tmpSum + intehgerArray[i] - intehgerArray[i - arraySize - numberOfFieldsToBeSorted + 1] < tmpSum)
                maximumSum = tmpSum + intehgerArray[i] - intehgerArray[i - (arraySize - numberOfFieldsToBeSorted + 1)];

            tmpSum = tmpSum + intehgerArray[i] - intehgerArray[i - (arraySize - numberOfFieldsToBeSorted + 1)];
        }
        return maximumSum;
    }
}
