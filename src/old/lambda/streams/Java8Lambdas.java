package old.lambda.streams;

import java.util.Comparator;

public class Java8Lambdas {
    static int a = 0;

    Java8Lambdas(int a){
        this.a=a;
    }
    public static void main(String[] args) {

        String a = "abc";
        String b = "asbc";
        String c = "abc";
        String d = new String("abc");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);

        Comparator<Integer> comparator = (a1, b1) ->   a1>b1 ? 1 : -1;
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ?1:-1;
            }
        };

    }

    @Override
    public String toString() {
        a= 8;
        main(new String[9]);
        return super.toString();
    }
}
