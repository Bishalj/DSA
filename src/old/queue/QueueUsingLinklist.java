package old.queue;

import old.linklist.LinkList;
import old.linklist.Node;

public class QueueUsingLinklist {

    LinkList linkedList;
    Node front;
    int rear;

    QueueUsingLinklist(){
        linkedList = new LinkList();
    }

    public void enqueue(int data){
        linkedList.insertEnd(data);
        rear = data;
        if(front == null)
            front = linkedList.getHead();
    }

    public void dequeue(){
        if(linkedList.isEmpty())
            System.out.println("Queue is empty");
        else {
            System.out.println("Data removed: " + front.data);
            front = front.next;
            linkedList.setHead(front);
        }
    }

    public void display(){
        linkedList.display();
    }

    public void reverse(){
        Node node = linkedList.getHead();
        Node previousNode = null;
        Node nextNode = null;
        while(node != null && node.next != null){
            nextNode = node.next;
            node.next = previousNode;
            previousNode = node;
            node = nextNode;
        }

        if(node != null)
            nextNode.next = previousNode;
        linkedList.setHead(nextNode);
    }

}
