package old.queue;

public class CircularQueueOperations {

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(1);
        circularQueue.displayQueue();
        circularQueue.enqueue(2);
        circularQueue.displayQueue();
        circularQueue.enqueue(3);
        circularQueue.displayQueue();
        circularQueue.enqueue(4);
        circularQueue.displayQueue();
        circularQueue.enqueue(5);
        circularQueue.displayQueue();
        circularQueue.enqueue(6);
        circularQueue.displayQueue();


        circularQueue.dequeue();
        circularQueue.displayQueue();


        circularQueue.dequeue();
        circularQueue.displayQueue();


        circularQueue.enqueue(7);
        circularQueue.displayQueue();


        circularQueue.dequeue();
        circularQueue.displayQueue();

        circularQueue.dequeue();
        circularQueue.displayQueue();

        circularQueue.dequeue();
        circularQueue.displayQueue();

        circularQueue.dequeue();
        circularQueue.displayQueue();


        circularQueue.enqueue(1);
        circularQueue.displayQueue();
        circularQueue.enqueue(2);
        circularQueue.displayQueue();
        circularQueue.enqueue(3);
        circularQueue.displayQueue();
        circularQueue.enqueue(4);
        circularQueue.displayQueue();
        circularQueue.enqueue(5);
        circularQueue.displayQueue();
        circularQueue.enqueue(6);
        circularQueue.displayQueue();



        circularQueue.dequeue();
        circularQueue.displayQueue();

        circularQueue.dequeue();
        circularQueue.displayQueue();

        circularQueue.dequeue();
        circularQueue.displayQueue();

        circularQueue.dequeue();
        circularQueue.displayQueue();


        circularQueue.enqueue(4);
        circularQueue.displayQueue();
        circularQueue.enqueue(5);
        circularQueue.displayQueue();
        circularQueue.enqueue(6);
        circularQueue.displayQueue();
    }
}
