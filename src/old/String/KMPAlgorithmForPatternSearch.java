package old.String;

import old.utils.CommonUsedUtils;

public class KMPAlgorithmForPatternSearch {

    public static void main(String[] args) {
        String text = "aaabaaab";
        String pattern = "aaba";
        printTheIndexOfPatternFoundUsingKMPAlgorithm(text, pattern);
    }

    private static void printTheIndexOfPatternFoundUsingKMPAlgorithm(String text, String pattern) {
        System.out.println("------Text----------------------------------");
        System.out.println(text);
        System.out.println("------Pattern----------------------------------");
        System.out.println(pattern);
        int longestPrefixSufixArrayForPattern[] = LongestProperPrefxSuffix.getTheLongestProperPrefixSuffixArray(pattern);
        System.out.println("------LPS array of pattern----------------------------------");
        CommonUsedUtils.displayArray(longestPrefixSufixArrayForPattern);
        System.out.println("------Pattern matched Index----------------------------------");
        int textIndex = 0;
        int patternIndex = 0;
        while (textIndex < text.length()){
            if(text.charAt(textIndex) == pattern.charAt(patternIndex)){
                textIndex++;
                patternIndex++;
            }

            if(patternIndex == pattern.length()) {
                System.out.print(textIndex - patternIndex + " ");
                patternIndex = longestPrefixSufixArrayForPattern[patternIndex - 1];
            }else if( textIndex < text.length() && text.charAt(textIndex) != pattern.charAt(patternIndex)){
                if(patternIndex==0)
                    textIndex++;
                else
                    patternIndex = longestPrefixSufixArrayForPattern[patternIndex - 1];
            }
        }
    }
}
