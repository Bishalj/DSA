package leetcode.september;

import java.util.Arrays;

public class LastTimeForGivenDigits {

    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        int firstValue = getTheFirstValue(A);
        if(firstValue == -1)
            return "";
        int secondValue = getTheSecondValue(A);
        return "";
    }

    private int getTheSecondValue(int[] a) {

        return 0;
    }

    private int getTheFirstValue(int[] a) {
        int first = -1;
        for(int i=0; i<a.length; i++){
            if(a[i] < 3 && a[i] >= 0 && a[i] > first) {
                first = a[i];
                a[i] = -1;
            }
        }
        return first;
    }
}

