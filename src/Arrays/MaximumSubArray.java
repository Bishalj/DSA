package Arrays;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;

public class MaximumSubArray {

    public static void main(String[] args) {
        System.out.println(Maximum("bcaadac", "abcabad"));
    }

    static int Maximum(String S, String T){

        final Map<Character, Integer> frequecyCountOfT = getFrequecyCountMap(T);
        int count = 0;
        for(int i=0; i<S.length()&& i < T.length(); i++){
            if(frequecyCountOfT.get(S.charAt(i)) == null || frequecyCountOfT.get(S.charAt(i)) == 0)
                continue;
            else{
                frequecyCountOfT.put(S.charAt(i), frequecyCountOfT.get(S.charAt(i)) - 1);
                count++;
            }
        }
        return count;
    }

    private static Map<Character, Integer> getFrequecyCountMap(String s) {
        Map<Character, Integer> frequencyCountMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(frequencyCountMap.get(s.charAt(i)) == null)
                frequencyCountMap.put(s.charAt(i), 1);
            else
                frequencyCountMap.put(s.charAt(i),frequencyCountMap.get(s.charAt(i)) + 1 );

        }
        return frequencyCountMap;
    }
}
