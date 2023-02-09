package old.String;

public class PermutationPatternOfAString {

    public static void main(String[] args) {
        String patternString = "bishal";
        String word = "ahis";
        System.out.println(isPatternStringExists(patternString, word));
    }

    private static boolean isPatternStringExists(String patternString, String word) {

        if(word.length() > patternString.length())
            return false;
        int characters[] = new int[256];
        for(int i=0; i< word.length(); i++)
            characters[word.charAt(i)]++;
        for (int i=0; i<word.length(); i++)
            characters[patternString.charAt(i)]--;

        if(isCharactersGreaterThanZero(characters))
            return true;

        for (int i = word.length(); i < patternString.length(); i++) {
            characters[patternString.charAt(i - word.length())]++;
            characters[patternString.charAt(i)]--;
            if(isCharactersGreaterThanZero(characters))
                return true;
        }
        return false;
    }

    private static boolean isCharactersGreaterThanZero(int[] characters) {
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] > 0)
                return false;
        }
        return true;
    }
}
