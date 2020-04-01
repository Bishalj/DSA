package lambda.streams;

public class Java8Lambdas {
    static int a = 0;

    Java8Lambdas(int a){
        this.a=a;
    }
    public static void qwert(String[] args) {

        String a = "abc";
        String b = "asbc";
        String c = "abc";
        String d = new String("abc");
        d = "45";
        System.out.println(a==c);
        System.out.println(a==d);
    }

    @Override
    public String toString() {
        a= 8;
        qwert(new String[9]);
        return super.toString();
    }
}
