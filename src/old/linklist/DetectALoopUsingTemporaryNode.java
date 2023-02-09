package old.linklist;

public class DetectALoopUsingTemporaryNode {


    /*
    * This method changes the structure of the old.linklist
    * */

    public static boolean isLoopPersent(final LinkList linkList){
        Node node = linkList.getHead();
        Node tempNode = new Node(3);
        while (node.next != null){
            if(node.next == tempNode)
                return true;
            Node nextNode = node.next;
            node.next = tempNode;
            node = nextNode;
        }
        return false;
    }
}
