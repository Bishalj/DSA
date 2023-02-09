package old.access_specifiers.com.bishal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiply {
    public static void main(String[] args)throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data[] = reader.readLine().split(",");
        int firstElement = Integer.parseInt(data[0].substring(1));
        String last = data[data.length-1];
        int lastElement = Integer.parseInt(last.substring(0,last.length()-1));
        firstElement *= lastElement;
        for (int i = 1; i < data.length-1; i++) {
            firstElement *= Integer.parseInt(data[i]);

        }
        System.out.println(firstElement);

    }
}
