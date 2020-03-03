package tree;

import linklist.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Nodes {
    public Nodes left;
    public Nodes right;
    public int data;

    Nodes(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTreeOperations{
    private Nodes root;

    public void setRoot(Nodes root) {
        this.root = root;
    }

    public void insert(int data){
        Nodes tempNode = new Nodes(data);

        if(root == null){
            root = tempNode;
            return;
        }
        Nodes currentNode = root;
        while (currentNode != null) {
            if (currentNode.data > data) {
                if(currentNode.left == null) {
                    currentNode.left = tempNode;
                    break;
                }
                currentNode = currentNode.left;

            } else if(currentNode.data < data) {
                if(currentNode.right == null) {
                    currentNode.right = tempNode;
                    break;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public void inOrderTraversal(){
        Nodes nodes = root;
        System.out.println("-----------------In Order Traversal-----------------");
        inOrderTraversal(nodes);
    }

    public void preOrderTraversal(){
        Nodes nodes = root;
        System.out.println("-----------------Pre Order Traversal-----------------");
        preOrderTraversal(nodes);
    }


    public void postOrderTraversal(){
        Nodes nodes = root;
        System.out.println("-----------------Post Order Traversal-----------------");
        postOrderTraversal(nodes);
    }


    public void preOrderTraversal(Nodes nodes){
        if(nodes == null)
            return;
        System.out.print(nodes.data + " ");
        preOrderTraversal(nodes.left);
        preOrderTraversal(nodes.right);
    }

    public void inOrderTraversal(Nodes nodes){
        if(nodes == null)
            return;

        inOrderTraversal(nodes.left);
        System.out.print(nodes.data + " ");
        inOrderTraversal(nodes.right);

    }

    public void postOrderTraversal(Nodes nodes){
        if(nodes == null)
            return;

        postOrderTraversal(nodes.left);
        postOrderTraversal(nodes.right);
        System.out.print(nodes.data + " ");
    }

    public void levelOrderTraversal(){
        Nodes nodes = root;
        System.out.println("-----------------Level Order Traversal-----------------");
        List<Nodes> nodesList = new ArrayList<>();
        nodesList.add(nodes);
        levelOrderTraversal(nodesList);
    }

    private void levelOrderTraversal(List<Nodes> nodesList) {
        if(nodesList.isEmpty() || nodesList.size() == 0)
            return;
        Nodes currentNode= nodesList.get(0);
        if(currentNode != null) {
            System.out.print(currentNode.data + " ");
            nodesList.add(currentNode.left);
            nodesList.add(currentNode.right);
        }

        nodesList.remove(0);
        levelOrderTraversal(nodesList);
    }

    public void levelOrderTraversalUsingQueue(){
        System.out.println("-----------------Level Order Traversal using Queue-----------------");
        if(root == null)
            return;
        Queue<Nodes> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        while (nodesQueue.isEmpty() == false) {
            Nodes nodes = nodesQueue.poll();
            System.out.print(nodes.data + " ");
            if (nodes.left != null)
                nodesQueue.add(nodes.left);
            if (nodes.right != null)
                nodesQueue.add(nodes.right);
        }
        System.out.println();
    }

    public void levelOrderTraversalUsingQueueLineWise(){
        System.out.println("-----------------Level Order Traversal using Queue-----------------");
        if(root == null)
            return;
        Queue<Nodes> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        int size = nodesQueue.size();
        while (nodesQueue.isEmpty() == false) {

            Nodes nodes = nodesQueue.poll();
            System.out.print(nodes.data + " ");
            if (nodes.left != null)
                nodesQueue.add(nodes.left);
            if (nodes.right != null)
                nodesQueue.add(nodes.right);
            size--;
            if(size == 0){
                System.out.println();
                size = nodesQueue.size();
            }
        }
        System.out.println();
    }
    public int sizeOfABinaryTree(){
        Nodes nodes = root;
        return sizeOfABinaryTree(nodes);
    }

    public int sizeOfABinaryTree(Nodes nodes){
        if(nodes == null)
            return 0;

        return 1 + sizeOfABinaryTree(nodes.left) + sizeOfABinaryTree(nodes.right);
    }

    public int sizeOfABinaryTreeTailRecursive(){
        Nodes nodes = root;
        return sizeOfABinaryTreeTailRecursive(nodes, new int[1]);
    }

    public int sizeOfABinaryTreeTailRecursive(Nodes nodes, int[] count){
        if(nodes == null)
            return count[0];

        count[0] = count[0] + 1;
        sizeOfABinaryTreeTailRecursive(nodes.left,count );
        sizeOfABinaryTreeTailRecursive(nodes.right, count);
        return count[0];
    }

    public int getTheMaximumValueInABinaryTree(){
        Nodes nodes = root;
        if(nodes == null)
            return -1;
        return getTheMaximumValueInABinaryTree(nodes, nodes.data);
    }

    private int getTheMaximumValueInABinaryTree(Nodes nodes, int max){
        if(nodes == null)
           return max;
        else if(nodes.data > max)
            max = nodes.data;

        int leftTempValue = getTheMaximumValueInABinaryTree(nodes.left, max);
        if (leftTempValue > max)
            max = leftTempValue;
        int rightTempValue = getTheMaximumValueInABinaryTree(nodes.right, max);
        if (rightTempValue > max)
            max = rightTempValue;
        return max;
    }

    public int getTheHeightOfABinaryTree(){
        Nodes nodes = root;
        return getTheHeightOfABinaryTree(nodes);
    }


    private int getTheHeightOfABinaryTree(Nodes nodes){
        if(nodes == null)
            return 0;

        int leftHeightValue = 1 + getTheHeightOfABinaryTree(nodes.left);
        int rightTempValue = 1 + getTheHeightOfABinaryTree(nodes.right);
        if (rightTempValue > leftHeightValue)
            return rightTempValue;
        return leftHeightValue;
    }
    public void printTheKthElement(int k){
        Nodes nodes = root;
        printTheKthElement(nodes, k);
    }

    private void printTheKthElement(Nodes nodes, int k){
        if(nodes == null)
            return;
        if(--k == 0){
            System.out.println(nodes.data);
            return;
        }
        printTheKthElement(nodes.left, k);
        printTheKthElement(nodes.right, k);
    }

    public void printTheLeftMostElement(){
        Nodes nodes = root;
        int level = 0;
        int maxLevel = -1;
        printTheLeftMostElement(nodes, level);
    }

    int maxLevel = -1;
    private void printTheLeftMostElement(Nodes nodes, int level){
        if(nodes == null)
            return;

        if(level > maxLevel) {
            maxLevel = level;
            System.out.println(nodes.data + " ");
        }
        if(nodes.left != null)
            printTheLeftMostElement(nodes.left, level + 1);


        if(nodes.right != null)
            printTheLeftMostElement(nodes.right, level + 1);
    }

    public boolean isChildrenSumProperty(){
        Nodes nodes = root;
        return isChildrenSumProperty(nodes);
    }

    private boolean isChildrenSumProperty(Nodes nodes) {
        if(nodes == null)
            return true;

        if(nodes.left == null && nodes.right == null)
            return true;

        int sum = 0;
        if(nodes.left != null)
            sum += nodes.left.data;

        if(nodes.right != null)
            sum += nodes.right.data;

        return sum == nodes.data && isChildrenSumProperty(nodes.left) && isChildrenSumProperty(nodes.right);
    }

    public boolean treeIsABalancedTree() {
        Nodes nodes = root;
        return  treeIsABalancedTree(nodes) == -1 ? false : true;
    }

    public int treeIsABalancedTree(Nodes nodes) {
        if(nodes == null)
            return 0;

        int left =  treeIsABalancedTree(nodes.left) ;
        if(left == -1)
            return -1;
        int right = treeIsABalancedTree(nodes.right);
        if(right == -1)
            return -1;


        return Math.abs(left-right) > 1 ? -1 : left > right ? left + 1: right+1;
    }

    private int heigthOfTheTree(Nodes temp) {
        if (temp == null)
            return 0;


        int left = heigthOfTheTree(temp.left);
        if(left==-1)
            return -1;
        int right = heigthOfTheTree(temp.right);
        if (right==-1)
            return -1;
        if(Math.abs(left-right) > 1)
            return -1;
        return left > right ? left+1: right+1;
    }

    public int maxWidthOfATree() {
        Nodes nodes = root;
        return  maxWidthOfATree(nodes);
    }

    private int maxWidthOfATree(Nodes nodes) {
        int maxWidth = 0;
        Queue<Nodes> nodesQueue = new LinkedList<>();
        nodesQueue.add(nodes);
        while (!nodesQueue.isEmpty()){
            int count = nodesQueue.size();
            if(count > maxWidth)
                maxWidth = count;
            for (int i = 0; i < count; i++) {
                Nodes tempNode = nodesQueue.poll();
                if(tempNode.left != null)
                    nodesQueue.add(tempNode.left);
                if(tempNode.right != null)
                    nodesQueue.add(tempNode.right);
            }

        }
        return maxWidth;
    }


    public Nodes createDoublyLinkList() {
        Nodes nodes = root;
        return createDoublyLinkList(nodes);
    }

    private Nodes createDoublyLinkList(Nodes nodes) {
        if(nodes == null)
            return null;

        Nodes leftNode = null;
        Nodes rightNode = null;
        if(nodes.left != null)
            leftNode = createDoublyLinkList(nodes.left);
        if(nodes.right != null)
            rightNode = createDoublyLinkList(nodes.right);

        if(leftNode != null) {
            Nodes tmp = leftNode;
            while (tmp.right != null)
                tmp = tmp.right;
            tmp.right = nodes;
            nodes.left = tmp;
        }

        if(rightNode != null) {
            nodes.right = rightNode;
            rightNode.left = nodes;
        }
        if(leftNode != null)
            return leftNode;

        return nodes;
    }

    public void displayDoublyLinklist(Nodes nodes){
        while (nodes != null){
            System.out.print(nodes.data + " ");
            nodes = nodes.right;
        }
    }

    public Nodes createTree(int[] inOrder, int[] preOrder) {
        Nodes head = null;
        for (int i = 0; i < preOrder.length; i++) {
            if(head == null)
                head = new Nodes(preOrder[i]);
            else{
                Nodes currentNode = head;
                while (currentNode != null){
                    if(isNodesIsInLeft(preOrder[i], currentNode.data, inOrder)){
                        if(currentNode.left == null) {
                            currentNode.left = new Nodes(preOrder[i]);
                            break;
                        }else {
                            currentNode = currentNode.left;
                        }
                    }else {
                        if(currentNode.right == null) {
                            currentNode.right = new Nodes(preOrder[i]);
                            break;
                        }else {
                            currentNode = currentNode.right;
                        }
                    }
                }
            }

        }
        return head;
    }

    private boolean isNodesIsInLeft(int currentData, int parentData, int[] inOrder) {
        for(int i = 0; i< inOrder.length; i++){
            if(currentData == inOrder[i])
                return true;
            if(parentData == inOrder[i])
                return false;
        }
        return false;
    }
}


