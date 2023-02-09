package old.famous_interview.linklist;

public class ReverseInGroups {

  public static void main(String[] args) {
	  Node node1 = new Node(1);
	  Node node2 = new Node(2);
	  Node node3 = new Node(3);
	  Node node4 = new Node(4);
	  Node node5 = new Node(5);
	  Node node6 = new Node(6);
	  node1.next = node2;
	  node2.next = node3;
	  node3.next = node4;
	  node4.next = node5;
	  node5.next = node6;
	  displayLinklist(node1);
	  Node reverseHead =  reverseInGroup(node1, 1);
	  displayLinklist(reverseHead);
  }

	private static void displayLinklist(Node reverseHead) {
		while (reverseHead != null){
			System.out.print(reverseHead.val + " -> ");
			reverseHead = reverseHead.next;
		}
		System.out.println();
	}

	private static Node reverseInGroup(Node head, int k){
  	return reverseInGroup(head, null, k);
  }

	private static Node reverseInGroup(Node head, Node previous, int k){
		if(head == null)
			return null;
		Node start = head;
		Node before = null;
		int count = 1;
		while(head != null && count++ <= k){
			Node next = head.next;
			head.next = before;
			before = head;
			head = next;
		}

		if(previous == null)
			previous = before;
		else
			previous.next = before;
		reverseInGroup(head, start, k);
		return previous;
	}
}

class Node{
	Node next;
	int val;
	Node(int val){
		this.val = val;
	}
}