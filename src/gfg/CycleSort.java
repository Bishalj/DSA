package gfg;

import access_specifiers.com.C;
import utils.CommonUsedUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

public class CycleSort {
    int count = 0;
    private void sort(int arr[]){
        int i=0;
        while(i < arr.length){
            int count = getSmallestCount(i, arr);
            if(count != i){
                swap(i, count, arr);
                this.count++;
            }
            else
                i++;
        }
    }

    private int getSmallestCount(int i, int[] arr) {
        int count = 0;
        for(int value: arr){
            if(value  < arr[i])
                count++;
        }
        return count;
    }

    private void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        CycleSort cycleSort = new CycleSort();
        int arr[] = {20, 30, 10, 34, 35};
        CommonUsedUtils.displayArray(arr);
        cycleSort.sort(arr);
        CommonUsedUtils.displayArray(arr);
    System.out.println(cycleSort.count);

    Map<Integer, Integer> map = new HashMap();
    map.put(1, 4);
    map.put(2, 2);
    map.put(3, 2);
    map.put(4, 5);

    List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
    list.sort((a,b) -> b.getValue() > a.getValue() ? 1 : -1);

        System.out.println(list);
        Map<Integer, Integer> map1 = list
            .stream()
            .collect(Collectors.toMap(a -> a.getKey(), a -> a.getValue() ));

        System.out.println(map1);
  }
}
