package java_practice;

import old.access_specifiers.B;

public class Inheritance {
	public static void main(String[] args) {
		BInheritance bInheritance = new BInheritance();
		bInheritance.show();
	}
}


class A{
	int j=10;

	A(int tmp){
		System.out.println("A constructor: " + tmp);
	}
	public void show(){
		System.out.println(j);
	}
}

class BInheritance extends A {
	int j=5;
	BInheritance(){
		super(33);
		System.out.println("B constructor");
	}
	public void show(){
		System.out.println(super.j);
		super.show();
		System.out.println(j);
	}
}