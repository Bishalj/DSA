package old.access_specifiers;

import old.access_specifiers.com.A;

public class B extends A {
    A a;

    public static void main(String[] args) {
        a();
        B b = new B();
        b.a();
    }
}
