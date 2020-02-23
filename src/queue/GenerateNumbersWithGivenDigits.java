package queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GenerateNumbersWithGivenDigits {

    public static void main(String[] args) {
        int smallNumber = 5;
        int bigNumber = 6;
        int n = 10;
        Stack<String> numberQueue = new Stack<String>();
        Queue<String> temporaryNumberQueue = new LinkedList<String>();
        for (int i = 0; i < n; i++) {
            if(numberQueue.isEmpty()){
                numberQueue.add(String.valueOf(smallNumber));
                while (!temporaryNumberQueue.isEmpty())
                    numberQueue.add(temporaryNumberQueue.remove());
            }else {
                while (!numberQueue.isEmpty() && Integer.parseInt(numberQueue.peek()) != smallNumber){
                    numberQueue.pop();
                    temporaryNumberQueue.add(String.valueOf(smallNumber));
                }
                if(!numberQueue.isEmpty()) {
                    numberQueue.pop();
                    numberQueue.add(String.valueOf(bigNumber));
                }else {
                    numberQueue.add(String.valueOf(smallNumber));
                }

                while (!temporaryNumberQueue.isEmpty())
                    numberQueue.add(temporaryNumberQueue.remove());
            }
            display(numberQueue);
        }


    }

    private static void display(Stack<String> stack) {
        Stack<String> newStack = new Stack<String>();
        newStack.addAll(stack);
        String result = "";
        while (!newStack.isEmpty()){
            result = newStack.pop() + result;
        }
        System.out.println(result);
    }
}
