//package Arrays;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import static java.util.stream.Collectors.toMap;
//
//public class CanYouSolveIt {
//
//    public static void main(String args[] ) throws Exception {
//        Map<String, Integer> map2 = new HashMap<>();
//        map2.put("2", 244);
//        map2.put("4", 41);
//        map2.put("1", 11);
//        map2.put("5", 55);
//        Map<String, Integer> mapreapeat = map2.entrySet()
//                .parallelStream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .collect(toMap(Map.Entry::getKey,
//                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numberOfTestCases = Integer.parseInt(br.readLine());
//        for(int i=0 ;i<numberOfTestCases; i++){
//            br.readLine();
//            int arr[] = getIntegerArray(br.readLine());
//            getTheMaximumDifference(arr);
//        }
//
//    }
//
//    private static int[] getIntegerArray(String readLine) {
//        String stringArray[] = readLine.split(" ");
//        int array[] = new int[stringArray.length];
//        int index = 0;
//        for(String value: stringArray)
//            array[index++] = Integer.parseInt(value);
//        return array;
//    }
//
//    private static int getTheMaximumDifference(int[] arr) {
//        int max = arr[0];int index = 0;
//        for(int i=1 ;i<arr.length; i++){
//            if(Math.abs(arr[i] - arr[0]) + i >= max) {
//                max = Math.abs(arr[i] - arr[0]) + i;
//                index = i;
//            }
//        }
//
//        for(int i=1; i<=index; i++){
//            if(Math.abs(arr[i] - arr[index]) + i > max )
//                max = Math.abs(arr[i] - arr[index]) + i;
//        }
//        return max;
//    }
//
//    public static String isPangram(List<String> pangram) {
//        // Write your code here
//        String result = pangram
//                .stream()
//                .map(data -> isStringPangram(data))
//                .map(flag ->  flag ? "1":"0")
//                .collect(Collectors.joining(""));
//
//
//    }
//
//    private static boolean isStringPangram(String data) {
//
//        return false;
//    }
//}
