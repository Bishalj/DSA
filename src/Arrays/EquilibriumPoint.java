package Arrays;


public class EquilibriumPoint {


    public static void main(String[] args) {
        long arr[] = {27,4,25,6,6,1,27,22,19,29,6,9,36,24,6,15,5};
        System.out.println(equilibriumPoint(arr, arr.length));
    }

    private static void displayArray(long[] arr) {
        for(long value: arr)
            System.out.print(value + " ");
        System.out.println();
    }

    public static int equilibriumPoint(long arr[], int n) {
        for(int i=1; i<arr.length; i++)
            arr[i] = arr[i] + arr[i-1];
        return getEquilibriumPointIndex(arr, n);
    }

    private static int getEquilibriumPointIndex(long summationArray[], int lengthOfArray) {
        long summationOfLeftPartOfEquilibrium = 0;
        for (int i=0; i<lengthOfArray; i++){

            if(i != 0)
                summationOfLeftPartOfEquilibrium = summationArray[i-1];


            if(summationOfLeftPartOfEquilibrium == summationArray[lengthOfArray - 1] - summationArray[i])
                return i+1;
        }
        return -1;
    }

}
