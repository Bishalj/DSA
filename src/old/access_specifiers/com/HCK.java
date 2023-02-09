package old.access_specifiers.com;

import java.util.*;

public class HCK {

    public static void main(String[] args) {
        int i = 010; // read
        int j = 07;
        System.out.println(i);
        System.out.println(j);
        int mask = 0x000F;
        int value = 0x2222;
        System.out.println(value & mask);
        Parser parser = new Parser();
        System.out.println(parser.isBalanced("({()})"));

        try{
            Float f = new Float(3.0);
            int x = f.intValue();
            byte y = f.byteValue();
            double z = f.doubleValue();
            System.out.println(x + y + z);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(2);
        l.add(2);
        l.add(3);
        l.add(3);
        l.add(3);
        l.add(3);

        System.out.println(longestSubarray(l));
        List<String> dictionary = new ArrayList<>();
        List<String> query = new ArrayList<>();
        dictionary.add("heater");
        dictionary.add("cold");
        dictionary.add("clod");
        dictionary.add("reheat");
        dictionary.add("docl");

        query.add("codl");
        query.add("heater");
        query.add("abcd");
        System.out.println(stringAnagram(dictionary, query).toString());
    }

    public static int longestSubarray(List<Integer> arr) {
        // Write your code here
        if(arr.size() < 2)
            return arr.size();
        int longestLength = 1;
        int maxLongestLength = 1;
        int frontIndex = 0;
        int rearIndex = 1;
        boolean negativeFlag = true;
        boolean positiveFlag = true;
        while(rearIndex < arr.size()){
            if(arr.get(frontIndex) == arr.get(rearIndex)){
                frontIndex = rearIndex;
                rearIndex++;
                longestLength++;
            }else if(positiveFlag && arr.get(frontIndex) - arr.get(rearIndex) == 1){
                rearIndex++;
                longestLength++;
                negativeFlag = false;
            }else if(negativeFlag && arr.get(frontIndex) - arr.get(rearIndex) == -1){
            rearIndex++;
            longestLength++;
            positiveFlag = false;
            }
            else {
                if(longestLength > maxLongestLength)
                    maxLongestLength = longestLength;

                if(Math.abs(arr.get(rearIndex) - arr.get(frontIndex + 1)) <= 1){
                    if(arr.get(rearIndex) - arr.get(frontIndex + 1) == 1){
                        positiveFlag = false;
                        negativeFlag = true;
                    }else if(arr.get(rearIndex) - arr.get(frontIndex + 1)  == -1){
                        positiveFlag = true;
                        negativeFlag = false;
                    }

                    longestLength = rearIndex - frontIndex;
                    if(arr.get(rearIndex) - arr.get(frontIndex + 1) == 0) {
                        frontIndex = rearIndex;
                        positiveFlag = true;
                        negativeFlag = true;
                    }
                    else
                        frontIndex++;
                    rearIndex++;
                } else{
                    longestLength = 1;
                    frontIndex = rearIndex;
                    rearIndex++;
                }
            }

        }
        if(longestLength > maxLongestLength)
            maxLongestLength = longestLength;
        return maxLongestLength;
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        int arr[]={
            5,71,79,19,2,83,31,43,11,53,37,23,41,3,13,73,101,17,29,7,59,47,61,97,89,67
        };
        // Write your code here
        List<Integer> anagramCounts = new ArrayList<>();
        HashMap<String, Integer> memoization = new HashMap<>();
        for(String aQuery: dictionary) {

        }

        for(String aQuery: query){
            if(memoization.get(aQuery) != null){
                anagramCounts.add(memoization.get(aQuery));
                continue;
            }
            int numberOfAnagrams = 0;
            Set<String> anagrams = new HashSet<>();
            for(String aDictionaryValue: dictionary){
                if(aDictionaryValue.length() != aQuery.length())
                    continue;
                else if(areStringValuesAnagram(aDictionaryValue, aQuery)) {
                    numberOfAnagrams++;
                    anagrams.add(aDictionaryValue);
                }
            }
            if(numberOfAnagrams != 0) {
                memoization.put(aQuery, numberOfAnagrams);
                anagrams.add(aQuery);
            }

            for (String value: anagrams)
                memoization.put(value, numberOfAnagrams);

            anagramCounts.add(numberOfAnagrams);
        }
        return anagramCounts;
    }

    private static boolean areStringValuesAnagram(String text1, String text2) {
        Map<Character, Integer> frequencyCountMap = getCharacterFrequencyCountMap(text1);
        for(int i=0; i<text2.length(); i++) {
            char character = text2.charAt(i);
            if(frequencyCountMap.containsKey(character)){
                if(frequencyCountMap.get(character) == 1)
                    frequencyCountMap.remove(character);
                else
                    frequencyCountMap.put(character, frequencyCountMap.get(character) - 1);
            }else
                return false;
        }

        return frequencyCountMap.isEmpty();
    }

    private static Map<Character, Integer> getCharacterFrequencyCountMap(String text) {
        Map<Character, Integer> frequencyCountMap = new HashMap<>();
        for(int i=0; i<text.length(); i++){
            char character = text.charAt(i);
            if(frequencyCountMap.get(character) == null){
                frequencyCountMap.put(character, 1);
            }else {
                frequencyCountMap.put(character, frequencyCountMap.get(character) + 1);
            }
        }
        return frequencyCountMap;
    }


}



class Parser{
    public  boolean isBalanced(String text){


        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<text.length(); i++){
            char character = text.charAt(i);
            if(stack.isEmpty() && (character == ']' || character == '}' || character == ')'))
                return false;
            else if(character == ']' && stack.pop() != '[')
                return false;
            else if(character == '}' && stack.pop() != '{')
                return false;
            else if(character == ')' && stack.pop() != '(')
                return false;
            else if(character != ')' && character != '}' && character != ']')
                stack.push(character);

        }
        if(stack.isEmpty() == false)
            return false;
        return true;
    }
}