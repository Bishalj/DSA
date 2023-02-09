package old.Stack;

public class TwoSrackArrayOperations {

    public static void main(String[] args) {
        TwoArrayStack twoArrayStack = new TwoArrayStack(5);

        twoArrayStack.display();

        twoArrayStack.push2(50);
        twoArrayStack.display();
        twoArrayStack.push1(1);
        twoArrayStack.display();
        twoArrayStack.push2(10);
        twoArrayStack.display();
        twoArrayStack.push2(20);
        twoArrayStack.display();
        twoArrayStack.push2(30);
        twoArrayStack.display();


        twoArrayStack.push2(80);
        twoArrayStack.display();


        twoArrayStack.push1(6);
        twoArrayStack.display();

        twoArrayStack.pop2();
        twoArrayStack.display();

        twoArrayStack.push1(6);
        twoArrayStack.display();

        twoArrayStack.push1(4);
        twoArrayStack.display();

        twoArrayStack.pop2();
        twoArrayStack.display();

        twoArrayStack.push2(100);
        twoArrayStack.display();
    }
}


class TwoArrayStack {

    private int capacity;
    private int top1;
    private int top2;
    int array[];

    public TwoArrayStack(int capacity){
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top1 = -1;
        this.top2 = capacity;
    }

    public void push2(int data) {
        if(isStackSizeFull())
            System.out.println("old.Stack is Overflow");
        else
            array[--top2] = data;
    }

    public void push1(int data) {
        if(isStackSizeFull())
            System.out.println("old.Stack is Overflow");
        else
            array[++top1] = data;
    }

    public void displayUsedSpace(){
        for (int i = 0; i <= top1; i++) {
            System.out.print(array[i] + " ");
        }
        for (int i = top2; i <= capacity-1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void display(){
        for (int i = 0; i < capacity; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private boolean isStackSizeFull() {
        return top1 >= top2 -1;
    }

    public void pop1() {
        if(isStackEmpty())
            System.out.println("old.Stack is under flow");
        else
            System.out.println("Data to be popped: " + array[top1--]);
    }

    public void pop2() {
        if(isStackEmptyForArray2())
            System.out.println("old.Stack is under flow");
        else
            System.out.println("Data to be popped: " + array[top2++]);
    }

    private boolean isStackEmptyForArray2() {
        return top2 == capacity;
    }

    public int peekArrayOne() {
        System.out.println("Peek element is: " + array[top1]);
        return array[top1];
    }

    public int peekArrayTwo() {
        System.out.println("Peek element is: " + array[top2]);
        return array[top2];
    }

    public void sizeOne() {
        System.out.println("Size is: " + (top1 +1));
    }

    public void sizeTwo() {
        System.out.println("Size is: " + (capacity - top2));
    }


    public boolean emptyOne() {
        return isStackEmpty();
    }

    public boolean emptyTwo() {
        return isStackEmptyForArray2();
    }

    private boolean isStackEmpty() {
        return top1 == -1;
    }
}