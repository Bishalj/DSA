package old.dynamic_programming;

public class EditDistance {

    public static void main(String[] args) {
        System.out.println(  1 + 2+ 3+"hello");
        String s1 = "ABC";
        String s2 = "ADCB";

        System.out.println(getTheEditDistance(s1, s2 ,s1.length(), s2.length()));
        System.out.println(getTheEditDistanceDynamicProgramming(s1, s2));
    }

    private static int getTheEditDistance(String s1, String s2, int length1, int length2) {

        if (length1 == 0)
            return length2;

        if (length2 == 0)
            return length1;


        if (s1.charAt(length1 - 1) == s2.charAt(length2 - 1))
            return getTheEditDistance(s1, s2, length1 - 1, length2 - 1);
        else {
            int insert = 1 + getTheEditDistance(s1, s2, length1, length2 - 1);
            int delete = 1 + getTheEditDistance(s1, s2, length1 - 1, length2);
            int replace = 1 + getTheEditDistance(s1, s2, length1 - 1, length2 - 1);

            return Math.min(Math.min(insert, delete), replace);
        }
    }

    private static int getTheEditDistanceDynamicProgramming(String s1, String s2) {
        int arr[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < arr.length; i++)
            arr[i][0] = i;
        for (int i = 1; i < arr[0].length; i++)
            arr[0][i] = i;


        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    arr[i][j] = arr[i - 1][j - 1];
                else {
                    int insert = arr[i][j - 1];
                    int delete = arr[i - 1][j];
                    int replace = arr[i - 1][j - 1];

                    arr[i][j] = 1 + Math.min(Math.min(insert, delete), replace);
                }
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }
}
