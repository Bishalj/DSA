package linklist;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionPointBetweenTwoLinkList {

    int getTheIntersectionPoint(LinkList linkListOne, LinkList linkListTwo){
        return intersectPoint(linkListOne.getHead(), linkListTwo.getHead());
    }

    int intersectPoint(Node headA, Node headB)
    {
        Set<Node> traversedNodes = new HashSet<>();
        while (headA != null){
            traversedNodes.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(traversedNodes.contains(headB))
                return headB.data;
            headB = headB.next;
        }
        return -1;
    }
}
