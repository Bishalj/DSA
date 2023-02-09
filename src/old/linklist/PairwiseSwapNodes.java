package old.linklist;

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

    public static void swapNodes2(LinkList linkList){
        Node node = linkList.getHead();
        Node previousNode = null;
        Node tmpNode = null;
        Node nextNode = null;
        while (node != null && node.next != null){
            tmpNode = previousNode;
            nextNode = node.next.next;

            Node tmp = node;
            node = node.next;
            node.next = tmp;
            tmpNode.next = tmp;

            node.next.next = nextNode;
            previousNode.next = node.next;
            node = node.next.next;
        }
        linkList.setHead(previousNode);
    }

    public Node add(Node node1, Node node2){
        node1 = getReveseNode(node1);
        display(node1);
        node2 = getReveseNode(node2);
        display(node2);

        Node summationNode = null;
        Node result = null;
        int borrow = 0;
        int sum = 0;
        int totalSum = 0;
        while (node1 != null && node2 != null){
            sum = node1.data + node2.data;
            if(summationNode == null) {
                totalSum = sum;
                summationNode = new Node(sum % 10);
                result = summationNode;
            }
            else{
                totalSum = borrow + sum;
                summationNode.next = new Node(totalSum%10);
                summationNode = summationNode.next;
            }
            borrow = totalSum/10;
            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {
            totalSum = borrow + node1.data;
            summationNode.next = new Node(totalSum% 10);
            borrow = totalSum/10;
            summationNode = summationNode.next;
            node1 = node1.next;

        }

        while (node2 != null) {
            totalSum = borrow + node2.data;
            summationNode.next = new Node(totalSum% 10);
            borrow = totalSum/10;
            summationNode = summationNode.next;
            node2 = node2.next;
        }
        display(result);
        return result;
    }

    public void display(Node node){
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private Node getReveseNode(Node node) {
        Node previous = null;
        while(node != null){
            Node tmp = previous;
            Node next = node.next;
            previous = node;
            previous.next = tmp;
            node = next;
        }
        return previous;
    }
}

class op{
    public static void main(String[] args) {
        PairwiseSwapNodes pairwiseSwapNodes = new PairwiseSwapNodes();
        Node node1 = new Node(1);
//        LinkList linkList = new LinkList();
//        linkList.insertEnd(4);
//        linkList.insertEnd(5);
//        Node node = linkList.getHead();
//
//        LinkList linkList2 = new LinkList();
//        linkList2.insertEnd(3);
//        linkList2.insertEnd(4);
//        linkList2.insertEnd(5);
//        Node node2 = linkList2.getHead();
        LinkList linkList = new LinkList();
        linkList.insertEnd(6);
        linkList.insertEnd(3);
        Node node = linkList.getHead();

        LinkList linkList2 = new LinkList();
        linkList2.insertEnd(7);
        Node node2 = linkList2.getHead();
        Node sumNode = pairwiseSwapNodes.add(node, node2);
    }
}