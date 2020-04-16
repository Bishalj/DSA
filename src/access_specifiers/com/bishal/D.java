package access_specifiers.com.bishal;

import access_specifiers.com.A;

public class D extends A {
    public static void main(String[] args) {
        A a = new A();
        a.a();
//        a.b(); -> error
                a.c();
    }
}
