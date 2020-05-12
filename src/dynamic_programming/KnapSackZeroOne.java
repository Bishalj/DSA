package dynamic_programming;

import java.util.*;

public class KnapSackZeroOne {

    public static void main(String[] args) {

        int values [] = {10, 40, 30 ,50};
        int weight [] = {5, 4, 6 ,3};
        int totalWeight = 10;
        int position = 0;
        System.out.println(getTheMaximumValue(values, weight, totalWeight, position));

        int values2 [] = {60,100,120};
        int weight2 [] = {10,20,30};
        int totalWeight2 = 50;
        System.out.println(getTheMaximumValue(values2, weight2, totalWeight2, position));
        Long arr[] = {
                1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L
        };
        List<Long> l = new ArrayList<>();
        l = Arrays.asList(arr);
//        l.add(123l);
//        l.add(123l);
//        l.add(123l);
//        l.add(123l);
        System.out.println(countTripletss(l,1));
    }

    private static int getTheMaximumValue(int[] values, int[] weight, int totalWeight, int position) {
        if(position  == weight.length)
            return 0;

        if(weight[position] > totalWeight)
            return 0;

        int includingValue = values[position] + getTheMaximumValue(values, weight, totalWeight-weight[position], position+1);
        int excludingValue = getTheMaximumValue(values, weight, totalWeight, position+1);

        if(includingValue > excludingValue)
            return includingValue;
        return excludingValue;
    }

    static long countTriplets(List<Long> arr, long r) {
        arr.sort((a,b) -> a > b ? 1: -1);
        Long arra[] = (Long[]) arr.toArray();
        System.out.println(arr.toString());
        Map<Long, Integer> map = new LinkedHashMap<>();
        for (Long key : arr){
            if(map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }
        long count = 0l;
        double rLog = Math.log(r);
        for(Map.Entry<Long, Integer> data: map.entrySet()){
//            int n = (int) ((Math.log(data.getKey()) / rLog) + 1);
            long nextValue = (long) data.getKey() * r;
            long nextNextValue = (long)  data.getKey() * r * r;

            if (map.containsKey(nextNextValue) && map.containsKey(nextValue)) {
                long res = combination(data.getValue(), r)
                        * combination(map.get(nextNextValue),r)
                        * combination(map.get(nextValue), r);
                count += res;
            }
        }
        return count;
    }

    static long countTripletss(List<Long> arr, long r) {

        Map<Long, Integer> left = new HashMap<>(), right = new HashMap<>();

        long ans = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            long key = arr.get(i);
            if(right.containsKey(key))
                right.put(key, right.get(key) + 1);
            else
                right.put(key, 1);
        }

        for (int i = 0; i < n; i++) {

            Long c1 = 0L, c2 = 0L;

            if (arr.get(i) % r == 0){
                if(left.get(arr.get(i) / r)== null)
                    c1 = 0L;
                else
                    c1 = Long.valueOf(left.get(arr.get(i) / r));
            }


            long key = arr.get(i);

            right.computeIfPresent(arr.get(i), (keys, value) -> value -1);

            if(right.get(arr.get(i) * r) == null)
                c2 = 0L;
            else
                c2 = Long.valueOf(right.get(arr.get(i) * r));


            if(c1 != null && c2 != null)
            ans += c1 * c2;


            if(left.containsKey(key))
                left.put(key, left.get(key) + 1);
            else
                left.put(key, 1);
        }

        return ans;
    }
    static long combination(int n, long r){
        long comb = (long)factorial(n-(n-r)) / (factorial(r));
        return comb;
    }

    static int factorial(long n) {
        int fact = 1;
        int i = 1;
        while(i <= n) {
            fact *= i;
            i++;
        }
        return fact;
    }
}

