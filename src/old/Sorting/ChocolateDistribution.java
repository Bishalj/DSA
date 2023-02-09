package old.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChocolateDistribution {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            int array[] = convertToIntegerArray(br.readLine().split(" "));
            final int numberOfChildren = Integer.parseInt(br.readLine());
            Arrays.sort(array);
            int lowerBound = 0;
            int upperBound = array.length - 1 ;
            int minimumValue = array[numberOfChildren - 1] - array[lowerBound];
            for (int j = lowerBound; j <= upperBound - numberOfChildren; j++) {
                if(array[j+numberOfChildren-1] - array[j] < minimumValue)
                    minimumValue = array[j+numberOfChildren-1] - array[j] ;
            }
            System.out.println(minimumValue);
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

