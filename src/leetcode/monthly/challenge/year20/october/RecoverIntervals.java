//package leetcode.monthly.challenge.year20.october;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class RecoverIntervals {
//
//    public static void main(String[] args) {
//        int arr[][] = {
//                {2,3},
//                {1,4}
//        };
//        System.out.println(removeCoveredIntervals(arr));
//    }
//
//    public static int removeCoveredIntervals(int[][] intervals) {
//        Arrays.sort(intervals, (a,b) ->{
//            if(b[0] < a[0])
//                return 1;
//            else if(b[0] > a[0])
//                return -1;
//            else{
//                return b[1] > a[1] ? 1:-1;
//            }
//        });
//
//        int count = 1, i = 1;
//        while(i< intervals.length){
//
//            int j = i;
//            while(j < intervals.length && intervals[i-1][1] >= intervals[j][1])
//                j++;
//        if(j < intervals.length )
//            count++;
//          i=j+1;
//        }
//
//        return count;
//    }
//
//    public int findMinArrowShots(int[][] points) {
//        if(points.length == 0)
//            return 0;
//        Arrays.sort(points, (a,b) -> a[0] > b[0]?1:-1);
////        int count = 1, int endValue = points[0][1];
////        for(int i=1; i<points.length; i++){
////            if(points[i][0] >)
////        }
//    }
//
//    public List<String> findRepeatedDnaSequences(String s) {
//        Map<String, Integer> map = new HashMap<>();
//        for(int i=0; i<=s.length() - 10; i++){
//            String word = s.substring(i, i+10);
//            if(map.containsKey(word))
//                map.put(word, map.get(word) + 1);
//            else
//                map.put(word, 1);
//        }
//
//        return map
//                .entrySet()
//                .stream()
//                .filter(data -> data.getValue() >= 2)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//    }
//}
