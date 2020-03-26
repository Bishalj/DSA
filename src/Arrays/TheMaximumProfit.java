package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TheMaximumProfit {


    public static void main(String[] args)throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());
        for(int i=0; i<numberOfTestCases; i++) {
            String input[] = br.readLine().split(" ");
            int numberOfShop = Integer.parseInt(input[0]);
            int numberOfPerson = Integer.parseInt(input[1]);
            String costOfProductStringArray[] = br.readLine().split(" ");
            int costOfProductArray[] = Arrays.asList(costOfProductStringArray).stream().mapToInt(Integer::parseInt).toArray();

            int summationCostArray[] = getTheSummationCostArray(costOfProductArray);
//            Integer costPerPerson[] = new Integer[numberOfPerson];
            Set<Integer> costPerPersonSet = new TreeSet<>(Collections.reverseOrder());
            Map<Integer, Integer> shopVisitingFrequencyMap = new LinkedHashMap<>();
            for(int j=0; j<numberOfPerson; j++){
                String rangeStringArray[] = br.readLine().split(" ");
                int rangeIntegerArray[] = Arrays.asList(rangeStringArray).stream().mapToInt(Integer::parseInt).toArray();
                int costOfProducts = getTheCostOfProductForTheRange(summationCostArray, rangeIntegerArray);
//                costPerPerson[j] = costOfProducts;
                costPerPersonSet.add(costOfProducts);
                incrementTheFrequencyOfShopVisited(rangeIntegerArray, shopVisitingFrequencyMap);
            }
            int k = Integer.parseInt(br.readLine());

//            for(int j=0; j<costPerPerson.length; j++)
//                System.out.println(costPerPerson[j] + "");
//            System.out.println();

//            for(Map.Entry<Integer, Integer> mapValues: shopVisitingFrequencyMap.entrySet())
//                System.out.println("Shop " + mapValues.getKey() + ": " + mapValues.getValue());

//            int maximumSum = getTheMaxKSum(costPerPersonSet, k);
//            System.out.println("Maximum Sum: ");
//            Arrays.sort(costPerPerson, Collections.reverseOrder());

//            int summ = 0;
//            for(int ir=0; ir<k; ir++)
//                summ += costPerPerson[ir];
//            System.out.println(summ);

            System.out.println(getTheMaxKSum(costPerPersonSet,k));
            int maxVisitedShop = shopVisitingFrequencyMap
                    .entrySet()
                    .parallelStream()
                    .max((entry1, entry2) -> getAnInt(entry1, entry2))
                    .get()
                    .getKey();
//            System.out.println("Max Visited Shop is: ");
            System.out.println(maxVisitedShop);


        }

    }

    private static int getAnInt(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
        if(entry1.getValue() > entry2.getValue())
            return 1;
        else if(entry1.getValue() == entry2.getValue() && entry1.getKey() < entry2.getKey()){
            return 1;
        }else{
            return -1;
        }
    }

    private static int getTheMaxKSum(Set<Integer> costPerPersonSet, int k) {
        List<Integer> list = costPerPersonSet
                .parallelStream()
                .limit(k)
                .collect(Collectors.toList());
        return list
                .parallelStream()
                .mapToInt(i -> i)
                .sum();
    }

    private static void incrementTheFrequencyOfShopVisited(int[] rangeIntegerArray, Map<Integer, Integer> shopViisitingFrequencyMap) {
        for(int i=rangeIntegerArray[0]; i<=rangeIntegerArray[1]; i++){
            if(shopViisitingFrequencyMap.get(i) == null)
                shopViisitingFrequencyMap.put(i,1);
            else
                shopViisitingFrequencyMap.put(i, shopViisitingFrequencyMap.get(i)+1);
        }
    }

    private static int getTheCostOfProductForTheRange(int[] summationCostArray, int[] rangeIntegerArray) {
        int startCost = 0;
        int endCost = summationCostArray[rangeIntegerArray[1] - 1];
        if(rangeIntegerArray[0] > 1)
            startCost = summationCostArray[rangeIntegerArray[0] -2];

        return endCost - startCost;
    }

    private static int[] getTheSummationCostArray(int[] costOfProductArray) {
        int arr[] = new int[costOfProductArray.length];
        int sum = 0;
        for(int i=0; i<costOfProductArray.length; i++){
            sum = sum + costOfProductArray[i];
            arr[i] = sum;
        }
        return arr;
    }
}

