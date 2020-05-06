package paypal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PaintingBuildingsFinal {
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

            List<Integer> costs = new ArrayList<>();
            mapAllPossibleSequences1(paintOnBuildings, costOfBuildings, k1, numberOfColours, 0, "", costs, 0);
            if(costs.size() == 0)
                System.out.println(-1);
            else {
                int cos = costs.stream().map(value -> value.intValue()).min(Comparator.naturalOrder()).get();
                System.out.println(cos);
            }

        }

    }

    private static int[] getPaintsOnBuildingInINteger(String[] paintsOnBuildngInString) {
        int arr[] = new int[paintsOnBuildngInString.length];
        for (int i = 0; i < paintsOnBuildngInString.length; i++) {
            arr[i] = Integer.parseInt(paintsOnBuildngInString[i]);
        }
        return arr;
    }

    private static void mapAllPossibleSequences1(int[] paintOnBuildings, int[][] costOfBuildings, int k,
                                                 int numberOfColors, int position, String value, List<Integer> result, int sum) {
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

    private static boolean isValueLastElementNotEqual(String value, int paintOnBuilding) {
        char lastColor = value.charAt(value.length()-1);
        int colorValue = Character.getNumericValue(lastColor);
        return colorValue != paintOnBuilding;
    }
}


