package old.Arrays;

public class RearrangeAlternateElements {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13/*,14,15,16,17,18,19*/};
        displayArray(arr);
        rearrange(arr, arr.length);
        displayArray(arr);
    }

    public static void rearrange(int arr[], int n){
        int count =0, position = 0,  nextPositionData = 0, previousPositionData = arr[0];
        while(count < n){
            int temp;
            if(position < n/2)
                temp = 2*(position+1) - 1;
            else
                temp = (n-position-1)*2;
            nextPositionData = arr[temp];
            arr[temp] = previousPositionData;
            previousPositionData = nextPositionData;
            position = temp;
            displayArray(arr);
            count++;
        }
    }

    private static void displayArray(int[] arr) {
        for (int value : arr)
            System.out.print(value+ " ");
        System.out.println();
    }

}
