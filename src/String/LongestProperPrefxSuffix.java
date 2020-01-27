package String;

public class LongestProperPrefxSuffix {

    public static void main(String[] args) {
        String text = "abcdabca";
        displayArray(getTheLongestProperPrefixSuffixArray(text));
    }

    private static void displayArray(int[] longestProperPrefixSuffixArray) {
        for (int value :
                longestProperPrefixSuffixArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int[] getTheLongestProperPrefixSuffixArray(String text) {
        int longestProperPrefixSuffixArray[] = new int[text.length()];
        int startIndex = 0;
        int endIndex = 1;
        longestProperPrefixSuffixArray[startIndex] = 0;
        while (endIndex < text.length()){
            if (text.charAt(longestProperPrefixSuffixArray[endIndex - 1]) == text.charAt(endIndex))
                longestProperPrefixSuffixArray[endIndex] = longestProperPrefixSuffixArray[endIndex - 1] + 1;
            else if (text.charAt(startIndex) == text.charAt(endIndex))
                longestProperPrefixSuffixArray[endIndex] = 1;
            else
                longestProperPrefixSuffixArray[endIndex] = 0;
            endIndex++;
        }
        return longestProperPrefixSuffixArray;
    }

}
