package old.basic;

public class ClassFlow {

    static int b = 1;


    static {
        System.out.println("Static block");
        print1();
        System.out.println("static variable b: " + b);

    }


    ClassFlow(){
        System.out.println("Constructor");
    }

    int a = 1;
    {
        System.out.println("Initializer block");
        print2();
        System.out.println("non - static variable b: " + a);
    }

    private static void print1(){
        System.out.println("Static Method");
    }

    private void print2(){
        System.out.println("Non Static Method");
    }

    public static void main(String[] args) {
        ClassFlow classFlow = new ClassFlow();
    }
}

