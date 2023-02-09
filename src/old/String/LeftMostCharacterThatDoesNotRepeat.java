package old.String;


public class LeftMostCharacterThatDoesNotRepeat {

    public static void main(String[] args) {
        String word = "aadbbcc";
        System.out.println(getTheLeftMostCharacterIndexThatDoesNotRepeat(word));
    }

    private static int getTheLeftMostCharacterIndexThatDoesNotRepeat(String str1) {
        final Integer characterFrequesncy[] = new Integer[256];
        for (int i = 0; i < 256; i++) {
            characterFrequesncy[i] = -1;
        }
        int leftMostIndex = Integer.MAX_VALUE;
        for(int i=0; i<str1.length(); i++){
            if(characterFrequesncy[str1.charAt(i)] == -1)
                characterFrequesncy[str1.charAt(i)] = i;
            else
                characterFrequesncy[str1.charAt(i)] = -2;
        }

        boolean isNonRepeatedCharacterAvailable = false;
        for (int i = 0; i < 256; i++) {
            if(characterFrequesncy[i] > 0){
                if(leftMostIndex > characterFrequesncy[i]) {
                    leftMostIndex = characterFrequesncy[i];
                    isNonRepeatedCharacterAvailable = true;
                }
            }
        }
        if(!isNonRepeatedCharacterAvailable)
            return -1;
        return leftMostIndex;
    }
}
