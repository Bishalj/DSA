package linklist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CloneALinklist {
    public static RandomNode cloneALinklist(RandomNode randomNode){
        Map<RandomNode, RandomNode> randomNodeMap = new HashMap<>();
        RandomNode randomNewNode = null;
        RandomNode head = randomNode;

        while (randomNode != null){
            randomNodeMap.put(randomNode, new RandomNode(randomNode.data));
            if (randomNode.next != null)
                randomNodeMap.put(randomNode.next, new RandomNode(randomNode.next.data));
            if (randomNode.random != null)
                randomNodeMap.put(randomNode.random, new RandomNode(randomNode.random.data));
            randomNode = randomNode.next;
        }

        randomNewNode = randomNodeMap.get(head);
        randomNewNode.next = randomNodeMap.get(head.next);
        randomNewNode.random = randomNodeMap.get(head.random);
        RandomNode res = head;
        head = head.next;
        while (head != null){

            randomNewNode = randomNodeMap.get(head);
            randomNewNode.next = randomNodeMap.get(head.next);
            randomNewNode.random = randomNodeMap.get(head.random);
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {


        RandomNode next1 = new RandomNode(50);
        RandomNode next2 = new RandomNode(60);
        RandomNode next3 = new RandomNode(70);
        RandomNode next4 = new RandomNode(80);
//        RandomNode next5 = new RandomNode(90);
//
//        RandomNode random1 = new RandomNode(10);
//        RandomNode random2 = new RandomNode(20);
//        RandomNode random3 = new RandomNode(30);
//        RandomNode random4 = new RandomNode(40);
//        RandomNode random5 = new RandomNode(00);

        next3.next = next4;
        next3.random = next2;

        next1.next = next2;
        next1.random = next3;

        next2.next = next3;
        next2.random = next1;

        RandomNode randomNode = new RandomNode(110, next1, next4);


        cloneALinklist(randomNode);
    }


}

class RandomNode{
    public int data;
    public RandomNode next;
    public RandomNode random;

    public RandomNode() {
    }

    public RandomNode(int data, RandomNode next, RandomNode random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }

    public RandomNode(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

