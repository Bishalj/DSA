package java_practice;

import java.util.Arrays;

public class ReduceUsage {
	public static void main(String[] args) {
		int arr[] = {1,4,2,4,1,35,2};
		System.out.println(Arrays.stream(arr).reduce(0, (a,b) -> a+b));
		Initialization initialization = new Initialization();
		var abs = "ewrw";
//		abs = 1; error
	}
}


class Initialization{

	public Initialization(){
		System.out.println("Inside constructor");
	}

	{
		System.out.println("Inside Initialization block");
	}
	static{
		System.out.println("Inside Static block");
	}

}
