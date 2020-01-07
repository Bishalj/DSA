package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingInterval {

    public static void main(String[] args) {
        RangePairs<Integer, Integer>[] pairs = new RangePairs[7];

        RangePairs<Integer, Integer> rangePairs1 = new RangePairs<>(7,9);
        RangePairs<Integer, Integer> rangePairs2 = new RangePairs<>(6,10);
        RangePairs<Integer, Integer> rangePairs3 = new RangePairs<>(4,5);
        RangePairs<Integer, Integer> rangePairs4 = new RangePairs<>(1,3);
        RangePairs<Integer, Integer> rangePairs5 = new RangePairs<>(2,4);
        RangePairs<Integer, Integer> rangePairs6 = new RangePairs<>(13,15);
        RangePairs<Integer, Integer> rangePairs7 = new RangePairs<>(8,13);

        pairs[0] = rangePairs1;
        pairs[1] = rangePairs2;
        pairs[2] = rangePairs3;
        pairs[3] = rangePairs4;
        pairs[4] = rangePairs5;
        pairs[5] = rangePairs6;
        pairs[6] = rangePairs7;

        printTheRangePairs(pairs);
    }

    private static void printTheRangePairs(RangePairs<Integer, Integer>[] pairs) {
        Arrays.sort(pairs, new RangeComparator());

        int startRange = pairs[0].getStart();
        int endRange = pairs[0].getEnd();
        for(RangePairs<Integer, Integer> rangeValue : pairs){
            if(isNumberGreaterThanRange(endRange, rangeValue)) {
                System.out.print("{" + startRange + "," + endRange + "}, ");
                startRange = rangeValue.getStart();
                endRange = rangeValue.getEnd();
            }else if (isNumberWithinRange(endRange, rangeValue)){
                endRange = rangeValue.getEnd();
            }
        }
        System.out.print("{" + startRange + "," + endRange + "}");
    }

    private static boolean isNumberWithinRange(int endRange, RangePairs<Integer, Integer> rangeValue) {
        return endRange <= rangeValue.getEnd();
    }

    private static boolean isNumberGreaterThanRange(int endRange, RangePairs<Integer, Integer> rangeValue) {
        return endRange < rangeValue.getStart();
    }
}

class RangeComparator implements Comparator<RangePairs> {
    @Override
    public int compare(RangePairs o1, RangePairs o2) {
        return (int)((int)o1.getStart() - (int)o2.getStart());
    }
}

class RangePairs<T,S>{
    private T start;
    private S end;

    public RangePairs(T start, S end) {
        this.start = start;
        this.end = end;
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public S getEnd() {
        return end;
    }

    public void setEnd(S end) {
        this.end = end;
    }
}
