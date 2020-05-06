package paypal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestString {

    public static void main(String[] args) throws IOException {

        char s1[] = "abagfiab".toCharArray();
        char s2[] = "cbacbcda".toCharArray();
        int queries = 4;
        for(int i=0; i<queries; i++){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String query[] = br.readLine().split(" ");
            int startIndex = Integer.parseInt(query[0]);
            int endIndex = Integer.parseInt(query[1]);
            if(s2[endIndex]< s2[startIndex] && s1[startIndex] > s2[endIndex]){
                char temp = s2[startIndex];
                s2[startIndex] = s2[endIndex];
                s2[endIndex] = temp;
            }
        }

        for (int i = 0; i < s1.length; i++) {
            if(s1[i] > s2[i])
                System.out.print(s2[i]);
            else
                System.out.print(s1[i]);
        }
        System.out.println();

    }
}
