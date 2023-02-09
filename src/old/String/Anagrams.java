package old.String;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {
        String str1 = "aabcd";
        String str2 = "abbcd";
        System.out.println(isBothTheStringsAreAnagrams(str1, str2));
    }

    private static boolean isBothTheStringsAreAnagrams(String str1, String str2) {

        if(str1.length() != str2.length())
            return false;

        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for(int i=0; i<str1.length(); i++){
            if(characterFrequencyMap.get(str1.charAt(i)) == null)
                characterFrequencyMap.put(str1.charAt(i), 1);
            else
                characterFrequencyMap.put(str1.charAt(i), characterFrequencyMap.get(str1.charAt(i)) + 1);
        }

        for(int i=0; i<str2.length(); i++){
            if(characterFrequencyMap.get(str2.charAt(i)) == null)
                return false;
            else {
                if(characterFrequencyMap.get(str2.charAt(i)) == 1)
                        characterFrequencyMap.remove(str2.charAt(i));
                else
                    characterFrequencyMap.put(str2.charAt(i), characterFrequencyMap.get(str2.charAt(i))-1);
            }
        }

        return characterFrequencyMap.size() == 0;

    }
}
