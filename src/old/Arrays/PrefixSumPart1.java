package old.Arrays;


public class PrefixSumPart1 {

    static  int  summationArray[];
    static {
        int arr[] = {7,-6,-4,2,20,-1,0,7};
        storeSummationOfValuesInArray(arr);
    }

    private static void storeSummationOfValuesInArray(int[] arr) {
        summationArray = new int[arr.length];
        int sumOfArrayData = 0;
        for(int i=0; i<arr.length; i++){
            sumOfArrayData += arr[i];
            summationArray[i] = sumOfArrayData;
        }
    }

    public static void main(String[] args) {
        int startRange = 3;
        int endRange = 7;
        System.out.println(getSummationOfArrayDataBetweenTheRanges(startRange, endRange));

    }

    private static int getSummationOfArrayDataBetweenTheRanges(int startRange, int endRange) {
        for(int data : summationArray)
            System.out.print(data + " ");
        System.out.println();
        int previousIndexValue = 0;
        if(startRange > 0)
            previousIndexValue = summationArray[startRange -1];

        return summationArray[endRange] - previousIndexValue;
    }

}
