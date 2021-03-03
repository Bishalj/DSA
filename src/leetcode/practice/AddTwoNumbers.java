package leetcode.practice;

public class AddTwoNumbers {
  public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
      ListNode l2 = new ListNode(2);
      l1.next = l2;
      ListNode l3 = new ListNode(7);
      ListNode l4 = new ListNode(8);
      l3.next = l4;
      ListNode sum = addTwoNumbers(l1,l3);
      String word = "";
      while (sum != null){
          word = sum.val + word;
          sum = sum.next;
      }
      System.out.println(word);
  }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int borrow = 0;
        ListNode listNode = null, head = null;
        while(l1 != null || l2 != null){
            int sum = (l1 != null ? l1.val:0) + (l2 != null ? l2.val:0) + borrow;
            ListNode newListNode = new ListNode(sum%10);
            borrow = sum/10;
            if(listNode == null){
                head = newListNode;
                listNode = newListNode;
            }else{
                listNode.next = newListNode;
                listNode = listNode.next;
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(borrow == 1)
            listNode.next = new ListNode(borrow);
        return head;
    }
}

 class ListNode{
    ListNode next;
    int val;

     public ListNode(int val) {
         this.val = val;
     }
 }