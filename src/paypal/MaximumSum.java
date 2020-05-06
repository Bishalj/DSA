package paypal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaximumSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String details[] = br.readLine().split(" ");
            int size = Integer.parseInt(details[0]);
            int numberOfQueries = Integer.parseInt(details[1]);
            String arrayInString[] = br.readLine().split(" ");
            int originalArray[] = Arrays.stream(arrayInString).mapToInt(Integer::parseInt).toArray();
            int indexFrequency[] = new int[size];
            for (int j = 0; j < numberOfQueries; j++) {
                String query[] = br.readLine().split(" ");
                incrementTheIndexFrequency(indexFrequency, query);
            }
            int actualSum = getSum(originalArray, indexFrequency, true);
            int maxSum = getTheMaximumSum(originalArray, indexFrequency);
            System.out.println(maxSum - actualSum);
        }

    }

    private static int getTheMaximumSum(int[] originalArray, int[] indexFrequency) {
        Arrays.sort(indexFrequency);
        Arrays.sort(originalArray);
        return getSum(originalArray, indexFrequency, false);
    }

    private static int getSum(int[] originalArray, int[] indexFrequency, boolean isActualSum) {
        int maxSum = 0;
        for(int index=originalArray.length-1; index >= 0; index--){
            if(isActualSum == false && indexFrequency[index] == 0)
                break;
            maxSum += originalArray[index]*indexFrequency[index];
        }
        return maxSum;
    }

    private static void incrementTheIndexFrequency(int[] indexFrequency, String query[]) {
        int startIndex = Integer.parseInt(query[0]);
        int endIndex = Integer.parseInt(query[1]);
        for (int k = startIndex-1; k <= endIndex-1; k++) {
            indexFrequency[k] = indexFrequency[k] + 1;
        }
    }
}
