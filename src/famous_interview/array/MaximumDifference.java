package famous_interview.array;


public class MaximumDifference {

	public static void main(String[] args) {
		int arr[] = {2,3,10,6,4,8,1};
		int max = arr[arr.length-1], diff = Integer.MIN_VALUE;
		for(int i=arr.length-2; i>=0; i--){
			if(max - arr[i] > diff)
				diff = max - arr[i];
			max = Math.max(max, arr[i]);
		}
		System.out.println(diff);
	}

	public boolean isPalindrome(ListNode1 head) {
		ListNode1 node = reverseList(head);
		while(node != null){
			if(head == null || node.val != head.val)
				return false;
			node = node.next;
			head = head.next;
		}
		return true;
	}

	public ListNode1 reverseList(ListNode1 head) {
		ListNode1 previous = null;
		ListNode1 node = head;
		while(node != null){
			ListNode1 next = node.next;
			node.next = previous;
			previous = node;
			node = next;
		}
		return previous;
	}
}

 class ListNode1 {
      int val;
      ListNode1 next;
      ListNode1() {}
      ListNode1(int val) { this.val = val; }
      ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
  }
