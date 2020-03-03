//package tree;
//
//import java.io.*;
//import java.util.*;
//
//public class TestClass {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter wr = new PrintWriter(System.out);
//        int T = Integer.parseInt(br.readLine().trim());
//        for(int t_i=0; t_i<T; t_i++)
//        {
//            String[] strNums = br.readLine().split(" ");
//            int rows = Integer.parseInt(strNums[0]);
//            int cols = Integer.parseInt(strNums[1]);
//            int threshold = Integer.parseInt(strNums[2]);
//            int[][] initThickness = new int[rows][cols];
//            for(int i_initThickness=0; i_initThickness<rows; i_initThickness++)
//            {
//                String[] arr_initThickness = br.readLine().split(" ");
//                for(int j_initThickness=0; j_initThickness<arr_initThickness.length; j_initThickness++)
//                {
//                    initThickness[i_initThickness][j_initThickness] = Integer.parseInt(arr_initThickness[j_initThickness]);
//                }
//            }
//            long[][] rate = new long[rows][cols];
//            for(int i_rate=0; i_rate<rows; i_rate++)
//            {
//                String[] arr_rate = br.readLine().split(" ");
//                for(int j_rate=0; j_rate<arr_rate.length; j_rate++)
//                {
//                    rate[i_rate][j_rate] = Long.parseLong(arr_rate[j_rate]);
//                }
//            }
//
//            String out_ = mazeTraveller(threshold, initThickness, rate, rows, cols);
//            System.out.println(out_);
//        }
//
//        wr.close();
//        br.close();
//    }
//    static String mazeTraveller(int threshold, int[][] initThickness, long[][] rate, int rows, int cols){
//        // Write your code here
//        return mazeTraveller1(threshold, initThickness, rate, rows, cols) ? "YES": "NO";
//
//    }
//
//    static boolean mazeTraveller1(int threshold, int[][] initThickness, long[][] rate, int rows, int cols){
//        if(rows+1 == initThickness.length && cols+1 == initThickness[0].length)
//            return true;
//
//        int counter = 0;
//        if(rows > cols)
//            counter = rows;
//        else
//            counter = cols;
//
//        if((counter * initThickness[rows][cols] ) + rate[rows][cols] > threshold)
//            return false;
//
//        return mazeTraveller1(threshold, initThickness, rate, rows + 1, cols) || mazeTraveller1(threshold, initThickness, rate, rows, cols + 1);;
//    }
//}