package String;

public class StringRotation {

    public static void main(String[] args) {
        String actualString = "ABAA";
        String rotatedString = "AAAB";
        System.out.println(isStringRotated(actualString, rotatedString));
    }

    private static boolean isStringRotated(String actualString, String rotatedString) {
        if(actualString.length() != rotatedString.length())
            return false;
        actualString = actualString + actualString;

        return actualString.indexOf(rotatedString) >= 0;
    }
}
