package old.binarysearchtree;

public class BinarySearchTreeMain {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(12);
        binarySearchTree.insert(20);
        binarySearchTree.insert(8);
        binarySearchTree.insert(11);

        binarySearchTree.preOrderTraversal();
        System.out.println(binarySearchTree.search(10));
        System.out.println(binarySearchTree.search(40));
        System.out.println(binarySearchTree.search(15));
        System.out.println(binarySearchTree.search(20));
        System.out.println("Binary Search old.tree");
        System.out.println(binarySearchTree.isATreeBST());
        System.out.println();
        System.out.println(binarySearchTree.gerFloorElement(14));
        System.out.println();
        System.out.println(binarySearchTree.getCeilElement(14));
        System.out.println();
        System.out.println(binarySearchTree.getCeilElement(3));
        System.out.println();
        System.out.println(binarySearchTree.getCeilElement(40));
        System.out.println();
        binarySearchTree.swapTwoNodesToMakeItBST();
        System.out.println();
        binarySearchTree.preOrderTraversal();
        System.out.println();
        System.out.println(binarySearchTree.isPairSumForAGivenSumExistInBST(17));

        binarySearchTree.printTheVerticalSumInABinaryTree();

        System.out.println();

        binarySearchTree.printTheVerticalTraversalInABinaryTree();
        System.out.println();
        binarySearchTree.printTheTopViewInABinaryTree();
        System.out.println();
        binarySearchTree.printTheBottomViewInABinaryTree();

    }
}
