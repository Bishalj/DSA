package java_practice;

public class ClassHierarcy {
	public static void main(String[] args) {

	}
}



class Outer{
	int a = 16;
	public static void display(){
		System.out.println("Outer static display method");
		Outer outer = (new Outer());
//		Outer.Inner.display();
	}

	private class Inner{
//		private static void display(){
//			System.out.println("Outer static display method : " + a);
//		}

		private void display2(){
			System.out.println("Outer static display method : " + a);
		}
	}
}