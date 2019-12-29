package Arrays;


public class EquilibriumPointWithoutArrayManipulation {


    public static void main(String[] args) {
        long arr[] = {4,2,-3,4,5, -4,4,10,-2};
        System.out.println(equilibriumPoint(arr, arr.length));
    }

    private static void displayArray(long[] arr) {
        for(long value: arr)
            System.out.print(value + " ");
        System.out.println();
    }

    public static int equilibriumPoint(long arr[], int n) {
        long sum = 0;
        for(int i=0; i<arr.length; i++)
            sum += arr[i];
        return getEquilibriumPointIndex(arr, n, sum);
    }

    private static int getEquilibriumPointIndex(long summationArray[], int lengthOfArray, long summationOfArrayValues) {
        long summationOfLeftPartOfEquilibrium = 0;
        for (int i=0; i<lengthOfArray; i++){

            if(summationOfArrayValues - summationOfLeftPartOfEquilibrium - summationArray[i] == summationOfLeftPartOfEquilibrium)
                return i+1;

            summationOfLeftPartOfEquilibrium += summationArray[i];
        }
        return -1;
    }

}
