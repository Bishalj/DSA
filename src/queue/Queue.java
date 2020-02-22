package queue;

public class Queue {

    private int capacity;
    private int[] values;
    private int rear;
    private int front;

    Queue(int size){
        this.capacity = size;
        values = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int data){
        if(front == -1)
            front = 0;

        if(rear == values.length - 1) {
            System.out.println("Queue is full");
            return;
        }

        values[++rear] = data;
    }

    public void dequeue(){
        if(isQueueEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("The Element to be removed: " + values[front]);
        front++;
    }

    public boolean empty(){
        return isQueueEmpty();
    }

    private boolean isQueueEmpty() {
        return front > rear || rear == -1;
    }

    public void displayQueue(){
        if(front == -1)
            return;
        for (int i=front; i<=rear; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}
