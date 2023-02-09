package old.lambda.consumer;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerFunctionalInterface {

    public static void main(String[] args) {
        Consumer<Integer> consumer = (s) -> System.out.println(s);
        Consumer<Integer> consumer2 = (s) -> System.out.println("Consumenr 2:" + s);
        consumer = consumer.andThen(consumer2);
        consumer.accept(25);
        consumer.accept(35);
        Map<Integer, Integer> keyValueMap = new HashMap<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(3);
        ids.add(2);
        ids.add(2);
        ids.add(2);

        int m=2;
        for(int id: ids){
            if(keyValueMap.get(id) == null)
                keyValueMap.put(id, 1);
            else{
                keyValueMap.put(id,  keyValueMap.get(id)+1);
            }
        }

        Map<Integer, Integer> sortedValuesMap = getMapSortedByValue(keyValueMap);
        System.out.println("Hellp");

        Iterator<Map.Entry<Integer, Integer>> it = sortedValuesMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, Integer> data = it.next();
            if(data.getValue() <= m) {
                m -= data.getValue();
                it.remove();
            }else
                break;
        }
        if(sortedValuesMap == null)
            System.out.println(sortedValuesMap.size());
        System.out.println(sortedValuesMap.size());



        String s = "bxxb";

        Map<Integer, Integer> lengthFrequencyCountMap = getThePalindromeStringLengthAndFrequencyMap(s);
        List<Long> results = new ArrayList<>();
        List<Integer> lower = new ArrayList<>();
        List<Integer> upper = new ArrayList<>();
        for(int index =0; index<lower.size()&& index<upper.size(); index++){
            long count = 0;
            for(int j=lower.get(index); j<=upper.get(index); j++){
                if(lengthFrequencyCountMap.get(j) != null)
                    count += lengthFrequencyCountMap.get(j);
            }
            results.add(count);
        }

        System.out.println("");

    }

    private static Map<Integer, Integer> getThePalindromeStringLengthAndFrequencyMap(String s) {
        Map<Integer, Integer> lengthFrequencyCountMap = new HashMap<>();
        for(double index=0; index<s.length(); index += 0.5){
            double palindromeRadius = index - (int)index;
            double previousElement =  index -palindromeRadius;
            double nextElement =  index + palindromeRadius;
            while (isNextElementValid(s, nextElement) && isPreviousElementValid(previousElement) && areBothTheCharactersEqual(s, (int) previousElement, (int) nextElement)){
                String palindromeString = s.substring((int) previousElement, (int)nextElement+1);
                if(lengthFrequencyCountMap.get(palindromeString.length()) == null)
                    lengthFrequencyCountMap.put(palindromeString.length(), 1);
                else
                    lengthFrequencyCountMap.put(palindromeString.length(), lengthFrequencyCountMap.get(palindromeString.length()) + 1);

                palindromeRadius++;
                previousElement =  index -palindromeRadius;
                nextElement =  index + palindromeRadius;
            }
        }
        return lengthFrequencyCountMap;
    }

    private static boolean areBothTheCharactersEqual(String s, int previousElement, int nextElement) {
        return s.charAt(previousElement) == s.charAt(nextElement);
    }

    private static boolean isPreviousElementValid(double previousElement) {
        return previousElement >=0;
    }

    private static boolean isNextElementValid(String s, double nextElement) {
        return nextElement < s.length();
    }

    private static Map<Integer, Integer> getMapSortedByValue(Map<Integer, Integer> keyValueMap) {
        List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(keyValueMap.entrySet());
        Collections.sort(list, (map1, map2) -> map1.getValue().compareTo(map2.getValue()));
        Map<Integer, Integer> tempMap = new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> data: list){
            tempMap.put(data.getKey(), data.getValue());
        }
        return tempMap;
    }


}