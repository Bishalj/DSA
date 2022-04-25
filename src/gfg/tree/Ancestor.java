package gfg.tree;

public class Ancestor {

	public NodeTree ancestor(NodeTree node, int n1, int n2){
		if(node == null)
			return null;
		else if(node.key == n1 || node.key == n2)
			return node;

		NodeTree lca1 = ancestor(node.left, n1, n2);
		NodeTree lca2 = ancestor(node.right, n1, n2);
		if(lca1 != null && lca2 != null)
			return node;
		else if (lca1 != null)
			return lca1;
		else
			return lca2;
	}

  public static void main(String[] args) {
	  NodeTree nodeTree1 = new NodeTree(10);
	  NodeTree nodeTree2 = new NodeTree(20);
	  NodeTree nodeTree3 = new NodeTree(30);
	  NodeTree nodeTree4 = new NodeTree(40);
	  NodeTree nodeTree5 = new NodeTree(50);
	  nodeTree1.left = nodeTree2;
	  nodeTree1.right = nodeTree3;
	  nodeTree3.left = nodeTree4;
	  nodeTree3.right = nodeTree5;
	  Ancestor ancestor = new Ancestor();
	  System.out.println(ancestor.ancestor(nodeTree1, 20, 40).key);
	  System.out.println(ancestor.ancestor(nodeTree1, 30, 40).key);
	  System.out.println(ancestor.ancestor(nodeTree1, 30, 50).key);
	  System.out.println(ancestor.ancestor(nodeTree1, 50, 40).key);
	  System.out.println(ancestor.ancestor(nodeTree1, 10, 50).key);
  }
}
