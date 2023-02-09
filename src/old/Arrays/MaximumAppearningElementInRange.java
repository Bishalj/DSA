package old.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MaximumAppearningElementInRange {

    public static void main(String[] args) {
        int lower[] = {1,2,5,15};
        int upper[] = {5,8,7,18};
        System.out.println(getMaximumAppearingNumberWithinRange(lower, upper));
    }

    private static int getMaximumAppearingNumberWithinRange(int[] lower, int[] upper) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<lower.length; i++){
            IntStream.range(lower[i], upper[i] + 1)
                    .boxed()
                    .forEach(key -> {
                        increaseTheFrequencyOfKeyInMap(key, map);
                    });
        }

        return getTheMaximumFrequencyNumberFromMap(map);
    }

    private static void increaseTheFrequencyOfKeyInMap(Integer key, Map<Integer, Integer> map) {
        if(map.get(key) == null)
            map.put(key, 1);
        else
            map.put(key, map.get(key) + 1);
    }

    private static int getTheMaximumFrequencyNumberFromMap(Map<Integer, Integer> map) {
        int maxValue = Integer.MIN_VALUE;
        int maximumFrequencyElement = 0;
        for(Map.Entry<Integer, Integer> mapData: map.entrySet()){
            if(mapData.getValue() > maxValue){
                maxValue = mapData.getValue();
                maximumFrequencyElement = mapData.getKey();
            }
        }
        return maximumFrequencyElement;
    }


}
