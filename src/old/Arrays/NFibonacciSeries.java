package old.Arrays;

public class NFibonacciSeries {
    public static void main(String[] args) {
        printNFibonacciSeries(4, 10);
    }

    private static void printNFibonacciSeries(int n, int m) {
        int arr[] = new int[m];
        for (int i=0; i<n && i<m; i++){
            if(i == n-1)
                arr[i] = 1;
            else
                arr[i] = 0;
        }
        int fiboNumber = 1;
        for (int i=n; i<m; i++){
            arr[i] = fiboNumber;
            fiboNumber += fiboNumber - arr[i - n];
        }

        displayArray(arr);

    }

    private static void displayArray(int[] arr) {
        for (int values: arr){
            System.out.print(values + " ");
        }
    }
}
