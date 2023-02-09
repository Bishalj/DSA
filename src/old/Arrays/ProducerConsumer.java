package old.Arrays;

import java.util.LinkedList;

public class ProducerConsumer {
    int size;
    int capacity;
    LinkedList<Integer> producing;
    int data;

    ProducerConsumer(int size){
        this.size = size;
        producing = new LinkedList();
        capacity = 0;
    }

    public void produce() throws InterruptedException {
        while (true){
            synchronized (this) {
                while (capacity < size) {
                    capacity++;
                    producing.add(++data);
                    System.out.println("Producing data: " + data);
                    notify();
                    Thread.sleep(1000);
                }
                wait();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (capacity > 0) {
                    capacity--;
                    int currData = producing.removeFirst();
                    System.out.println("Consuming data: " + currData);
                    notify();
                    Thread.sleep(1000);
                }
                wait();
            }
        }
    }

}

class MainOperation{
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer(2);
        Runnable target;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}

