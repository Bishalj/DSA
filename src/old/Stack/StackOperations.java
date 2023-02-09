package old.Stack;


public class StackOperations {

    public static void main(String[] args) {
        Stack stack = new Stack(4);

        stack.push(1);
        stack.display();
        stack.push(2);
        stack.display();
        stack.push(3);
        stack.display();
        stack.push(4);
        stack.display();
        stack.peek();
        stack.push(5);
        stack.display();
        stack.increaseCapacity();
        stack.push(4);
        stack.display();
        stack.push(5);
        stack.display();
        stack.size();
        stack.push(6);
        stack.display();
        stack.peek();

        stack.pop();
        stack.display();
        stack.push(7);
        stack.display();

        stack.push(8);
        stack.display();
        stack.size();
        stack.push(9);
        stack.display();

        stack.pop();
        stack.display();
        stack.peek();

        stack.push(10);
        stack.display();

        stack.peek();

        stack.pop();
        stack.display();

        stack.size();
        stack.empty();

    }
}
