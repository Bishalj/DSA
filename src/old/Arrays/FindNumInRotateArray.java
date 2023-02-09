package old.Arrays;

public class FindNumInRotateArray {

    public static void main(String[] args) {
        int arr[] = {5, 6, 9, 2, 3};
        int data = 3;
        int pivot = findThePivotIndex(arr, 0, arr.length-1, data);
        System.out.println("Index is: " + (pivot+1));
    }

    private static int findThePivotIndex(int[] arr, int low, int high, int data) {
        if(low > high)
            return -1;

        int mid = (low+high)/2;

        if(arr[mid] == data)
            return mid;

        if(arr[low] <= arr[mid]){
            if(data >= arr[low] && data <= arr[mid]){
                return findThePivotIndex(arr, low, mid-1, data);
            }

            return findThePivotIndex(arr, mid+1, high, data);

        }

        if(data >= arr[mid] && data <=arr[high])
            return findThePivotIndex(arr, mid+1, high,data);

        return findThePivotIndex(arr, low, mid-1, data);
    }

    void remainder(int data, int div){
        int rem = data%div;

        while(rem != 0){
            rem *= 10;

            int n = rem/div;

            rem = rem%div;
        }
    }
}
