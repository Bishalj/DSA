package java_practice;

import java.util.ArrayList;
import java.util.List;

public class Generics {

	static <T extends Number, V extends Number> String  concat(T t, V v){
		return t + "" + v;
	}
	public static void main(String[] args) {
		GenericStack<Integer> genericStackInteger = new GenericStack<>();
		genericStackInteger.push(1);
		genericStackInteger.push(4);
		genericStackInteger.pop();
		genericStackInteger.peek();
		genericStackInteger.push(3);
		genericStackInteger.push(2);
		genericStackInteger.push(5);
		genericStackInteger.pop();
		genericStackInteger.pop();

		GenericStack<Double> genericStack = new GenericStack<>();
		genericStack.push(1.0);
		genericStack.push(4.0);
		genericStack.pop();
		genericStack.peek();
		genericStack.push(3.0);
		genericStack.push(2.0);
		genericStack.push(5.);
		genericStack.pop();
		genericStack.pop();

		System.out.println(genericStack.getHashCodeDifference(genericStackInteger));
		//error GenericStack<String> genericStacks = new GenericStack<>();

		System.out.println(concat(42, 54.04));

	}
}


class GenericStack<T extends Number>{
	private List<T> stack;
	public GenericStack(){
		stack = new ArrayList<T>();
	}

	public void push(T data){
		System.out.println("Add: " + data);
		stack.add(data);
	}

	public T pop(){

		T data = stack.remove(stack.size()-1);
		System.out.println("Pop: " + data);
		System.out.println("Stack: " + stack);
		return data;
	}

	public T peek(){
		return stack.get(stack.size()-1);
	}

	public int getHashCodeDifference(GenericStack<?> genericStack) {
		return this.hashCode() - genericStack.hashCode();
	}
}