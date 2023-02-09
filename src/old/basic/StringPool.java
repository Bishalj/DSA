package old.basic;

public class StringPool {
    public static void main(String[] args) {
        String a = "bishal";
        String b = "bishal";
        System.out.println(a==b);

        b = "jaiswal";
        String c = "bishal";
        System.out.println(a==b);
        System.out.println(a==c);

        String d = new String("bishal");

        System.out.println(a == d);

        d = d.intern();
        System.out.println(a == d);

        Double a1 = 1.0;
        Double a2 = new Double(1.0);
        Double a3 = 1.0;
        System.out.println(a2 == a1);
        System.out.println(a3 == a1);
        System.out.println(a1.equals(a3));

    }
}
