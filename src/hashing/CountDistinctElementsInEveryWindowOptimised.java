package hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInEveryWindowOptimised {

    public static void main(String[] args) {
        int array [] = {10, 20, 30 ,40};
        int k = 3;
        printDistinctElementsCount(array, k);
    }

    private static void printDistinctElementsCount(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <k; i++)
            addValuesAndFrequencyInMap(map, array[i]);

        System.out.print(map.size());
        for(int i=k; i<array.length; i++){
            decrementFrequencyValueFromMap(array[i - k], map);
            addValuesAndFrequencyInMap(map, array[i]);
            System.out.print(" " + map.size());
        }
    }

    private static void decrementFrequencyValueFromMap(int key, Map<Integer, Integer> map) {
        if(map.get(key) == 1)
            map.remove(key);
        else
            map.put(key, map.get(key) - 1);
    }

    private static void addValuesAndFrequencyInMap(Map<Integer, Integer> map, int key) {
        if (map.get(key) == null)
            map.put(key, 1);
        else
            map.put(key, map.get(key) + 1);
    }

}
