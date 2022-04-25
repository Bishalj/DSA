package leetcode.practice;

import java.util.LinkedList;

public class ReverseLinklist {
  public static void main(String[] args) {
//      LList lList1 = new LList(1);
//      LList lList2 = new LList(2);
//      LList lList3 = new LList(3);
//      LList lList4 = new LList(4);
//      LList lList5 = new LList(5);
//      lList1.next = lList2;
//      lList2.next = lList3;
//      lList3.next = lList4;
//      lList4.next = lList5;
//      LList ll = reverseList(lList1);
//
//      while (ll != null){
//          System.out.println(ll.value);
//          ll = ll.next;
//      }

      int a = 8;
      int b = 6;
      System.out.println(a | ( 1 << (b-1)));
  }

    private static LList reverseList(LList linkList) {
      LList previous = null;
      while(linkList != null){
          LList next = linkList.next;
          linkList.next = previous;
          previous = linkList;
          linkList = next;
      }
      return previous;
    }
}

class LList{
    int value;
    LList next;
    public LList(int value){
        this.value = value;
    }
}
