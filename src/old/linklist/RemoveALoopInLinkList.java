package old.linklist;

public class RemoveALoopInLinkList {

    public static void removeALoop(final LinkList linkList){
        Node oneNodeSkip = linkList.getHead();
        Node twoNodeSkip = linkList.getHead();
        Node previousNode = linkList.getHead();
        while(twoNodeSkip != null && twoNodeSkip.next != null && oneNodeSkip != null){
            twoNodeSkip = twoNodeSkip.next.next;
            previousNode = oneNodeSkip;
            oneNodeSkip = oneNodeSkip.next;
            if(oneNodeSkip == twoNodeSkip){
                previousNode.next = null;
            }
        }

    }
}
