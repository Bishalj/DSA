package hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInEveryWindow {

    public static void main(String[] args) {
        int array [] = {10, 20, 30 ,40};
        int k = 3;
        printDistinctElementsCount(array, k);
    }

    private static void printDistinctElementsCount(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <k; i++) {
            if(map.get(array[i]) == null)
                map.put(array[i], 1);
            else
                map.put(array[i], map.get(array[i]) + 1);
        }
        System.out.print(map.size());
        for(int i=k; i<array.length; i++){
            if(map.get(array[i-k]) == 1)
                map.remove(array[i-k]);
            else
                map.put(array[i-k], map.get(array[i-k]) - 1);

            if(map.get(array[i]) == null)
                map.put(array[i], 1);
            else
                map.put(array[i], map.get(array[i]) + 1);

            System.out.print(" " + map.size());
        }
    }
}
