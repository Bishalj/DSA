package linklist;

public class DeleteNodeWithOnlyPointerGivenToIt {


    /*
    * Would not work if element to be deleted is the last element
    * */
    public static void deleteTheGivenNode(Node node){
        node.data = node.next.data;
        node = node.next.next;
    }
}
