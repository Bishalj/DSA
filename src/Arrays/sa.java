package Arrays;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

public class sa {

    public static void main(String[] args) {
        p(null);
//        sp(null);
    }

    static void p(Object o){
        System.out.println("s");
    }

    static void  p(String o){
        System.out.println("f");
    }

}

class Counter{

    volatile int count;

    String data;
    Counter(String data){
        this.data =data;
    }

    public synchronized int count() {
        count++;
        return count;
    }

    public String data(){
        return data;
    }

    public static void main(String[] args) throws InterruptedException {
        Comparator<String> comparator = (x,y) -> x.compareTo(y);
        TreeMap treeMap = new TreeMap<>(comparator);
        Counter counter1 = new Counter("first");
        Counter counter2 = new Counter("Second");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(counter1.data() + " " + counter1.count());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(counter2.data() + " " + counter2.count());
            }
        });

        t1.start();
        t2.start();

//        t1.join();
//        t2.join();
    }


}

abstract class Parent{
    public void walk(){
        run();
    }

    abstract public void run();
}

class Child extends Parent{
    public void walk(){
        super.walk();
    }

    public void run(){
        System.out.println("Run Child");
    }
}

class d{
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.walk();
    }
}

class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        PowerCalculatingThread p1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread p2 = new PowerCalculatingThread(base2, power2);
        Thread t1 = p1;
        Thread t2 = p2;
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = p1.getResult().add(p2.getResult());
        return result;
    }

      public static void main(String[] args) throws InterruptedException {
          ComplexCalculation complexCalculation = new ComplexCalculation();
          BigInteger b1 = new BigInteger("20");
          BigInteger b2 = new BigInteger("10");
          BigInteger p1 = new BigInteger("10");
          BigInteger p2 = new BigInteger("10");
          System.out.println(complexCalculation.calculateResult(b1,p1,b2,p2).toString());
      }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            this.result = base.pow(power.intValue());
        }

        public BigInteger getResult() { return result; }
    }
}
