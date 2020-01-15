package Arrays;

public class KadaneAlgorithmOptimised {

    public static void main(String[] args) {
        int array[] = {-80,-25,77,-76,95,82,5,89,-20,-36,-22,-71,-80,37};
        System.out.println(getContiguousArrayMaximumSum(array, array.length));
    }

    private static int getContiguousArrayMaximumSum(int[] array, int n) {
        int max_summation_value = array[0];
        int count_of_summation_value = 0;

        for(int i=0; i<n; i++){
            count_of_summation_value = count_of_summation_value + array[i];

            if (count_of_summation_value > max_summation_value)
                max_summation_value = count_of_summation_value;
            if(count_of_summation_value < 0){
                count_of_summation_value = 0;
            }
        }
        return max_summation_value;
    }
}
