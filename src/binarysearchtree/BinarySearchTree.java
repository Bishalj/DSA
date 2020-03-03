package binarysearchtree;

public class BinarySearchTree {

    private Node root;

    public void insert(int data){

        if(root == null)
            root = new Node(data);
        else {
            Node node = root;
            while (node != null){
                if(node.data == data)
                    return;
                else if (node.data < data){
                    if(node.right == null){
                        node.right = new Node(data);
                        return;
                    }
                    node = node.right;
                }else {
                    if(node.left == null){
                        node.left = new Node(data);
                        return;
                    }
                    node = node.left;
                }
            }
        }
    }

}

class Node{

    public int data;
    public Node left;
    public Node right;

    Node(int data){
        this.data = data;
    }
}