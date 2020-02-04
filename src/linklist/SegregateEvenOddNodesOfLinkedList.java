package linklist;

public class SegregateEvenOddNodesOfLinkedList {

    public static Node segregateEvenOddNodes1(LinkList linkList){
        Node currentNode = linkList.getHead();
        Node evenStartNode = null;
        Node oddStartNode = null;
        Node evenNode = null;
        Node oddNode = null;
        while (currentNode != null) {
            Node node = new Node(currentNode.data);
            if (node.data % 2 == 0) {
                if(evenNode == null) {
                    evenNode = node;
                    evenStartNode = evenNode;
                }else {
                    evenNode.next = node;
                    evenNode = evenNode.next;
                }
            }else{
                if(oddNode == null) {
                    oddNode = node;
                    oddStartNode = oddNode;
                }else {
                    oddNode.next = node;
                    oddNode = oddNode.next;
                }
            }
            currentNode = currentNode.next;
        }
        if(evenStartNode == null)
            return oddStartNode;
        evenNode.next = oddStartNode;
        return evenStartNode;
    }


    static void display(Node node){
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
