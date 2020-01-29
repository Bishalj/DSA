package linklist;

public class LinkListOperations {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        int k = 4;
        linkList.insertBegin(1);
        linkList.insertBegin(2);
        linkList.insertBegin(3);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );

        linkList.insertBegin(4);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.insertBegin(5);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.insertEnd(7);
        linkList.insertEnd(6);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
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
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.deleteValue(10);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.deleteValue(-10);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.deleteValue(1);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.deleteValue(111);
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.deleteLastElement();
        linkList.display();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
    }
}
