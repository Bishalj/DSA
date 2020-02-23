package queue;

import java.util.LinkedList;

public class StackUsingQueues<T> {

    private java.util.Queue<T> queueOne;
    private java.util.Queue<T> queueTwo;

    StackUsingQueues(){
        queueOne = new LinkedList<T>();
        queueTwo = new LinkedList<T>();
    }

    public void push(T data){
        while (!queueOne.isEmpty()) {
            queueTwo.add(queueOne.peek());
            queueOne.remove();
        }
        queueOne.add(data);
        while (!queueTwo.isEmpty()){
            queueOne.add(queueTwo.peek());
            queueTwo.remove();
        }
    }

    public void pop(){
        if(queueOne.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        queueOne.remove();
    }

    public int size(){
        return queueOne.size();
    }

    public T top(){
        return queueOne.peek();
    }

    public void display(){
        T[] arr = (T[]) queueOne
                .toArray();
        for (int i = arr.length - 1; i >=0 ; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
