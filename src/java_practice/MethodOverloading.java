package java_practice;

public class MethodOverloading {



	void display(float a){
		System.out.println("Float: " + a);
	}

	void display(double a){
		System.out.println("Double: " + a);
	}

	void display(short a){
		System.out.println("Short: " + a);
	}


	void display(byte a){
		System.out.println("Byte: " + a);
	}


	void display(long a){
		System.out.println("Long: " + a);
	}

	void display(int a){
		System.out.println("Integer: " + a);
	}

	public static void main(String[] args) {
		MethodOverloading methodOverloading = new MethodOverloading();
		methodOverloading.display(1);
		methodOverloading.display(5);
		methodOverloading.display(1033);
		methodOverloading.display(1.0);
		methodOverloading.display(100.0f);
		methodOverloading.display(100000000000000L);
		methodOverloading.display(1033L);
	}
}
