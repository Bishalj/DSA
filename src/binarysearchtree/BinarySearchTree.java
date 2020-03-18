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

    void preOrderTraversal(){
        Node node = root;
        preOrderTraversal(node);
        System.out.println();
    }

    private void preOrderTraversal(Node node) {
        if(node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    boolean isElementPresent(int data){
       Node node = root;
       while (node != null){
           if(node.data == data)
               return true;
           else if(data > node.data)
               node = node.right;
           else
               node = node.left;
       }
       return false;
    }

    boolean isATreeBST(){
        Node node = root;
       return isATreeBST(node);
    }

    private boolean isATreeBST(Node node) {
        if(node == null)
            return true;

        if(node.left != null && node.data < node.left.data)
            return false;
        if(node.right != null && node.data > node.right.data)
            return false;

        return isATreeBST(node.left) && isATreeBST(node.right);
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