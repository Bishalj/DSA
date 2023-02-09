package old.java_practice;

public class PracticeVolatile implements Runnable {

    public volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Runnable target;
        Thread t1 = new Thread("one");
        t1.start();
        t1.sleep(800);

        Thread t2 = new Thread("two");
        t2.start();
        t1.sleep(200);
    }

    @Override
    public void run() {
        flag = true;
    }
}
