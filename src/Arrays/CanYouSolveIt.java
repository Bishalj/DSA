package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CanYouSolveIt {

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());
        for(int i=0 ;i<numberOfTestCases; i++){
            br.readLine();
            int arr[] = getIntegerArray(br.readLine());
            getTheMaximumDifference(arr);
        }

    }

    private static int[] getIntegerArray(String readLine) {
        String stringArray[] = readLine.split(" ");
        int array[] = new int[stringArray.length];
        int index = 0;
        for(String value: stringArray)
            array[index++] = Integer.parseInt(value);
        return array;
    }

    private static int getTheMaximumDifference(int[] arr) {
        int max = arr[0];int index = 0;
        for(int i=1 ;i<arr.length; i++){
            if(Math.abs(arr[i] - arr[0]) + i >= max) {
                max = Math.abs(arr[i] - arr[0]) + i;
                index = i;
            }
        }

        for(int i=1; i<=index; i++){
            if(Math.abs(arr[i] - arr[index]) + i > max )
                max = Math.abs(arr[i] - arr[index]) + i;
        }
        return max;
    }
}
