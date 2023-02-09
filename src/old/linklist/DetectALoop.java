package old.linklist;

public class DetectALoop {

    public static boolean isAloopPresentInLinklist(LinkList linkList){
        Node oneNodeSkip = linkList.getHead();
        Node twoNodeSkip = linkList.getHead();

        while(twoNodeSkip != null && twoNodeSkip.next != null && oneNodeSkip != null){
            twoNodeSkip = twoNodeSkip.next.next;
            oneNodeSkip = oneNodeSkip.next;
            if(oneNodeSkip == twoNodeSkip)
                return true;
        }
        return false;
    }
}
