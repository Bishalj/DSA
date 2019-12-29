package recursion;

public class GeneratePowerSet {

    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("");
        for(int i=0; i<input.length(); i++)
            generatePowerSet(input.substring(i), 0, "");
    }

    private static void generatePowerSet(String input, int index, String currentString) {
        currentString = currentString + input.substring(index, index + 1);
        System.out.println(currentString);

        callRecursivelyForAllOptions(input, currentString, index);
    }

    private static void callRecursivelyForAllOptions(String input, String currentString, int index) {

        while (input.length() -1 != index){
            index++;
            generatePowerSet(input, index, currentString);
        }


    }

}
