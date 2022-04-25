package linklist;

import java.util.HashSet;
import java.util.Set;

public class RTest {



    public static Node condense(Node head) {
        // Write your code here
        Set<Integer> values = new HashSet<>();
        Node node = head;
        Node previous = head;
        node = node.next;
        while(node != null){
            if(values.contains(node.data)){
                previous.next = node.next;
            }else{
                values.add(node.data);
                previous = node;
            }
            node = node.next;
        }
        return head;
    }
}
