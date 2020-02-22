package queue;

public class CircularQueue {
    private int capacity;
    private int[] values;
    private int rear;
    private int front;

    CircularQueue(int size){
        this.capacity = size;
        values = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int data){

        if(     (rear == values.length - 1 && front == 0) ||
                (rear + 1 == front)
        ) {
            System.out.println("Queue is full");
            return;
        }

        if(front == -1)
            front = 0;

        if(rear == values.length -1)
            rear = -1;

        values[++rear] = data;
    }

    public void dequeue(){
        if(front == rear) {
            front = rear = -1;
        }

        if(isQueueEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("The Element to be removed: " + values[front]);

        if(front == values.length - 1)
            front = -1;
        front++;
    }

    public boolean empty(){
        return isQueueEmpty();
    }

    private boolean isQueueEmpty() {
        return  rear == -1;
    }

    public void displayQueue(){
        if(front == -1)
            return;
        if(rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(values[i] + " ");
            }
        }
        if(rear < front){
            for (int i = front; i <values.length ; i++) {
                System.out.print(values[i] + " ");
            }
            for (int i = 0; i <=rear; i++) {
                System.out.print(values[i] + " ");
            }
        }
        System.out.println();
    }
}
