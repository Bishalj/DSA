package linklist;

import java.util.HashSet;
import java.util.Set;

public class LinkList {
    private Node head;

    public void setHead(Node head) {
        this.head = head;
    }

    public void insertEnd(int data){
        Node tempNode = new Node(data);
        if(head == null)
            head = tempNode;
        else {
            Node node = head;
            while (node.next != null)
                node = node.next;
            node.next = tempNode;
        }
    }

    public  void insertEnd(Node tempNode){
        if(head == null)
            head = tempNode;
        else {
            Node node = head;
            while (node.next != null)
                node = node.next;
            node.next = tempNode;
        }
    }

    public void insertBegin(int data){
        Node tempNode = new Node(data);
        tempNode.next = head;
        head =tempNode;
    }

    public void insertAtIndex(int data, int index){
        if(head == null || index <= 1){
            insertBegin(data);
            return;
        }
        Node tempNode = new Node(data);
        Node node = head;
        int i = 1;
        while (i++ < index-1 && node.next != null)
            node = node.next;

        Node nextNode = node.next;
        tempNode.next = nextNode;
        node.next = tempNode;
    }

    public void deleteValue(int data){
        Node node = head;
        if(node != null && node.data == data)
            head = head.next;
        else{
            Node previousNode = null;
            while(node != null && node.data != data){
                previousNode = node;
                node = node.next;
            }
            if(node != null)
                previousNode.next = node.next;
        }
    }

    public void deleteLastElement(){
        Node node = head;
        Node previous= null;
        if(node == null || node.next == null)
            head = null;
        else {
            while (node.next != null){
                previous = node;
                node = node.next;
            }
            previous.next = null;
        }
    }

    public void display(){
        Node node = head;
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public int getTheMiddleElementInALinklistNaive(){
        Node node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        count = count/2;
        node = head;
        while(count-- != 0)
            node = node.next;
        return node == null ? -9999999 : node.data;
    }

    public int getTheMiddleElementInALinklist(){
        Node node = head;
        int count = 0;
        Node middleNode = head;
        while (node != null) {
            node = node.next;
            count++;
            if(count%2 == 0)
                middleNode = middleNode.next;
        }
        return middleNode == null ? -100 : middleNode.data;
    }

    public int getNthNodeOfTheLinkList(int n){
        Node node = head;
        int count = 1;
        Node resultNode = null;
        while(node != null){
            if(count - n >= 0){
                if(resultNode == null)
                    resultNode = head;
                else
                    resultNode = resultNode.next;
            }
            node = node.next;
            count++;
        }
        return resultNode == null ? Integer.MIN_VALUE : resultNode.data;
    }

    public void reverseTheLinkList(){
        Node node = head;
        Node previousNode = null;
        Node tempNode = null;
        while (node != null ){
            tempNode = previousNode;
            previousNode = node;
            node = node.next;
            previousNode.next = tempNode;
        }
        head = previousNode;
    }

    public boolean isPalindrome(){
        Node node = head;
        Node previousNode = null;
        Node tempNode = null;
        Node nodeToCountElements = head;
        int count = 0;
        while (nodeToCountElements != null){
            count++;
            nodeToCountElements = nodeToCountElements.next;
        }
        int mid = count/2;
        int numberOfTraversal = 0;
        while (node != null && numberOfTraversal < mid){
            numberOfTraversal++;
            tempNode = previousNode;
            previousNode = node;
            node = node.next;
            previousNode.next = tempNode;
        }
        Node startNode = previousNode;
        if(count%2 != 0)
            node = node.next;

        while (startNode != null){
            if(startNode.data != node.data)
                return false;

            startNode = startNode.next;
            node = node.next;
        }
            return true;
    }

    public void reverseTheLinkListRecursive(){
        Node previousNode = null;
        Node currentNode = head;
        head = reverseTheLlist(previousNode, currentNode);
        display();
    }

    private Node reverseTheLlist(Node previousNode, Node currentNode) {
        if(currentNode == null)
            return previousNode;
        Node tempNode = currentNode;
        currentNode = currentNode.next;
        tempNode.next = previousNode;

        return reverseTheLlist(tempNode, currentNode);
    }

    public  Node condense(Node head) {
        // Write your code here
        Set<Integer> values = new HashSet<>();
        Node node = head;
        Node previous = head;
        node = node.next;
        while(node != null){
            if(values.contains(node.data)){
                previous.next = node.next;
            }else{
                values.add(node.data);
                previous = node;
            }
            node = node.next;
        }
        return head;
    }

    public Node getHead(){
        return head;
    }

    public boolean isEmpty(){
        return head == null;
    }

//    void reverseTheLinkLis1t(){
//        Nodes nextNode = head;
//        Nodes previousNode = null;
//        Nodes currentNode = head;
//        while (nextNode != null){
//            previousNode = currentNode;
//            nextNode = nextNode.next;
//            currentNode.next = previousNode;
//        }
//        head = currentNode;
//    }
}
