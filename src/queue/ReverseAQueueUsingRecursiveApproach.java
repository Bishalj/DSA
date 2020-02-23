package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseAQueueUsingRecursiveApproach {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        reverse(queue);
        display(queue);
    }

    private static void reverse(Queue<Integer> queue) {
        if(queue.isEmpty())
            return;

        final int top = queue.remove();
        reverse(queue);
        queue.add(top);
    }

    private static void display(Queue<Integer> queue) {
        while (!queue.isEmpty())
            System.out.println(queue.remove());
    }
}
