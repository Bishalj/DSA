package old.linklist;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDesign {

    public static final int MAX_CACHE_SIZE = 4;
    public static void insertInCache(LinkList linkList, int data){

        Node node = linkList.getHead();
        int count = 1;

        //for first node
        if(node == null) {
            node = new Node(data);
            linkList.setHead(node);
            return;
        }

        //if the fisrt data is same then there is not need the do any operation
        if(node.data == data)
            return;

        //checking with next node makes easier to delete a node
        while (node.next != null){
            count++;
            if(node.next.data == data) {
                node.next = node.next.next;
                break;
            }
            if(count == MAX_CACHE_SIZE) {
                node.next = null;
                break;
            }
            node = node.next;
        }

        Node newNode = new Node(data);
        Node head = linkList.getHead();
        newNode.next = head;
        linkList.setHead(newNode);
    }

    public  static  Map<Integer, Node> dataNodeMap = new HashMap<>();
    static Node startNode = null;
    static Node endNode = null;
    static int count = 0;
    public static void optimisedInsertInCache(LinkList linkList, int data){

        if(dataNodeMap.get(data) == null || count <= MAX_CACHE_SIZE){
            Node newNode = new Node(data);
            newNode.next = linkList.getHead();
            linkList.setHead(newNode);
            dataNodeMap.put(data, newNode.next);
        }else {

        }

    }
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        insertInCache(linkList, 10);
        linkList.display();
        insertInCache(linkList, 20);
        linkList.display();
        insertInCache(linkList, 10);
        linkList.display();
        insertInCache(linkList, 30);
        linkList.display();
        insertInCache(linkList, 40);
        linkList.display();
        insertInCache(linkList, 50);
        linkList.display();
        insertInCache(linkList, 30);
        linkList.display();
        insertInCache(linkList, 40);
        linkList.display();
        insertInCache(linkList, 60);
        linkList.display();
        insertInCache(linkList, 30);
        linkList.display();
    }
}
