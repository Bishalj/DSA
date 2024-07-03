package java_practice;

import java.util.Comparator;

public class LambdaExpression {
	public static void main(String[] args) {
		FormatData<String> stringFunction = (data) -> data.toLowerCase();
		System.out.println(stringFunction.format("qwertyukrFEEFEFEEFEewqdfghgfdsfghngfds"));

		FormatData<Integer> intFunction = (data) -> data*12;
		System.out.println(intFunction.format(12));
		executeLambda(stringFunction, "TEGECEFEF");
		executeLambda(intFunction, 11);
		Comparator<String> comparator = (a,b) -> b.compareTo(a);
		int num = 33;
		FormatData<Integer> intFun = (n) -> {
//			num++; error it only allows final
			return n*2;
		};
	}

	private static <T> void executeLambda(FormatData<T> func, T data){
		System.out.println(func.format(data));
	}
}



interface FormatData<T>{
	T format(T data);
}