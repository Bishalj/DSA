package linklist;

public class PairwiseSwapNodes {

    public static void swapNodes(LinkList linkList){
        Node node = linkList.getHead();
        Node previousNode = null;
        Node nextNode = null;
        while (node != null && node.next != null){
            if(nextNode != null)
                nextNode.next.next = node.next;
            nextNode = node.next;
            node.next = node.next.next;
            nextNode.next = node;
            if(previousNode == null)
                previousNode = nextNode;
            node = node.next;
        }
        linkList.setHead(previousNode);
    }
}