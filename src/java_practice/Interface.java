package java_practice;

import javax.swing.event.InternalFrameEvent;
import java.util.function.*;

public class Interface implements A1, A2, A3 /*multiple inheritance problem,A4,A5*/{
	public static void main(String[] args) {
		A2 in = new Interface();

		in.disp2();

		A3 a3 = new Interface();
		a3.disp2();
		a3.disp();
		System.out.println(concat.apply("234"));
		System.out.println(concat2.apply("234", "Hello"));
		int data  = supplier.get();
		if(predicate.test(data))
			intergerPrint.accept(data);

		System.out.println(convertIntToString.apply(data));

	}

	@Override
	public void disp2() {
		System.out.println("Inside Interface");
	}

	static UnaryOperator<String> concat = (a) -> a+" Bishal";
	static BinaryOperator<String> concat2 = (a, b) -> a + " " + b;
	static Consumer<Integer> intergerPrint = (a) -> System.out.println(a);
	static Supplier<Integer> supplier = () -> 11;
	static Predicate<Integer> predicate = (a) -> a==11;
	static Function<Integer, String> convertIntToString = (a) -> a + " Hello ";
}


interface A1{
	private void disp(){
		System.out.println("inside a1");
	}

	void disp2();
}

@FunctionalInterface
interface A2{
	int a = 9;
	default void disp(){
		System.out.println("inside a2");
	}

	default void disp3(){

	}

	void disp2();
}

interface A3 extends A2{
	int a = 20;
	default void disp(){
		A2.super.disp();
		System.out.println("inside a3");
	}

	default void disp3(){

	}

	void disp2();
}


interface A4{
	default void disp4(){
		System.out.println("inside a4");
	}
}


interface A5{
	default void disp4(){
		System.out.println("inside a5");
	}
}

// Mulitple inheritance