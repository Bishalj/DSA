package old.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        String from = "A", to = "C", aux = "B";

        pathOfMovements(n, from, aux, to);


    }

    private static void pothOfMovements(int n, String from, String to, String aux) {
        if(n == 0)
            return;

        pothOfMovements(n-1, from, aux, to);
        System.out.println(from + " --> "+ to);
        pothOfMovements(n-1, aux, to, from);
    }


    private static void pathOfMovements(int n, String a, String b, String c) {
        if(n == 0)
            return;

        pathOfMovements(n-1, a, c, b);
        System.out.println(a + " --> "+ c);
        pathOfMovements(n-1, b, a, c);
    }
}
