package tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTreeOperations binaryTreeOperations = new BinaryTreeOperations();
        binaryTreeOperations.insert(10);
        binaryTreeOperations.insert(80);
        binaryTreeOperations.insert(180);
        binaryTreeOperations.insert(20);
        binaryTreeOperations.insert(90);
        binaryTreeOperations.insert(40);
        binaryTreeOperations.insert(50);
        binaryTreeOperations.insert(100);
        binaryTreeOperations.insert(120);
        binaryTreeOperations.inOrderTraversal();
        System.out.println();
        binaryTreeOperations.preOrderTraversal();
        System.out.println();
        binaryTreeOperations.postOrderTraversal();
        System.out.println();
        binaryTreeOperations.levelOrderTraversal();
        System.out.println();
        binaryTreeOperations.levelOrderTraversalUsingQueue();

        System.out.println();
        binaryTreeOperations.levelOrderTraversalUsingQueueLineWise();
        System.out.println();
        System.out.println("Size of a Array: " + binaryTreeOperations.sizeOfABinaryTree());

        System.out.println();
        System.out.println("Size of a Array: " + binaryTreeOperations.sizeOfABinaryTreeTailRecursive());

        System.out.println();
        System.out.println("The maximum value is: " + binaryTreeOperations.getTheMaximumValueInABinaryTree());


        System.out.println();
        System.out.println("The Height of a binary tree is: " + binaryTreeOperations.getTheHeightOfABinaryTree());


        System.out.println();
        binaryTreeOperations.printTheKthElement(1);

        System.out.println();
        binaryTreeOperations.printTheLeftMostElement();

        Nodes nodes1 = new Nodes(20);
        Nodes nodes2 = new Nodes(8);
        Nodes nodes3 = new Nodes(12);
        Nodes nodes4 = new Nodes(3);
        Nodes nodes5 = new Nodes(5);
        Nodes nodes6 = new Nodes(22);
        Nodes nodes7 = new Nodes(33);
        Nodes nodes8 = new Nodes(44);
        Nodes nodes9= new Nodes(212);
        Nodes nodes10= new Nodes(2122);
        nodes9.left = nodes10;
        nodes6.left = nodes8;
        nodes6.right  = nodes7;
        nodes4.right = nodes6;
        nodes4.left = nodes9;
        nodes2.left = nodes4;
        nodes2.right = nodes5;
        nodes1.left = nodes2;
        nodes1.right = nodes3;
        binaryTreeOperations.setRoot(nodes1);
        binaryTreeOperations.levelOrderTraversalUsingQueueLineWise();
        System.out.println();
        System.out.println(binaryTreeOperations.isChildrenSumProperty());
        System.out.println(binaryTreeOperations.treeIsABalancedTree());
        System.out.println(binaryTreeOperations.maxWidthOfATree());

        binaryTreeOperations.levelOrderTraversalUsingQueueLineWise();
        System.out.println("#############Spiral###################");
        binaryTreeOperations.printSpiralTree();
//        System.out.println("#############Spiral###################");
//        binaryTreeOperations.displayDoublyLinklist(binaryTreeOperations.createDoublyLinkList());
//        System.out.println();
        int[] inOrder = {40, 20, 50, 10, 30, 80, 70, 90};
        int[] preOrder = {10, 20, 40, 50, 30, 70,  80, 90};
        Nodes nodes = binaryTreeOperations.createTree(inOrder, preOrder);
        binaryTreeOperations.inOrderTraversal(nodes);
        System.out.println();
        binaryTreeOperations.postOrderTraversal(nodes);
        System.out.println();
        System.out.println("Height of the tree: " + binaryTreeOperations.getTheHeightOfTheTree(nodes));
        System.out.println();
        System.out.println(binaryTreeOperations.getTheDiameterOfTheTree(nodes));


        System.out.println();
        binaryTreeOperations.levelOrderTraversalUsingQueueLineWise();
        System.out.println();
        System.out.println(binaryTreeOperations.countNodesInACompleteBinaryTree(nodes));
        System.out.println();
        System.out.println("LCA " + binaryTreeOperations.getLowestCommonAncestor(nodes9, nodes2));

        Nodes completeTree1 = new Nodes(10);
        Nodes completeTree2 = new Nodes(20);
        Nodes completeTree3 = new Nodes(30);
        Nodes completeTree4 = new Nodes(40);
        Nodes completeTree5 = new Nodes(50);
        Nodes completeTree6 = new Nodes(60);
        Nodes completeTree7 = new Nodes(70);
        Nodes completeTree8 = new Nodes(80);
        Nodes completeTree9 = new Nodes(90);
        completeTree1.left =  completeTree2;
        completeTree1.right =  completeTree3;
        completeTree2.left = completeTree4;
        completeTree2.right = completeTree5;
        completeTree3.left = completeTree6;
        completeTree3.right= completeTree7;
        completeTree4.left = completeTree8;
        completeTree4.right = completeTree9;
        System.out.println();
        System.out.println(binaryTreeOperations.countNodesInACompleteBinaryTreeSolution2(completeTree1));
        System.out.println();
    }
}