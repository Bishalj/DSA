package String;

public class RabinKarpAlgorithmToSearchPatternInAString {

    public static void main(String[] args) {
        String text = "abdabcbabc";
        String pattern = "abc";
        printIndexWherePatternExistsUsingRabinKarpAlgorithm(text, pattern);
    }

    /*
    * Algorithm Description
    *
    * 1. Calculate the value of weightedHashValue^(lengthOfText-1)%MODULUS_VALUE ==> h = d^(m-1)%q
    * 2. The above value is calculated because we need it in the formula
    *       t(i+1) = d(ti - text[i]*d^(m-1)%q) + text[i+m]
    * 3. Calculate the hash function value to the pattern and the first pattern.length -1 characters of text
    * 4. rum a loop from 0 - text.len - pattern.len - 1
    *       a. check the hash values
    *       b. if hash values are same then match all the characters of the string
    * 5. increment the value of the hash
    * */
    private static void printIndexWherePatternExistsUsingRabinKarpAlgorithm(String text, String pattern) {
        int lengthOfPattern = pattern.length();
        int lengthOfText = text.length();
        int weightedHashValue = 5;
        int MODULUS_VALUE = (int)Math.pow(10,9) + 7;
        int hashOfPattern = 0;
        int hashOfText = 0;
        //Step 1  & 2
        int h = 1;
        for (int i = 1; i <= pattern.length() - 1; i++)
            h = (h * weightedHashValue) % MODULUS_VALUE;

        //Step 3
        for (int i = 0; i < lengthOfPattern; i++) {
            hashOfPattern = ((hashOfPattern * weightedHashValue) + pattern.charAt(i)) % MODULUS_VALUE;
            hashOfText    = ((hashOfText * weightedHashValue)   + text.charAt(i)) % MODULUS_VALUE;
        }
//        System.out.println("Hash of Pattern " + hashOfPattern);

        //Step 4
        for (int i = 0; i < lengthOfText - lengthOfPattern + 1; i++) {
//            System.out.println("Hash of text: " + hashOfText);
            if(hashOfPattern == hashOfText) {
                boolean isPatternMatched = true;
                for (int j = 0; j < lengthOfPattern; j++) {
                    if (pattern.charAt(j) != text.charAt(i + j)) {
                        isPatternMatched = false;
                        break;
                    }
                }
                if (isPatternMatched)
                    System.out.println(i+1);
            }
                if(i<lengthOfText - lengthOfPattern)
                    hashOfText = (weightedHashValue * (hashOfText - (text.charAt(i)*h)) + text.charAt(i+lengthOfPattern)) % MODULUS_VALUE;
                if(hashOfText < 0)
                    hashOfPattern = hashOfText + MODULUS_VALUE;

        }

    }
}
