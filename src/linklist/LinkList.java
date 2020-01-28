package linklist;

public class LinkList {
    private Node head;

    void insertEnd(int data){
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

    void insertBegin(int data){
        Node tempNode = new Node(data);
        tempNode.next = head;
        head =tempNode;
    }

    void insertAtIndex(int data, int index){
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

    void display(){
        Node node = head;
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
