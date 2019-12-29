package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseAnArray {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int arr[] = {1,2};

        reverseTheArray(arr);
        displayArray(arr);
    }

    private static void displayArray(int[] arr) {
        for (int value : arr)
            System.out.println(value);
    }

    private static void reverseTheArray(int[] arr) {

        for(int i=0, j=arr.length-1; i<j; i++,j--)
            swapElementsAtPostionInArray(arr,i,j);
    }

    private static void swapElementsAtPostionInArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
