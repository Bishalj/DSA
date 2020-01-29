package linklist;

public class LinkListOperations {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertBegin(1);
        linkList.insertBegin(2);
        linkList.insertBegin(3);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());

        linkList.insertBegin(4);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.insertBegin(5);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.insertEnd(7);
        linkList.insertEnd(6);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.insertAtIndex(8, 4);
        linkList.display();
        linkList.getTheMiddleElementInALinklist();
        linkList.insertAtIndex(9, 1);

        linkList.insertAtIndex(10, 100);
        linkList.display();
        linkList.getTheMiddleElementInALinklist();

        linkList.insertAtIndex(-1, -1);

        linkList.insertAtIndex(-10, -100);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.deleteValue(10);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.deleteValue(-10);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.deleteValue(1);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.deleteValue(111);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
    }
}
