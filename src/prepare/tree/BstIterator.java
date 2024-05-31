package prepare.tree;

import java.util.LinkedList;

class BstIterator {

	LinkedList<Integer> treeNodeValues;
	public BstIterator(TreeNode root) {
		treeNodeValues = new LinkedList();
		inOrderTraversal(root);
	}

	private void inOrderTraversal(TreeNode root) {
		if(root==null)
			return;
		inOrderTraversal((root.left));
		treeNodeValues.add(root.val);
		inOrderTraversal((root.right));
	}

	public int next() {
		if(treeNodeValues.isEmpty())
			return 0;
		return treeNodeValues.remove();
	}

	public boolean hasNext() {
		return treeNodeValues!=null;
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}


class KthLargest {

	int k;
	TreeNode root = null;
	public KthLargest(int k, int[] nums) {
		for (int i = 0; i < nums.length; i++)
			insertNode(root, nums[i]);
		this.k = k;
	}

	private void insertNode(TreeNode root, int val) {
		if(root == null)
			this.root = new TreeNode(val);
		else {
			while (root != null) {
				if (root.val > val) {
					if (root.left == null) {
						root.left = new TreeNode(val);
						return;
					} else
						root = root.left;
				} else {
					if (root.right == null) {
						root.right = new TreeNode(val);
						return;
					} else
						root = root.right;
				}
			}
		}
	}

	public int add(int val) {
		insertNode(root, val);
		int tmp = k;
		TreeNode tree = kthElement(root);
		k = tmp;
		System.out.println(tree.val);
		return tree.val;
	}

	private TreeNode kthElement(TreeNode root) {
		if(root==null)
			return null;
		TreeNode left = kthElement(root.left);
		if(left != null)
			return left;
		if(k--==1)
			return root;
		return kthElement(root.right);
	}

	public static void main(String[] args) {
		KthLargest k = new KthLargest(3, new int[]{4,5,8,2});
		k.add(3);
		k.add(5);
		k.add(10);
		k.add(9);
		k.add(4);
	}
}