package old.heap;
import java.util.*;

public class MergeKSortedArray {

    public static void main(String[] args) {
        int arr[][] = {
                {10,20,30},
                {5,15},
                {1,9,11,18}
        };

        System.out.println(getTheMergedArrayList(arr));
    }

    private static List<Integer> getTheMergedArrayList(int[][] arr) {
        List<Integer> arrayList = new ArrayList<>();
        Comparator<ArrayDetail> comparator = (x1,x2) -> x2.value < x1.value ? 1:-1;
        PriorityQueue<ArrayDetail> priorityQueue = new PriorityQueue<>(comparator);
        for(int i=0; i<arr.length; i++){
            priorityQueue.add(new ArrayDetail(arr[i][0], i, 0));
        }

        while(priorityQueue.isEmpty() == false){
            ArrayDetail arrayDetail = priorityQueue.poll();
            arrayList.add(arrayDetail.value);
            int arrayIndex = arrayDetail.arrayIndex+1;
            int arrayNumber = arrayDetail.arrayNumber;
            int array[] = arr[arrayNumber];
            if(arrayIndex < array.length)
                priorityQueue.add(new ArrayDetail(array[arrayIndex], arrayNumber, arrayIndex));
        }
        return arrayList;
    }
}

class ArrayDetail{
    public int value;
    public int arrayNumber;
    public int arrayIndex;

    public ArrayDetail(int value, int arrayNumber, int arrayIndex){
        this.value = value;
        this.arrayNumber = arrayNumber;
        this.arrayIndex = arrayIndex;
    }
}
