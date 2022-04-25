package famous_interview.linklist;

public class PartitionByValue {
  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(8);
    Node node4 = new Node(11);
    Node node5 = new Node(3);
    Node node6 = new Node(10);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    displayLinklist(node1);
    Node reverseHead = partition(node1, 6);
    displayLinklist(reverseHead);
  }

  private static void displayLinklist(Node reverseHead) {
    while (reverseHead != null) {
      System.out.print(reverseHead.val + " -> ");
      reverseHead = reverseHead.next;
    }
    System.out.println();
  }

  private static Node partition(Node head, int k) {
    Node prev = null, node = head, start = null,  startHead = null, prevHead = null; Node backup = null;
    if (head == null) return head;

    while (node != null) {
      if(node.val < k){
        if (start == null) {
          start = new Node(node.val);
          startHead = start;
        } else {
          start.next = new Node(node.val);
          start = start.next;
        }
      }else{
        if (prev == null) {
          prev = new Node(node.val);
          prevHead = prev;
        } else {
          prev.next = new Node(node.val);
          prev = prev.next;
        }
      }
      node = node.next;
    }
    if(startHead == null)
      return prevHead;
    start.next = prevHead;
    return startHead;
  }
}
