package queue;

public class QueueOperations {

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.displayQueue();
        System.out.println(queue.empty());
        queue.enqueue(5);
        System.out.println(queue.empty());
        queue.displayQueue();
        queue.enqueue(55);
        queue.displayQueue();
        queue.enqueue(555);
        queue.displayQueue();
        queue.enqueue(5555);
        queue.displayQueue();
        queue.enqueue(55555);
        queue.displayQueue();
        queue.enqueue(555555);
        queue.displayQueue();
        queue.dequeue();
        queue.displayQueue();
        queue.enqueue(4);
        queue.displayQueue();
        queue.enqueue(3);
        queue.displayQueue();
        queue.dequeue();
        queue.displayQueue();
        queue.enqueue(2);
        queue.displayQueue();
        queue.enqueue(1);
        queue.displayQueue();

        queue.dequeue();
        queue.displayQueue();
        queue.dequeue();
        queue.displayQueue();
        queue.dequeue();
        queue.displayQueue();
        queue.dequeue();
        queue.displayQueue();
    }
}
