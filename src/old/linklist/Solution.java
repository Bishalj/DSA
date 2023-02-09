package old.linklist;

import java.io.*;
import java.util.*;
import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getShrunkArray' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY inputArray
     *  2. INTEGER burstLength
     */

    public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        List<String> results = new ArrayList<String>();
        Map<String, Integer> frequencyCountMap = new HashMap<>();
        for(String text: inputArray){
            String character = text;
            if(frequencyCountMap.get(character) == null){
                frequencyCountMap.put(character, 1);
                System.out.println("Key: "+ character + " , Value: " + frequencyCountMap.get(character));
            }
            else{
                frequencyCountMap.put(character, frequencyCountMap.get(character) + 1);
                System.out.println("Key: "+ character + " , Value: " + frequencyCountMap.get(character));
            }

        }
        String resultString = "";
        for(String text: inputArray){
            Integer frequencyOfElement = frequencyCountMap.get(text);
            if(frequencyOfElement < burstLength)
                resultString += text;
        }
        results.add(resultString);
        return results;

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int inputArrayCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> inputArray = IntStream.range(0, inputArrayCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int burstLength = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.getShrunkArray(inputArray, burstLength);
        System.out.println(result.toString());
//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
