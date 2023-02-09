package old.Arrays;

public class RepeatingNumber {

    public static void main(String[] args) {
        int arr[] = {0, 4, 3, 2, 7, 8, 2, 3, 1, 0};
        for (int i = 0; i <arr.length; i++) {
            arr[arr[i]%arr.length] = arr[arr[i]%arr.length] + arr.length;

        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 2*arr.length)
                System.out.print(i + " ");
        }
    }
}
