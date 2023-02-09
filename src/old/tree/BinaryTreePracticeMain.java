package old.tree;

public class BinaryTreePracticeMain {
    public static void main(String[] args) {
        Operations operations = new Operations();
        operations.insertNode(10);
        operations.insertNode(50);
        operations.insertNode(30);
        operations.insertNode(20);
        operations.insertNode(9);
        System.out.println(operations.getHeight());


    }
}
