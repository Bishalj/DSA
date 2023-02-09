package old.graph;

import java.util.Collections;
import java.util.PriorityQueue;

public class EggDropping {
    public static void main(String[] args) {
        int floor = 9;
        int eggs = 3;
        int arr[][] = new int[floor][eggs];
        System.out.println(getTheMaxCount(floor, eggs));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(2, Collections.reverseOrder());
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        for (int i = 0; i < priorityQueue.size(); i++) {
            System.out.println(priorityQueue.poll());
        }

    }

    private static int getTheMaxCount(int floor, int eggs) {
        if(floor == 1 || floor == 0)
            return floor;
        if(eggs == 1)
            return floor;

        int res= Integer.MAX_VALUE;
        for(int x=1; x<=floor; x++){
            int max = Math.max(getTheMaxCount(x-1,eggs-1),getTheMaxCount(floor-x,eggs));
            if(res > max)
                res = max;
        }
        return res + 1;
    }
}
