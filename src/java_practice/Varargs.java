package java_practice;

import java.util.Arrays;

public class Varargs {

	public String method(String s, int ...data){
		return s + " " + Arrays.stream(data).reduce(0, (a,b) -> a+b);
	}

	public static void mixedVarargs(Object... args) {
		for (Object arg : args) {
			if (arg instanceof Integer) {
				System.out.println("Integer: " + arg);
			} else if (arg instanceof String) {
				System.out.println("String: " + arg);
			} else if (arg instanceof Double) {
				System.out.println("Double: " + arg);
			} else {
				System.out.println("Other type: " + arg);
			}
		}
	}


	public static void main(String[] args) {
		Varargs varargs = new Varargs();
		int arr[] = {12,24,5,6};
		System.out.println(varargs.method("Test", 1,23,3,4,6,7,8,8));
		System.out.println(varargs.method("Test2", arr));
		mixedVarargs(1, "hello", 3.14, "world", 2);
	}
}
