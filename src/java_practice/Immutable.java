package java_practice;

public class Immutable {

    public static void main(String[] args) {

        A a= new A(1,"bishal");
        System.out.println(a.getA1());
        System.out.println(a.getA2());
        a = new A(2, "adf");

        System.out.println(a.getA1());
        System.out.println(a.getA2());
    }
}


final class A{
    final private int a1;
    final private String a2;

    A(int a, String b){
        a1=a;
        a2=b;
    }

    public int getA1() {
        return a1;
    }

    public String getA2() {
        return a2;
    }
}