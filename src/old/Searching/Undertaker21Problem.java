package old.Searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Undertaker21Problem {

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());                // Reading input from STDIN
        for(int i=0; i<numberOfTestCases; i++){
            int number = Integer.parseInt(br.readLine());
            if(isNumber21Present(number))
                System.out.println("The streak is broken!");
            else
                System.out.println("The streak lives still in our heart!");
        }


    }

    private static boolean isNumber21Present(int number) {
        boolean isDigitOneFound = false;
        if(number %21 == 0)
            return true;
        while (number > 0) {
            int digit = number % 10;
            number /= 10;
            if (digit == 1) {
                isDigitOneFound = true;
                continue;
            }
            if (isDigitOneFound && digit == 2)
                return true;

            isDigitOneFound = false;
        }
        return false;
    }
}
