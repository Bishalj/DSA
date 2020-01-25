package String;

public class FindSubstringWithourRepeatingCharacters {

    public static void main(String[] args) {
        String actualString = "ABCDBAABCDC";
        String subString = "ABCD";
        System.out.println(getTheCountOfSubstringPresent(actualString, subString));
    }

    private static int getTheCountOfSubstringPresent(String actualString, String subString) {

        int i =0;
        int count = 0;
        while (i >= 0) {
            i = actualString.indexOf(subString, i);
            if (i != -1) {
                i += subString.length() - 1;
                count++;
            }

        }
        return count;
    }


}
