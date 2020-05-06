package paypal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class PaintBuildings {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String details[] = br.readLine().split(" ");
            int n = Integer.parseInt(details[0]);
            int numberOfColours = Integer.parseInt(details[1]);
            int k1 = Integer.parseInt(details[2]);
            int paintOnBuildings[] = getPaintsOnBuildingInINteger(br.readLine().split(" "));

            int costOfBuildings[][] = new int[n][numberOfColours];
            for(int j=0; j<Integer.parseInt(details[0]); j++){
                String cost[] = br.readLine().split(" ");
                for(int k=0; k<Integer.parseInt(details[1]); k++){
                    costOfBuildings[j][k] = Integer.parseInt(cost[k]);
                }
            }

            ArrayList<String> possibleSequences = new ArrayList<>();
            mapAllPossibleSequences(paintOnBuildings, costOfBuildings, k1, numberOfColours, 0, "", possibleSequences);
            System.out.println(possibleSequences.toString());
            int minCost = getTheMinimumCost(possibleSequences, costOfBuildings);
            System.out.println(minCost);

            ArrayList<Integer> costs = new ArrayList<>();
            mapAllPossibleSequences1(paintOnBuildings, costOfBuildings, k1, numberOfColours, 0, "", costs, 0);
            System.out.println(costs.toString());
            if(costs.size() == 0)
                System.out.println(-1);
            else {
                int cos = costs.stream().map(value -> value.intValue()).min(Comparator.naturalOrder()).get();
                System.out.println(cos);
            }

        }

    }

    private static int getTheMinimumCost1(ArrayList<String> possibleSequences, int[][] costOfBuildings) {
        int minValue = Integer.MAX_VALUE;
        for(String sequence: possibleSequences){
            int tmpValue = 0;
            for (int i = 0; i < sequence.length(); i++) {
                tmpValue += costOfBuildings[i][Character.getNumericValue(sequence.charAt(i))-1];
            }
            if(tmpValue < minValue)
                minValue = tmpValue;
        }
        return minValue;
    }

    private static void mapAllPossibleSequences1(int[] paintOnBuildings, int[][] costOfBuildings, int k,
                                                int numberOfColors, int position, String value, ArrayList<Integer> result, int sum) {
        if(k==-1)
            return ;
        if(position == paintOnBuildings.length) {
            if(k==0)
                result.add(sum);
            return ;
        }

        if(paintOnBuildings[position] == 0){
            for (int i = 1; i <=numberOfColors; i++) {
                int cost = costOfBuildings[position][i-1];
                if(position == 0 || isValueLastElementNotEqual(value, i)) {
                    mapAllPossibleSequences1(paintOnBuildings, costOfBuildings, k - 1,
                            numberOfColors, position + 1, value + i, result, sum + cost);
                }
                else {
                    mapAllPossibleSequences1(paintOnBuildings, costOfBuildings, k,
                            numberOfColors, position + 1, value + i, result, sum + cost);
                }
            }
        }else{
            if(position == 0 || isValueLastElementNotEqual(value, paintOnBuildings[position]))
                k = k-1;

            mapAllPossibleSequences1(paintOnBuildings, costOfBuildings, k,
                    numberOfColors, position + 1, value + paintOnBuildings[position], result, sum );
        }
        return;
    }

    private static int getTheMinimumCost(ArrayList<String> possibleSequences, int[][] costOfBuildings) {
        int minValue = Integer.MAX_VALUE;
        for(String sequence: possibleSequences){
            int tmpValue = 0;
            for (int i = 0; i < sequence.length(); i++) {
                tmpValue += costOfBuildings[i][Character.getNumericValue(sequence.charAt(i))-1];
            }
            if(tmpValue < minValue)
                minValue = tmpValue;
        }
        return minValue;
    }

    private static void mapAllPossibleSequences(int[] paintOnBuildings, int[][] costOfBuildings, int k,
                                                int numberOfColors, int position, String value, ArrayList<String> result) {
        if(k==-1)
            return;
        if(position == paintOnBuildings.length) {
            if(k==0)
                result.add(value);
            return;
        }

        if(paintOnBuildings[position] == 0){
            for (int i = 1; i <=numberOfColors; i++) {
                if(position == 0 || isValueLastElementNotEqual(value, i))
                    mapAllPossibleSequences(paintOnBuildings, costOfBuildings, k-1,
                            numberOfColors, position+1, value + i, result);
                else
                    mapAllPossibleSequences(paintOnBuildings, costOfBuildings, k,
                            numberOfColors, position+1, value + i, result);
            }
        }else{
            if(position == 0 || isValueLastElementNotEqual(value, paintOnBuildings[position]))
                k = k-1;

            mapAllPossibleSequences(paintOnBuildings, costOfBuildings, k,
                    numberOfColors, position+1, value + paintOnBuildings[position], result);
        }
        return;
    }

    private static boolean isValueLastElementNotEqual(String value, int paintOnBuilding) {
        char lastColor = value.charAt(value.length()-1);
        int colorValue = Character.getNumericValue(lastColor);
        return colorValue != paintOnBuilding;
    }

    private static int[] getPaintsOnBuildingInINteger(String[] paintsOnBuildngInString) {
        int arr[] = new int[paintsOnBuildngInString.length];
        for (int i = 0; i < paintsOnBuildngInString.length; i++) {
            arr[i] = Integer.parseInt(paintsOnBuildngInString[i]);
        }
        return arr;
    }

    public static int max(int a[][], int p, int k, String data[], int colour, int cc){

        if(k==0)
            return -1;
        if(p == data.length-1)
            return a[p][Integer.parseInt(data[p])-1];
        int min = Integer.MAX_VALUE;
        int tempMin = Integer.MAX_VALUE;
        for(int i=0; i<colour; i++){
            if(Integer.parseInt(data[p]) != 0){
                if(i+1 == cc){
                    tempMin = max(a,p+1,k,data,colour,i+1);
                    if(tempMin == -1)
                        continue;
                }else{
                    tempMin = max(a,p+1,k-1,data,colour,i+1);
                    if(tempMin == -1)
                        continue;
                }
            }else{
                if(i+1 == cc){
                    tempMin = max(a,p+1,k,data,colour,i+1);
                    if(tempMin == -1)
                        continue;
                }else{
                    tempMin = max(a,p+1,k-1,data,colour,i+1);
                    if(tempMin == -1)
                        continue;
                }
            }

            if(tempMin + a[p][i+1]  < min){
                min = tempMin + a[p][i+1];
                tempMin = 0;
            }
        }
        return min;
    }
}