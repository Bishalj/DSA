package old.queue;

public class QueueLinklistOperation {

    public static void main(String[] args) {
        QueueUsingLinklist queueUsingLinklist = new QueueUsingLinklist();

        queueUsingLinklist.enqueue(1);
        queueUsingLinklist.display();
        queueUsingLinklist.enqueue(2);
        queueUsingLinklist.display();
        queueUsingLinklist.enqueue(3);
        queueUsingLinklist.display();
        queueUsingLinklist.enqueue(4);
        queueUsingLinklist.display();

        queueUsingLinklist.reverse();
        queueUsingLinklist.display();

        queueUsingLinklist.reverse();
        queueUsingLinklist.display();


        queueUsingLinklist.enqueue(5);
        queueUsingLinklist.display();

        queueUsingLinklist.reverse();
        queueUsingLinklist.display();

        queueUsingLinklist.enqueue(6);
        queueUsingLinklist.display();


        queueUsingLinklist.reverse();
        queueUsingLinklist.display();


        queueUsingLinklist.dequeue();
        queueUsingLinklist.display();
        queueUsingLinklist.dequeue();
        queueUsingLinklist.display();


        queueUsingLinklist.reverse();
        queueUsingLinklist.display();


        queueUsingLinklist.dequeue();
        queueUsingLinklist.display();
        queueUsingLinklist.dequeue();
        queueUsingLinklist.display();
        queueUsingLinklist.dequeue();
        queueUsingLinklist.display();
        queueUsingLinklist.dequeue();
        queueUsingLinklist.display();
    }
}
