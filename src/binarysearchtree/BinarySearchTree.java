package binarysearchtree;


import java.util.*;

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
        int MAX_VALUE = Integer.MAX_VALUE;
        int MIN_VALUE = Integer.MIN_VALUE;
       return isATreeBST(node, MAX_VALUE, MIN_VALUE);
    }

    private boolean isATreeBST(Node node, int maxValue, int minValue) {
        if(node == null)
            return true;

        if(node.data < minValue || node.data > maxValue)
            return false;

        return  isATreeBST(node.left, node.data, minValue) &&
                isATreeBST(node.right, maxValue, node.data);
    }

    boolean search(int data){
        Node node = root;
        while (node != null){
            if(node.data == data)
                return true;
            else if(node.data < data)
                node = node.right;
            else
                node = node.left;
        }
        return false;
    }

    public Node getRoot() {
        return root;
    }

    public Integer gerFloorElement(int searchValue){
        Node node = root;
        Integer floorElementValue = null;
        while (node != null){
            if(node.data == searchValue)
                return searchValue;
            else if(node.data > searchValue)
                node = node.left;
            else {
                if(floorElementValue == null)
                    floorElementValue = node.data;
                else if(node.data > floorElementValue)
                    floorElementValue = node.data;
                node = node.right;
            }
        }
        return floorElementValue;
    }


    public Integer getCeilElement(int searchValue){
        Node node = root;
        Integer ceilElementValue = null;
        while (node != null){
            if(node.data == searchValue)
                return searchValue;
            else if(node.data < searchValue)
                node = node.right;
            else {
                ceilElementValue = node.data;
                node = node.left;
            }
        }
        return ceilElementValue;
    }

    public void swapTwoNodesToMakeItBST(){
        //dummy solution
        ArrayList<Node> arrayList = new ArrayList<>();
        swapTwoNodesToMakeItBST(root, arrayList);
        System.out.println(arrayList.toString());
        int positionOne, positionTwo;
        positionOne = positionTwo = -1;
        int previous = Integer.MIN_VALUE;
        for(int i=0; i<arrayList.size()-1; i++){
            if(arrayList.get(i).data < previous) {
                if(positionOne == -1)
                    positionOne = previous;
                positionTwo = arrayList.get(i).data;
            }
            previous = arrayList.get(i).data;
        }
    }

    private void swapTwoNodesToMakeItBST(Node node, ArrayList<Node> arrayList) {
        if(node == null)
            return;

        swapTwoNodesToMakeItBST(node.left, arrayList);
        arrayList.add(node);
        swapTwoNodesToMakeItBST(node.right, arrayList);
    }

    public boolean isPairSumForAGivenSumExistInBST(int sum){
        return isPairSumForAGivenSumExistInBST(root, sum);
    }

    private boolean isPairSumForAGivenSumExistInBST(Node node, int sum) {
        if (node == null)
            return false;

        final Set<Integer> valueSet = new HashSet<>();
        return checkIsPairSumExists(node, valueSet, sum);
    }

    private boolean checkIsPairSumExists(Node node, Set<Integer> valueSet, int sum) {
        if(node == null)
            return false;

        int differenceValue = sum - node.data;
        if(valueSet.contains(differenceValue))
            return true;
        else
            valueSet.add(node.data);

        return checkIsPairSumExists(node.left, valueSet, sum) || checkIsPairSumExists(node.right, valueSet, sum);
    }

    public void printTheVerticalSumInABinaryTree(){
        final Map<Integer, Integer> verticalSum = new TreeMap<>();
        int key = 0;
        printTheVerticalSumInABinaryTree(root, verticalSum, key);
        System.out.println(verticalSum.toString());
    }

    private void printTheVerticalSumInABinaryTree(Node root, Map<Integer, Integer> verticalSum, int key) {
        if(root == null)
            return;

        if (verticalSum.get(key) == null)
            verticalSum.put(key, root.data);
        else
            verticalSum.put(key, verticalSum.get(key) + root.data);

        printTheVerticalSumInABinaryTree(root.left, verticalSum, key-1);
        printTheVerticalSumInABinaryTree(root.right, verticalSum, key+1);
    }

    public void printTheVerticalTraversalInABinaryTree(){
        final Map<Integer, List<Integer>> verticalSum = new TreeMap<>();
        int key = 0;
        printTheVerticalTraversalInABinaryTree(root, verticalSum, key);
        System.out.println(verticalSum.toString());
    }

    private void printTheVerticalTraversalInABinaryTree(Node root, Map<Integer, List<Integer>> verticalSum, int key) {
        if(root == null)
            return;

        if (verticalSum.get(key) == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            verticalSum.put(key, list);
        }
        else {
            List<Integer> list =  verticalSum.get(key);
            list.add(root.data);
        }

        printTheVerticalTraversalInABinaryTree(root.left, verticalSum, key-1);
        printTheVerticalTraversalInABinaryTree(root.right, verticalSum, key+1);
    }

    public void printTheTopViewInABinaryTree(){
        final Map<Integer, Integer> verticalSum = new TreeMap<>();
        int key = 0;
        printTheTopViewInABinaryTree(root, verticalSum, key);
        System.out.println(verticalSum.toString());
    }

    private void printTheTopViewInABinaryTree(Node root, Map<Integer, Integer> verticalSum, int key) {
        if(root == null)
            return;

        verticalSum.putIfAbsent(key, root.data);

        printTheTopViewInABinaryTree(root.left, verticalSum, key-1);
        printTheTopViewInABinaryTree(root.right, verticalSum, key+1);
    }


    public void printTheBottomViewInABinaryTree(){
        final Map<Integer, Integer> verticalSum = new TreeMap<>();
        int key = 0;
        printTheBottomViewInABinaryTree(root, verticalSum, key);
        System.out.println(verticalSum.toString());
    }

    private void printTheBottomViewInABinaryTree(Node root, Map<Integer, Integer> verticalSum, int key) {
//        if(root == null)
//            return;
//        Queue<Pair<Integer, Node>> nodeQueue = new LinkedList<>();
//        nodeQueue.add(new Pair<Integer, Node>(key, root));
//
//        while (!nodeQueue.isEmpty()) {
//            Pair<Integer, Node> pairNode = nodeQueue.poll();
//
//            if (NodeIsNotEmpty(pairNode)) {
//                verticalSum.put(pairNode.getKey(), pairNode.getValue().data);
//
//                addLeftNodeInTheQueue(nodeQueue, pairNode);
//
//                addRightNodeInTheQueue(nodeQueue, pairNode);
//            }
//        }
    }
//
//    private boolean NodeIsNotEmpty(Pair<Integer, Node> pairNode) {
//        return pairNode.getValue() != null;
//    }
//
//    private void addRightNodeInTheQueue(Queue<Pair<Integer, Node>> nodeQueue, Pair<Integer, Node> pairNode) {
//        if (pairNode.getValue().right != null) {
//            Pair<Integer, Node> rightPair = new Pair<>(pairNode.getKey() + 1, pairNode.getValue().right);
//            nodeQueue.add(rightPair);
//        }
//    }
//
//    private void addLeftNodeInTheQueue(Queue<Pair<Integer, Node>> nodeQueue, Pair<Integer, Node> pairNode) {
//        if (pairNode.getValue().left != null) {
//            Pair<Integer, Node> leftPair = new Pair<>(pairNode.getKey() - 1, pairNode.getValue().left);
//            nodeQueue.add(leftPair);
//        }
//    }
//

}

class Node{

    public int data;
    public Node left;
    public Node right;

    Node(int data){
        this.data = data;
    }
}