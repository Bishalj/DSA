package old.tree;

import java.util.ArrayList;

public class Node {
    public int data;
    public Node left;
    public Node right;

    Node(int data){
        this.data = data;
    }
}

class Operations{
    Node head;
    public void insertNode(int data){
        Node newNode = new Node(data);
        Node node = head;
        if(head == null)
            head = new Node(data);
        else{
            while(node != null){
                if(node.data > data){
                    if(node.left == null) {
                        node.left = newNode;
                        return;
                    }
                    node = node.left;
                }else{
                    if(node.right == null) {
                        node.right = newNode;
                        return;
                    }
                    node = node.right;
                }
            }
        }
    }

    public int getHeight(){
        Node node = head;
        return getTheHeigth(node);
    }

    private int getTheHeigth(Node node) {
        if(node == null)
            return 0;

        int left = 1+ getTheHeigth(node.left);
        int right = 1+ getTheHeigth(node.right);
        return Math.max(left,right);
    }

    private void deserialize(int arr[]){
        Node node =null;
        getDeserialize(arr);
    }
    int position = 0;
    private Node getDeserialize(int[] arr) {

        if(position == arr.length)
            return null;
        position++;
        int data = arr[position];
        if(data == -1)
            return null;

        Node root = new Node(data);
        root.left = getDeserialize(arr);
        root.right = getDeserialize(arr);
        return root;

    }
    ArrayList<Integer> arrayList = new ArrayList<>();
    private ArrayList<Integer> serialize(Node node) {

        if(node == null)
            arrayList.add(-1);
        else{
            arrayList.add(node.data);
        }

        serialize(node.left);
        serialize(node.right);
        return arrayList;
    }

    public static void main(String[] args) {
        Node node = new Node(10);

    }
}

