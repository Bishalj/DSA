package old.utils;

public class CommonUsedUtils {

    public static void displayArray(int arr[]){
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    public static void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
