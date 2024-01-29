package crack_google.gfg.linklist;

import old.linklist.Node;

public class ReverseLinklistGroupWise {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;

		Node node = getReversedNode(node1, 3) ;
		while(node != null){
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	private static Node getReversedNode(Node node, int k) {
		Node next = null, curr = node, prev = null;
		int count = 0;
		while(curr != null && count < k){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if(next != null)
			node.next = getReversedNode(next, k);
		return prev;
	}
}
