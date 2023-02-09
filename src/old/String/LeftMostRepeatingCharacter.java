package old.String;

import java.util.HashSet;
import java.util.Set;

public class LeftMostRepeatingCharacter {

    public static void main(String[] args) {
        String str1 = "abdrc";
        System.out.println(getTheLeftMostRepeatingCharacter(str1));
    }

    private static int getTheLeftMostRepeatingCharacter(String str1) {
        Set<Character> characterSet = new HashSet<>();
        int leftMostIndex = -1;
        for (int i = str1.length() - 1; i >=0; i--) {
            if(characterSet.contains(str1.charAt(i)))
                leftMostIndex = i+1;
            else
                characterSet.add(str1.charAt(i));
        }
        return leftMostIndex;
    }
}
