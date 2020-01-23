package hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int arr []= {5, 10, 9,20,1,50,3,2,11,8,7,12,4, 6};
        System.out.println(getTheLongestConsecutiveSubsequenceLength(arr, arr.length));

    }

    private static int getTheLongestConsecutiveSubsequenceLength(int[] arr, int n) {
        Set<Integer> arrayValuesSet = new HashSet<>();
        insertArrayValuesInMap(arr, arrayValuesSet);

        int maxLength =0, tempLength = 0;
        for (int i = 0; i < n; i++) {
            if(arrayValuesSet.contains(arr[i] - 1))
                continue;
            tempLength = 1;
            int tmpValue = arr[i] + 1;

            while(arrayValuesSet.contains(tmpValue)){
                tempLength++;
                arrayValuesSet.add(tmpValue++);
            }
            if(tempLength > maxLength)
                maxLength = tempLength;
        }
        return maxLength;
    }

    private static void insertArrayValuesInMap(int[] arr,final Set<Integer> arrayValuesSet) {
        for (int values :
                arr) {
            arrayValuesSet.add(values);
        }
    }
}
