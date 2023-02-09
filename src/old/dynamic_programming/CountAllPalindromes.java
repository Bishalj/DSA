package old.dynamic_programming;

public class CountAllPalindromes {

    public static void main(String[] args) {
        String ss = "aba";

        System.out.println(getTheCountOfAllPalindrome(ss, 0,ss.length()-1));
    }

    private static int getTheCountOfAllPalindrome(String ss, int start, int end) {
        int count = 0;
        if(start > end || end == ss.length())
            return 0;
        if(ss.charAt(start) == ss.charAt(end)){
            int includeCount =1 + getTheCountOfAllPalindrome(ss, start+1, end-1);
            int includeStartCount =getTheCountOfAllPalindrome(ss, start, end-1);
            int includeEndCount = getTheCountOfAllPalindrome(ss, start+1, end);
            count = Math.max(Math.max(includeCount, includeEndCount), includeStartCount);
        }

        int includeStartCount =getTheCountOfAllPalindrome(ss, start, end-1);
        int includeEndCount = getTheCountOfAllPalindrome(ss, start+1, end);

        return Math.max(Math.max(count, includeEndCount), includeStartCount);
    }
}
