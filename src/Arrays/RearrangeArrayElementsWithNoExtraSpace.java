package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RearrangeArrayElementsWithNoExtraSpace {

//    public static void main(String[] args) {
//        long arr[] = {5 ,0 ,3 ,7 ,1 ,4 ,6 ,2};
//        displayArray(arr);
//        rearrange(arr, arr.length);
//        displayArray(arr);
//    }
//
//    public static void rearrange(long arr[], int n){
//        long maximumElement = getMaximumElementInAnArray(arr, n) + 1;
//
//        System.out.println(maximumElement);
//        for(int i=0; i<n; i++)
//            arr[i] = arr[i] + ((arr[(int)arr[i]] % maximumElement) * maximumElement);
//
//        for (int i = 0; i <n ; i++) {
//            arr[i] /=maximumElement;
//
//        }
//    }
//
//    private static long getMaximumElementInAnArray(long[] arr, int n) {
//        long max = arr[0];
//        for(int i =1; i<n; i++) {
//            if (arr[i] > max)
//                max = arr[i];
//        }
//
//        return max;
//    }
//
//    private static void displayArray(long[] arr) {
//        for (long value : arr)
//            System.out.print(value+ " ");
//        System.out.println();
//    }

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  size = Integer.parseInt(br.readLine());
        for(int i=0; i<size; i++){

            int arraySize = Integer.parseInt(br.readLine());
            String arrayOne[] = br.readLine().split(" ");
            String arrayTwo[] = br.readLine().split(" ");
            HashMap<String, Integer> mapOne = new HashMap<String, Integer>();
            HashMap<String, Integer> mapTwo = new HashMap<String, Integer>();
            mapTheFrequencyOfEachElement(mapOne, arrayOne);
            mapTheFrequencyOfEachElement(mapTwo, arrayTwo);
            System.out.println("First---------------------------");
            int maxOne = getMaximumTotalWeightFromMap(mapOne);
            System.out.println("Second---------------------------");
            int maxTwo = getMaximumTotalWeightFromMap(mapTwo);
            System.out.println(maxOne == maxTwo ? "Tie" : maxOne > maxTwo ? "Rupam" : "Ankit");
        }

    }

    private static int getMaximumTotalWeightFromMap(HashMap<String, Integer> mapOne) {
        int totalMaximumWeight  = 0;
        int maxiCount  = 0;
        for (Map.Entry<String, Integer> mapObj: mapOne.entrySet()){

            if(mapObj.getValue() >=  maxiCount && mapObj.getValue() * Integer.parseInt(mapObj.getKey()) > totalMaximumWeight) {
                System.out.println("Key: " + mapObj.getKey() + " Value: "+mapObj.getValue());
                totalMaximumWeight = mapObj.getValue() * Integer.parseInt(mapObj.getKey());
                maxiCount = mapObj.getValue();
            }
        }
        return totalMaximumWeight;
    }

    public static void mapTheFrequencyOfEachElement(Map<String, Integer> map, String array[] ){
        for(String key : array){
            if(map.get(key) == null)
                map.put(key, 1);
            else
                map.put(key, map.get(key) + 1);
        }
    }

}
