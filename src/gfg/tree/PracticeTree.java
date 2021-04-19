package gfg.tree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PracticeTree {

  public void inOrderTraversal(NodeTree root) {

    if (root == null) return;

    inOrderTraversal(root.left);
    System.out.print(root.key + " ");
    inOrderTraversal(root.right);
  }

  public void preOrderTraversal(NodeTree root) {

    if (root == null) return;

    System.out.print(root.key + " ");
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  public void postOrderTraversal(NodeTree root) {
    if (root == null) return;

    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    System.out.print(root.key + " ");
  }

  public int height(NodeTree root) {
    if (root == null) return 0;

    return 1 + Math.max(height(root.left), height(root.right));
  }

  public void nodesAtKthDistance(NodeTree root, int k) {
    if (root == null) return;
    if (k == 0) System.out.print(root.key + " ");
    else {
      nodesAtKthDistance(root.left, k - 1);
      nodesAtKthDistance(root.right, k - 1);
    }
  }

  public void OrderTraversalWithLine(NodeTree root) {
    if (root == null) return;
    Queue<NodeTree> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        NodeTree node = queue.poll();
        System.out.print(node.key + " ");
        if (node != null && node.left != null) queue.add(node.left);
        if (node != null && node.right != null) queue.add(node.right);
      }
      System.out.println();
    }
  }

  public void levelOrderTraversal(NodeTree root) {
    if (root == null) return;
    Queue<NodeTree> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      NodeTree node = queue.poll();
      if (node != null) System.out.print(node.key + " ");
      if (node != null && node.left != null) queue.add(node.left);
      if (node != null && node.right != null) queue.add(node.right);
    }
  }


	public int max(NodeTree node) {
		if (node == null)
			return Integer.MIN_VALUE;

		return Math.max(node.key, Math.max(max(node.left), max(node.right)));

	}

	public long countNodesInCompleteBinaryTree(NodeTree node){
      if(node == null)
        return 0;

      int leftCount = countNodesOnLeft(node.left);
      int rightCount = countNodesOnRight(node.right);
      System.out.println("Left Count : " + leftCount);
      System.out.println("Right Count : " + rightCount);
      if (leftCount == rightCount)
        return (long) (Math.pow(2,leftCount+1) - 1);

      long left = countNodesInCompleteBinaryTree(node.left);
      long right = countNodesInCompleteBinaryTree(node.right);

      System.out.println("Left : " + left);
      System.out.println("Right : " + right);

      return left + right + 1;
    }



  private int countNodesOnRight(NodeTree nodeTree) {
    int count = 0;
    while (nodeTree != null){
      count++;
      nodeTree = nodeTree.right;
    }
    return count;
  }

  private int countNodesOnLeft(NodeTree nodeTree) {
    int count = 0;
    while (nodeTree != null){
      count++;
      nodeTree = nodeTree.left;
    }
    return count;
  }

  public List<Integer> serialize(NodeTree node){
    List<Integer> list = new ArrayList<Integer>();
    serialize(node, list);
    return list;
  }

  private void serialize(NodeTree node, List<Integer> list) {
    if(node == null){
      list.add(null);
      return;
    }

    list.add(node.key);
    serialize(node.left, list);
    serialize(node.right, list);
  }
  int pos = 0;
  public NodeTree deserialize(List<Integer> list){
    pos=0;
    return deserialize2(list);
  }
  public NodeTree deserialize2(List<Integer> list){
    if (list == null || list.isEmpty()) return null;
    else if (list.get(pos) == null) {
      pos++;
      return null;
    }
    NodeTree nodeTree = new NodeTree(list.get(pos));
    pos++;
    nodeTree.left = deserialize2(list);
    nodeTree.right = deserialize2(list);
    return nodeTree;
  }

  public static void main(String[] args) {
    PracticeTree practiceTree = new PracticeTree();
    NodeTree nodeTree1 = new NodeTree(10);
    NodeTree nodeTree2 = new NodeTree(20);
    NodeTree nodeTree3 = new NodeTree(30);
    NodeTree nodeTree4 = new NodeTree(40);
    NodeTree nodeTree5 = new NodeTree(50);
//    NodeTree nodeTree6 = new NodeTree(60);
    nodeTree1.left = nodeTree2;
    nodeTree1.right = nodeTree3;
    nodeTree3.left = nodeTree4;
    nodeTree3.right = nodeTree5;
//    nodeTree5.left = nodeTree6;
    System.out.println("In Order Traversal");
    practiceTree.inOrderTraversal(nodeTree1);
    System.out.println("\nPre Order Traversal");
    practiceTree.preOrderTraversal(nodeTree1);
    System.out.println("\nPost Order Traversal");
    practiceTree.postOrderTraversal(nodeTree1);
    System.out.println();
    System.out.println("Height of the tree: " + practiceTree.height(nodeTree1));
    int k = 1;
    System.out.println("Nodes at kth - " + k + " distance of the tree");
    practiceTree.nodesAtKthDistance(nodeTree1, k);
    System.out.println();
    System.out.println("Level order traversal");
    practiceTree.levelOrderTraversal(nodeTree1);
    System.out.println();
	  System.out.println("Level order traversal with line");
	  practiceTree.OrderTraversalWithLine(nodeTree1);
	  System.out.println();
	  System.out.println("Max value in Tree: " + practiceTree.max(nodeTree1));
    System.out.println("--------------------------------------------count----------------------------");
    System.out.println(practiceTree.countNodesInCompleteBinaryTree(nodeTree1));
    System.out.println("-------------------------------------------- Print original ----------------------------");
    practiceTree.OrderTraversalWithLine(nodeTree1);
    System.out.println();
    System.out.println("-------------------------------------------- Serialize ----------------------------");
    List<Integer> list = practiceTree.serialize(nodeTree1);
    System.out.println(list);
    System.out.println("-------------------------------------------- deserialize ----------------------------");
    NodeTree nodeTree = practiceTree.deserialize(list);
    practiceTree.OrderTraversalWithLine(nodeTree);
    System.out.println("-------------------------------------------- Print original ----------------------------");
    practiceTree.OrderTraversalWithLine(nodeTree1);
    System.out.println();
    System.out.println("-------------------------------------------- Serialize ----------------------------");
    list = practiceTree.serialize(nodeTree1);
    System.out.println(list);
    System.out.println("-------------------------------------------- deserialize ----------------------------");
    nodeTree = practiceTree.deserialize(list);
    practiceTree.OrderTraversalWithLine(nodeTree);
  }
}

