package dynamic_programming;

import java.util.*;

public class CoinChange implements b{
    public static void main(String[] args) {
        b az = new CoinChange();
         az.display();
        Set<Integer> set = new HashSet<>();
        set.add(null);
        Map<Integer, Integer> map = new HashMap<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.values());
        list.sort((a, b) -> a.getValue() < b.getValue() ? 1 :-1);

        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getValue() < b.getValue() ? 1 :-1;
            }
        };
        Map<Integer, Integer> maps = new TreeMap(comparator);
        maps.putAll(map);

        Hashtable<String, String> h = new Hashtable<>();
        int a = 122;
        int b= 13456;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a);
        System.out.println(b);

        int coins[] = {1,2,3};
        int sum = 8;
        int arr[][] = new int[coins.length][sum+1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < sum + 1; j++) {
                arr[i][j] = -1;
            }
        }
        System.out.println(getTheNUmberOfPossibility(coins, coins.length, sum));
        System.out.println(getTheNUmberOfPossibilityV2(coins, 0, sum, arr));
        System.out.println(getTheNUmberOfPossibilityUsingMaps(coins, 0, sum, new HashMap<>())-1);
    }

    private static int getTheNUmberOfPossibility(int[] coins, int position, int sum) {
        if(sum == 0)
            return 1;

        if(position == 0)
            return 0;

        int result = getTheNUmberOfPossibility(coins, position-1, sum);
            if(coins[position-1] <= sum)
                result += getTheNUmberOfPossibility(coins, position, sum - coins[position-1]);

        return result;
    }

    private static int getTheNUmberOfPossibilityV2(int[] coins, int position, int sum, int arr[][]) {
        if(sum == 0)
            return 1;

        int count = 0;
        for (int i = position; i < coins.length; i++) {
            int leftSum = sum - coins[i];

            if(leftSum >= 0) {
                int possibility = 0;
                if(arr[i][leftSum] == -1) {
                    possibility = getTheNUmberOfPossibilityV2(coins, i, sum - coins[i], arr);
                    arr[i][leftSum] = possibility;
                }else {
                    possibility = arr[i][leftSum];
                }
                count += possibility;

            }

        }

        return count;
    }

    private static int getTheNUmberOfPossibilityUsingMaps(int[] coins, int position, int sum, Map<Integer, Integer> remainingSumLengthMap) {
        if(sum == 0)
            return 0;

        if(sum < 0)
            return -1;

        if(position == coins.length)
            return -1;

        Integer inclusiveLength = remainingSumLengthMap.get(sum - coins[position])
                , exclusiveLength = remainingSumLengthMap.get(sum);
        if(inclusiveLength == null) {
            inclusiveLength = getTheNUmberOfPossibilityUsingMaps(coins, position, sum - coins[position], remainingSumLengthMap);
            remainingSumLengthMap.put(sum - coins[position], inclusiveLength);
        }

        if(exclusiveLength == null) {
            exclusiveLength = getTheNUmberOfPossibilityUsingMaps(coins, position+1, sum, remainingSumLengthMap);
            remainingSumLengthMap.put(sum, exclusiveLength);
        }

        if(inclusiveLength == null && exclusiveLength == null)
            return -1;
        return 1 + Math.min(inclusiveLength, exclusiveLength);

    }

}

interface  b{
    default void display(){
        System.out.println("inside b");
    }
}