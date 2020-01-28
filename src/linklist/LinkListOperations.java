package linklist;

public class LinkListOperations {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertBegin(1);
        linkList.insertBegin(2);
        linkList.insertBegin(3);
        linkList.display();
        linkList.insertBegin(4);
        linkList.display();
        linkList.insertBegin(5);
        linkList.display();
        linkList.insertEnd(7);
        linkList.insertEnd(6);
        linkList.display();
        linkList.insertAtIndex(8, 4);
        linkList.display();
        linkList.insertAtIndex(9, 1);

        linkList.insertAtIndex(10, 100);
        linkList.display();

        linkList.insertAtIndex(-1, -1);

        linkList.insertAtIndex(-10, -100);
        linkList.display();
        linkList.deleteValue(10);
        linkList.display();
        linkList.deleteValue(-10);
        linkList.display();
        linkList.deleteValue(1);
        linkList.display();
        linkList.deleteValue(111);
        linkList.display();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.display();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.display();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.display();
    }
}
