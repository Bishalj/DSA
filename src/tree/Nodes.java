package tree;

import linklist.Node;

import java.util.*;
import java.util.function.Predicate;

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

    public void printSpiralTree(){
        Nodes nodes = root;
        printSpiralTree(nodes);
        System.out.println();
        System.out.println("########################");
    }

    private void printSpiralTree(Nodes nodes) {
        Queue<Nodes> nodesQueue = new LinkedList<>();
        nodesQueue.add(nodes);
        int levelCounter = 1;
        while (!nodesQueue.isEmpty()){
            int count = nodesQueue.size();
            levelCounter++;
            for(int i=0; i< count; i++){
                Nodes currentNode = nodesQueue.poll();
                System.out.print(currentNode.data + " ");
                if(levelCounter%2 != 0) {
                    if (currentNode.left != null)
                        nodesQueue.add(currentNode.left);
                    if (currentNode.right != null)
                        nodesQueue.add(currentNode.right);
                }else{
                    if (currentNode.right != null)
                        nodesQueue.add(currentNode.right);
                    if (currentNode.left != null)
                        nodesQueue.add(currentNode.left);
                }
            }
            System.out.println();
        }
    }

    public int getTheDiameterOfTheTree(){
        Nodes nodes = root;
        return getTheDiameterOfTheTree(nodes);
    }

    public int getTheDiameterOfTheTree(Nodes nodes) {
        if(nodes == null)
            return 0;

        int leftHeight =  getTheHeightOfTheTree(nodes.left);
        int rightHeight =  getTheHeightOfTheTree(nodes.right);

        int maxDiameter = leftHeight + rightHeight + 1;
        int leftDiameter = getTheDiameterOfTheTree(nodes.left);
        int rightDiameter = getTheDiameterOfTheTree(nodes.right);
        if(leftDiameter > maxDiameter)
            return leftDiameter;
        if(rightDiameter > maxDiameter)
            return rightDiameter;
        return maxDiameter;
    }

    public int getTheHeightOfTheTree(Nodes nodes) {
        if(nodes == null)
            return 0;

        int leftHeight = getTheHeightOfTheTree(nodes.left);
        int rightHeight = getTheHeightOfTheTree(nodes.right);

        if(leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }

    public int getTheHeightOfTheTree2(Nodes nodes) {
        if(nodes == null)
            return 0;

        return 1 + Math.max(getTheHeightOfTheTree2(nodes.left), getTheHeightOfTheTree2(nodes.right));
    }

    public int getLowestCommonAncestor(Nodes node1, Nodes node2){
        Nodes nodes = root;
        return getLowestCommonAncestor(nodes, node1, node2);
    }

    private int getLowestCommonAncestor(Nodes nodes, Nodes node1, Nodes node2) {
        Set<Nodes> lcaSetNode1 = new LinkedHashSet<>();
        Set<Nodes> lcaSetNode2 = new LinkedHashSet<>();
        boolean node1IsPresentInTree = calcutateLCA(nodes, node1, lcaSetNode1);
        if(!node1IsPresentInTree)
            return -1;

        boolean node2IsPresentInTree = calcutateLCA(nodes, node2, lcaSetNode2);
        if(!node2IsPresentInTree)
            return -1;
        return findTheLCA(lcaSetNode1, lcaSetNode2);
    }

    private boolean calcutateLCA(Nodes nodes, Nodes node1, Set<Nodes> lcaSet) {
        if(nodes == null)
            return false;

        if(nodes == node1)
            return true;

        boolean isNodeMatchedOnLeft = calcutateLCA(nodes.left, node1, lcaSet);
        if(isNodeMatchedOnLeft){
            lcaSet.add(nodes);
            return true;
        }
        boolean isNodeMatchedOnRight = calcutateLCA(nodes.right, node1, lcaSet);
        if(isNodeMatchedOnRight){
            lcaSet.add(nodes);
            return true;
        }
        return false;
    }




    private int findTheLCA(Set<Nodes> lcaSetNode1, Set<Nodes> lcaSetNode2) {
        for (Nodes n :
                lcaSetNode1) {
            System.out.print(n.data + " ");
        }

        System.out.println();

        for (Nodes n :
                lcaSetNode2) {
            System.out.print(n.data + " ");
        }
        return lcaSetNode1
                .parallelStream()
                .filter(nodes -> lcaSetNode2.contains(nodes))
                .findFirst()
                .get()
                .data;
    }

    public int countNodesInACompleteBinaryTree(Nodes node){
        if(node == null)
            return 0;

        return  countNodesInACompleteBinaryTree(node.left) +
                countNodesInACompleteBinaryTree(node.right) + 1;
    }

    public int countNodesInACompleteBinaryTreeSolution2(Nodes node){
        if(node == null)
            return 0;

        int height = getTheMaxHeightOfTheBalanceTree(node);
        int countOfLeafNodes[] = new int[1];
        calculateTheCountOfLeafNodes(node, height-1, countOfLeafNodes);

        return  countOfLeafNodes[0] + (int)Math.pow(2, height-1) - 1;
    }

    private boolean calculateTheCountOfLeafNodes(Nodes node, int height, int[] countOfLeafNodes) {
        if(node == null)
            return false;

        if(height == 1){
            if(node.left != null)
                countOfLeafNodes[0] = countOfLeafNodes[0] + 1;
            else
                return false;

            if(node.right != null)
                countOfLeafNodes[0] = countOfLeafNodes[0] + 1;
            else
                return false;

            return true;
        }
        boolean leftResult = calculateTheCountOfLeafNodes(node.left, height-1, countOfLeafNodes);
        if(!leftResult)
            return leftResult;
        boolean rightResult = calculateTheCountOfLeafNodes(node.right, height-1, countOfLeafNodes);
        if(!rightResult)
            return rightResult;
        return true;
    }

    private int getTheMaxHeightOfTheBalanceTree(Nodes node) {
        int count = 0;
        while (node != null){
            count++;
            node = node.left;
        }
        return count;
    }

    public void printLeftView(){
        Nodes node = root;
        leftView(node);
    }

    private void leftView(Nodes node) {

        if(node == null)
            return;

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(node);
        while(queue.isEmpty() == false){
            int size = queue.size();
            for(int i=1; i<=size; i++){
                Nodes data = queue.poll();
                if(i==1)
                    System.out.print(data.data+" ");
                if(data != null && data.left != null)
                    queue.add(data.left);
                if(data != null && data.right != null)
                    queue.add(data.right);
            }
        }
    }


}


