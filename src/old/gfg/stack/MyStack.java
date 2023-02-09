package old.gfg.stack;

import old.utils.CommonUsedUtils;

public class MyStack {

	private int size;
	private int pos;
	private int arr[];
	public MyStack(int size){
		this.size = size;
		this.pos = -1;
		arr = new int[size];
	}
	public void push(int data){
		if(pos == size-1)
			System.out.println("old.Stack is overflow");
		else
			arr[++pos] = data;
	}

	public Integer pop(){
		if(pos == -1)
			System.out.println("old.Stack is underflow");
		else{
				return arr[pos--];
		}
		return null;
	}

  public static void main(String[] args) {
	  MyStack myStack = new MyStack(4);
	  myStack.push(1);
	  myStack.push(2);
	  myStack.push(3);
	  CommonUsedUtils.displayArray(myStack.arr);
	  myStack.pop();
	  CommonUsedUtils.displayArray(myStack.arr);
	  myStack.pop();
	  CommonUsedUtils.displayArray(myStack.arr);
	  myStack.push(4);
	  CommonUsedUtils.displayArray(myStack.arr);
	  myStack.push(5);
	  CommonUsedUtils.displayArray(myStack.arr);
	  myStack.push(6);
	  CommonUsedUtils.displayArray(myStack.arr);
	  myStack.push(8);
	  CommonUsedUtils.displayArray(myStack.arr);
	  myStack.pop();
	  CommonUsedUtils.displayArray(myStack.arr);
	  myStack.pop();
	  CommonUsedUtils.displayArray(myStack.arr);
	  myStack.pop();
	  myStack.pop();
	  myStack.pop();
	  myStack.pop();

  }
}
