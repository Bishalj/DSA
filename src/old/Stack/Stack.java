package old.Stack;

public class Stack {

    private int capacity;
    private int top;
    int array[];

    public Stack(int capacity){
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = -1;
    }

    public void push(int data) {
        if(isStackSizeFull())
            System.out.println("old.Stack is Overflow");
        else
            array[++top] = data;
    }

    public void display(){
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    private boolean isStackSizeFull() {
        return top == capacity;
    }

    public void increaseCapacity() {
        capacity *= 2;
        int newArray[] = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void pop() {
        if(isStackEmpty())
            System.out.println("old.Stack is under flow");
        else
//            System.out.println("Data to be popped: " + array[top--]);
        top--;
    }

    public int peek() {
//        if(top == -1)
//            return -1;
//        System.out.println("Peek element is: " + array[top]);
        return array[top];
    }

    public void size() {
        System.out.println("Size is: " + (top+1));
    }


    public boolean empty() {
        return isStackEmpty();
    }

    private boolean isStackEmpty() {
        return top == -1;
    }
}
