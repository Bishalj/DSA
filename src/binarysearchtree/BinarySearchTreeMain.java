package binarysearchtree;

public class BinarySearchTreeMain {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(50);
        binarySearchTree.insert(10);
        binarySearchTree.insert(80);
        binarySearchTree.insert(70);
        binarySearchTree.insert(90);
        binarySearchTree.insert(90);

        binarySearchTree.insert(9);

        binarySearchTree.insert(8);
        binarySearchTree.preOrderTraversal();
        System.out.println(binarySearchTree.isElementPresent(90));
        System.out.println(binarySearchTree.isElementPresent(80));

        binarySearchTree.insert(55);
        System.out.println(binarySearchTree.isATreeBST());
    }
}