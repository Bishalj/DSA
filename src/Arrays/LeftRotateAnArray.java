package Arrays;

public class LeftRotateAnArray {


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int numberOfTimesLeftRotate = 19;

        arr = leftRotateArray(arr, numberOfTimesLeftRotate);
        displayArray(arr);
    }

    private static int[] leftRotateArray(int[] arr, int numberOfTimesLeftRotate) {
        int newArr[] = new int[arr.length];
        numberOfTimesLeftRotate = numberOfTimesLeftRotate % arr.length;
        int newArrayIndex = 0;
        for(int i=numberOfTimesLeftRotate; i<arr.length; i++)
            newArr[newArrayIndex++] = arr[i];

        for (int i=0; i<numberOfTimesLeftRotate; i++)
            newArr[newArrayIndex++] = arr[i];
        return newArr;
    }

    private static void displayArray(int[] arr) {
        for (int value : arr)
            System.out.println(value);
    }
}
