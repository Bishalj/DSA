package access_specifiers.com.bishal;

import access_specifiers.com.A;

import java.util.*;

public class D extends A {
    public static void main(String[] args) {
        A a = new A();
        a.a();
//        a.b(); -> error
        a.c();
        aa da = () -> {
                System.out.println("Bishal");
                return 1;
        };
        int data = da.aaa();
        System.out.println(data);
        Set s = new HashSet();
        Map<String, String> ddd = new LinkedHashMap<>();
//        List
    }
}

@FunctionalInterface
interface aa{
    int aaa();
}
