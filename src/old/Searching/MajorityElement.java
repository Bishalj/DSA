package old.Searching;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int array [] = {3 ,1 ,3 ,3 ,2};
        System.out.println(majorityElement(array, array.length));
    }

    static int majorityElement(int a[], int size)
    {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < size; i++) {
            if(frequencyMap.get(a[i]) == null)
                frequencyMap.put(a[i], 1);
            else if (frequencyMap.get(a[i]) == size/2)
                return a[i];
            else
                frequencyMap.put(a[i], frequencyMap.get(a[i]) + 1);
        }
        return -1;
    }
}
