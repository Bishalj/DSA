package String;

public class RankOfAWord {
    public static void main(String[] args) {
        String word = "STRING";
        System.out.println(getRankOfTheWord(word));
    }
    int character[] = new int[256];
    private static int getRankOfTheWord(String word) {

        //Increment the frequency of letters in a word
        int character[] = new int[256];
        for (int i = 0; i < word.length(); i++)
            character[word.charAt(i)]++;


        //cumulative count to know how many characters are smaller than the given character
        for (int i = 1; i < 256; i++)
            character[i] = character[i] + character[i-1];

        //maximum number of permutation can happen
        int maximumFactirial = getFactorial(word.length());
        int rankOfAWord = 0;
        //calculate the rank
        for (int i=0; i< word.length(); i++){
            int numberOfCharacterSmaller = character[word.charAt(i)-1];
            maximumFactirial = maximumFactirial / (word.length()-i);
            rankOfAWord = rankOfAWord + numberOfCharacterSmaller * maximumFactirial;

            //decrement the character frequency as a character is used up
            for (int j = word.charAt(i); j < 256; j++)
                character[j]--;
        }
        return rankOfAWord + 1;
    }

    private static int getFactorial(int length) {
        int fact = 1;
        for(int i = 2; i<=length; i++)
            fact *= i;
        return fact;
    }
}
