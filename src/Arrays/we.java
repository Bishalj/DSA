package Arrays;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++){
            int size = Integer.parseInt(br.readLine());
            int tmp[] = new int[size];
            String arr[] = br.readLine().split(" ");
            for(int j=0; j<arr.length; j++){
                int data = Integer.parseInt(arr[j]);
                if(isPrime(data))
                    tmp[j] = 1;
            }
            // br.readLine();
            int query = Integer.parseInt(br.readLine());
            for(int m=0; m<query; m++){
                String q[] = br.readLine().split(" ");
                if("A".equals(q[0])){
                    int start = Integer.parseInt(q[1])-1;
                    int end = Integer.parseInt(q[2])-1;
                    int nc = 0;
                    for(int t=start; t<=end; t++){
                        if(tmp[t-1] == 1)
                            nc++;
                    }
                    System.out.println(nc);
                }else{
                    int pos = Integer.parseInt(q[1]);
                    int value = Integer.parseInt(q[2]);
                    if(isPrime(value))
                        tmp[pos-1] = 1;
                }
            }
        }

    }

    private static boolean isPrime(int data){
        int count = 0;
        for(int k=1; k<=data; k++){
            if(data%k == 0)
                count++;
        }
        if(count == 2)
            return true;
        return false;
    }
}
