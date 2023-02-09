package old.design_pattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer1 = new A(subject);
        Observer observer2 = new B(subject);
        Observer observer3 = new C(subject);
        System.out.println("First state change");
        subject.setState(15);
        System.out.println("Second state change");
        subject.setState(35);

    }
}

class Subject{
    List<Observer> observers;
    private int state;

    Subject(){
        this.observers = new ArrayList<>();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObserver(){
        observers
                .forEach(observer -> observer.update());
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    public int getState() {
        return state;
    }
}

abstract class Observer {
    Subject subject;
    abstract void update();
}

class A extends Observer{
    A(Subject subject){
        this.subject = subject;
        subscribe();
    }

    @Override
    public void update() {
        System.out.println("A class state: " + subject.getState());
    }

    private void subscribe(){
        subject.attach(this);
    }
}

class B extends Observer{
    B(Subject subject){
        this.subject = subject;
        subscribe();
    }

    @Override
    public void update() {
        System.out.println("B class state: " + subject.getState());
    }

    private void subscribe(){
        subject.attach(this);
    }
}

class C extends Observer{
    C(Subject subject){
        this.subject = subject;
        subscribe();
    }

    @Override
    public void update() {
        System.out.println("C class state: " + subject.getState());
    }

    private void subscribe(){
        subject.attach(this);
    }
}