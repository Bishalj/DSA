package hashing;

import java.util.HashSet;
import java.util.Set;

public class DistictElementsInAnArray {

    public static void main(String[] args) {
        int arr[] = {1,2,4,4,4,5,2,1};
        System.out.println(getCountOfDistinctElementsInAnArray(arr));
    }

    private static int getCountOfDistinctElementsInAnArray(int[] arr) {
        Set set = new HashSet<Integer>(arr.length);
        for (int value: arr)
            set.add(value);
        return set.size();
    }
}
