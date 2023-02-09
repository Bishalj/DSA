package old.Arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumLengthSubArray {

    public static void main(String[] args) {
        int arr[] = {3,4,7,2,1,6,2};
        System.out.println(Solution(7 ,5, arr));
    }

    static int Solution(int N, int K, int[] arr){
        // Write your code here
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        int modSumArray[] = new int[N];
        int minCount = N+1;
        int sum = 0;
        for(int i = 0; i<N; i++){
            sum = (sum + arr[i])%K;
            modSumArray[i] = sum;
        }

        for(int i=0; i<N; i++){
            if(modSumArray[i] == 0){
                if(i+1 < minCount)
                    minCount = i+1;
            }else if(valueIndexMap.containsKey(modSumArray[i])){
                int indexDifference = i - valueIndexMap.get(modSumArray[i]);
                if(indexDifference < minCount)
                    minCount = indexDifference;
            }
            valueIndexMap.put(modSumArray[i], i);

        }
        if(minCount == N+1)
            return -1;
        return minCount;
    }
}
