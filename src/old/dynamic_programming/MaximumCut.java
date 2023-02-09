package old.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class MaximumCut {

    public static void main(String[] args) {
        int a=1;
        int b=2;
        int c=3;
        int n =5;
        System.out.println(getTheMaximumNumberOfCuts(a, b, c, n));
        System.out.println(getTheMaximumNumberOfCutsWithDP(a, b, c, n, new HashMap<>()));

        a=12;
        b=11;
        c=13;
        n =23;
        System.out.println(getTheMaximumNumberOfCuts(a, b, c, n));
        System.out.println(getTheMaximumNumberOfCutsWithDP(a, b, c, n, new HashMap<>()));

        a=2;
        b=4;
        c=2;
        n =3;
        System.out.println(getTheMaximumNumberOfCuts(a, b, c, n));
        System.out.println(getTheMaximumNumberOfCutsWithDP(a, b, c, n, new HashMap<>()));
    }

    private static int getTheMaximumNumberOfCuts(int a, int b, int c, int n) {
        if(n == 0)
            return 0;
        if(n < 0)
            return -1;

        int aCut = getTheMaximumNumberOfCuts(a, b, c, n-a);
        int bCut = getTheMaximumNumberOfCuts(a, b, c, n-b);
        int cCut = getTheMaximumNumberOfCuts(a, b, c, n-c);

        int result =  Math.max(Math.max(aCut, bCut), cCut);
        if(result == -1)
            return -1;
        return 1 + result;
    }

    private static int getTheMaximumNumberOfCutsWithDP(int a, int b, int c, int n, Map<Integer, Integer> ropeCutLengthMap) {
        if(n == 0)
            return 0;
        if(n < 0)
            return -1;

        int aCut = getRopeCut(a, b, c, n, a, ropeCutLengthMap);
        int bCut =  getRopeCut(a, b, c, n, b, ropeCutLengthMap);
        int cCut =  getRopeCut(a, b, c, n, c, ropeCutLengthMap);

        int result =  Math.max(Math.max(aCut, bCut), cCut);
        if(result == -1)
            return -1;
        return 1 + result;
    }

    private static int getRopeCut(int a, int b, int c, int n, int cutLength, Map<Integer, Integer> ropeCutLengthMap) {
        if(ropeCutLengthMap.containsKey(n-cutLength) == false) {
            int cutResult = getTheMaximumNumberOfCutsWithDP(a, b, c, n - cutLength, ropeCutLengthMap);
            ropeCutLengthMap.put(n - cutLength, cutResult);
            return cutResult;
        }

        return ropeCutLengthMap.get(n-cutLength);
    }
}
