package old.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 4;
        String from = "A", to = "C", aux = "B";

        pothOfMovements(n, from, to, aux);


    }

    private static void pothOfMovements(int n, String from, String to, String aux) {
        if(n == 0)
            return;

        pothOfMovements(n-1, from, aux, to);
        System.out.println(from + " --> "+ to);
        pothOfMovements(n-1, aux, to, from);
    }
}
