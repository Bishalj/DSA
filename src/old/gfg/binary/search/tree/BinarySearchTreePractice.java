package old.gfg.binary.search.tree;

import old.gfg.tree.NodeTree;
import old.gfg.tree.PracticeTree;

import java.util.Map;
import java.util.TreeMap;

public class BinarySearchTreePractice {

	public NodeTree head;
	BinarySearchTreePractice(){
		this.head = null;
	}
	public NodeTree insert(int data){
		NodeTree node = head;
		if(head == null){
			head = new NodeTree(data);
		}else{
			while (node != null){
				if (data < node.key) {
				  NodeTree tmp = node;
				  node = node.left;
				  if(node == null){
				  	tmp.left = new NodeTree(data);
				  	return head;
				  }
				}else {
					NodeTree tmp = node;
					node = node.right;
					if(node == null){
						tmp.right = new NodeTree(data);
						return head;
					}
				}
			}
		}
		return head;

	}

	public Boolean search(int data){
		NodeTree node = head;
		if(head == null)
			return false;
			while (node != null){
				if(node.key == data)
					return true;
				else if (data < node.key)
					node = node.left;
				else
					node = node.right;
			}
		return false;

	}

	public void verticalSum(NodeTree head, Map<Integer, Integer> map, int k){
		if(head == null)
			return;

		map.put(k, map.getOrDefault(k, 0) + head.key);
		verticalSum(head.left, map, k-1);
		verticalSum(head.right, map, k+1);
	}


  public static void main(String[] args) {
  	BinarySearchTreePractice binarySearchTreePractice = new BinarySearchTreePractice();
  	binarySearchTreePractice.insert(30);
	  binarySearchTreePractice.insert(10);
	  binarySearchTreePractice.insert(40);
	  binarySearchTreePractice.insert(45);
	  binarySearchTreePractice.insert(50);
	  binarySearchTreePractice.insert(20);
	  binarySearchTreePractice.insert(42);
	  binarySearchTreePractice.insert(41);

	  PracticeTree practiceTree = new PracticeTree();
	  practiceTree.OrderTraversalWithLine(binarySearchTreePractice.head);
	  System.out.println(binarySearchTreePractice.search(42));
	  System.out.println(binarySearchTreePractice.search(30));
	  System.out.println(binarySearchTreePractice.search(41));
	  System.out.println(binarySearchTreePractice.search(43));

	  Map<Integer, Integer> map = new TreeMap();
	  binarySearchTreePractice.verticalSum(binarySearchTreePractice.head, map, 0);
	  for(Map.Entry<Integer, Integer> aMapData: map.entrySet()){
	  	System.out.print(aMapData.getValue() + " ");
	  }
	  System.out.println();
  }
}
