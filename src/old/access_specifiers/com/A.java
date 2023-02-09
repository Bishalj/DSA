package old.access_specifiers.com;

 public class A {
    protected static void a(){};

      static void b(){};

     public static void c(){};

     public static void main(String[] args) {
         String a = "a";
         String b = new String("a");
         b = b.intern();

         System.out.println(a==b);
     }
}
