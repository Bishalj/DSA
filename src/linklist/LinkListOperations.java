package linklist;

public class LinkListOperations {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        int k = 4;
        linkList.insertBegin(1);
        linkList.insertBegin(2);
        linkList.insertBegin(3);
        linkList.insertBegin(3);
        linkList.insertBegin(1);
        linkList.display();
        linkList.condense(linkList.getHead());
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
        System.out.println("---------------------Swap9999--------------------");
        PairwiseSwapNodes.swapNodes(linkList);
        linkList.display();
        PairwiseSwapNodes.swapNodes(linkList);
        linkList.display();
        System.out.println("Segregate----------------------------");
        Node result = SegregateEvenOddNodesOfLinkedList.segregateEvenOddNodes1(linkList);
        SegregateEvenOddNodesOfLinkedList.display(result);
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
//        linkList.deleteValue(1);
//        linkList.display();

//        linkList.display();
//        System.out.println(linkList.getTheMiddleElementInALinklist());
//        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
//        linkList.deleteLastElement();
//        linkList.deleteLastElement();
//        linkList.deleteLastElement();
//        linkList.deleteLastElement();
//        linkList.display();
//        System.out.println(linkList.getTheMiddleElementInALinklist());
//        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
//        linkList.deleteLastElement();
//        linkList.deleteLastElement();
//        linkList.deleteLastElement();
//        linkList.deleteLastElement();
//        linkList.display();
//        System.out.println(linkList.getTheMiddleElementInALinklist());
//        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
//        linkList.deleteLastElement();
//        linkList.deleteLastElement();
//        linkList.deleteLastElement();
//        linkList.deleteLastElement();
//        linkList.display();
//        System.out.println(linkList.getTheMiddleElementInALinklist());
//        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );

        linkList.reverseTheLinkList();
        linkList.display();
        linkList.reverseTheLinkListRecursive();
        System.out.println(linkList.getTheMiddleElementInALinklist());
        System.out.println("The "+ k +"th element is: " + linkList.getNthNodeOfTheLinkList(k) );
        linkList.deleteValue(8);
        linkList.reverseTheLinkList();
        linkList.display();
        linkList.reverseTheLinkListRecursive();
        Node node1 = new Node(4);
        linkList.insertEnd(node1);
        Node node2 = new Node(5);
        linkList.insertEnd(node2);
        Node node3 = new Node(6);
        node3.next = node3;
        linkList.insertEnd(node3);
        Node node4 = new Node(7);
        node4.next = node1;
        System.out.println(DetectALoop.isAloopPresentInLinklist(linkList));
        RemoveALoopInLinkList.removeALoop(linkList);
        System.out.println(DetectALoopUsingTemporaryNode.isLoopPersent(linkList));

        System.out.println(DetectALoop.isAloopPresentInLinklist(linkList));
        RemoveALoopInLinkList.removeALoop(linkList);
        System.out.println(DetectALoopUsingTemporaryNode.isLoopPersent(linkList));
        linkList.display();
        PairwiseSwapNodes.swapNodes(linkList);
        linkList.display();

//        linkList.insertEnd(3);
//        linkList.insertEnd(4);
        linkList.display();
        System.out.println(linkList.isPalindrome());
//        Nodes result = SegregateEvenOddNodesOfLinkedList.segregateEvenOddNodes(linkList);
//        SegregateEvenOddNodesOfLinkedList.display(result);


    }
}
