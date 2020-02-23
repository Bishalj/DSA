package queue;

import linklist.Node;

public class Dequeue {

    private Node front;
    private Node rear;
    private Node secondLastNode;

    Dequeue(){
        front = null;
        rear = null;
        secondLastNode = null;
    }

    public void addFront(int data){
        Node node = new Node(data);
        node.next = front;
        front = node;
        if(rear == null)
            rear = node;
    }

    public void removeFront(){
        if(front == null){
            System.out.println("Queue is empty");
            return;
        }
        front = front.next;
        if(front == null)
            rear= null;
    }

    public void addEnd(int data){
        Node node = new Node(data);
//        Node head = front;
        if(front == null) {
            front = node;
            rear = node;
        }
        else {
            rear.next = node;
            rear = rear.next;
        }
    }

    public void removeEnd(){
        if(front == null){
            System.out.println("Queue is empty");
            return;
        }

        Node node = front;
        while (node != null && node.next != null){
            secondLastNode = node;
            node = node.next;
        }
        secondLastNode.next = null;
    }

    public void display(){
        Node node = front;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void displayMaximum(){
        Node node = front;
        int max = 0;
        while (node != null) {
            if(node.data > max)
                max = node.data;
            node = node.next;
        }
        System.out.print(max+ " ");
    }
}
