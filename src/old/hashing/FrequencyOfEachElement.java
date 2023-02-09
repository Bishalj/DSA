package old.hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfEachElement {

    public static void main(String[] args) {
            int arr[] = {1,5,11,1,1,5,5,3,3,3};
            printFrequencyOfEachElement(arr, arr.length);

    }

    static void printFrequencyOfEachElement(int a[], int size)
    {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < size; i++) {
            if(frequencyMap.get(a[i]) == null)
                frequencyMap.put(a[i], 1);
            else
                frequencyMap.put(a[i], frequencyMap.get(a[i]) + 1);
        }

        displayMap(frequencyMap);
    }

    private static void displayMap(Map<Integer, Integer> frequencyMap) {
        for (Map.Entry<Integer, Integer> map :  frequencyMap.entrySet()
             ) {
            System.out.println("Value: " + map.getKey() + " freq: "+map.getValue());
        }
    }
}
