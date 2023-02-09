package old.gfg.linklist;

public class LinkListPractice {

  private static Node insertAtEnd(Node node, int data){
    Node head = node;
    if(node == null)
      return new Node(data);
    while(node.next != null)
      node = node.next;
    node.next = new Node(data);
    return head;
  }

  public static void main(String[] args) {
    //
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    Node node = LinkListPractice.insertAtEnd(node1, 90);
    displayNode(node);
    System.out.println();
    node = reverse(node1);
    displayNode(node);

    System.out.println("\n------------Pairwise swap------------------");
    displayNode(node);
    Node n = pairwiseSwap(node);
    displayNode(n);
    System.out.println();
  }

  private static Node pairwiseSwap(Node head) {
    Node node = head;
    Node previous = null;
    Node next, start = head;
    while(node != null && node.next != null){
      next = node.next;
      node.next = node.next.next;
      if (previous != null)
        previous.next = next;
      else
        start = next;
      next.next = node;
      previous = node;
      node = node.next;
    }

    return start;
  }

  private static void displayNode(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println();
  }

  private static Node reverse(Node node) {
    if(node == null)
      return null;

    Node curr = node;
    Node previous = null;
    Node next;

    while(curr != null){
      next = curr.next;
      curr.next = previous;
      previous = curr;
      curr = next;
    }
    return previous;
  }
}

class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
  }
}
