package Arrays;

public class KadaneAlgorithm {

    public static void main(String[] args) {
        int array[] = {1,2,3,-2,-8,5, 7,-4,6,-1, 0,-3,2, -10, -10};
        System.out.println(getContiguousArrayMaximumSum(array));
    }

    private static int getContiguousArrayMaximumSum(int[] array) {
        int startIndex = 0;
        int endIndex = 0;
        int max_summation_value = array[startIndex];
        int count_of_summation_value = 0;

        while (endIndex < array.length){

            //If the first element is negative then you shouldn't consider it
            if(array[startIndex] <= 0){
                //having this condition if the maximum sum is -ve
                if(isValueGreaterThanMaximum(array[startIndex], max_summation_value))
                    max_summation_value = array[startIndex];

                //ignoring the negative value
                startIndex++;
                endIndex++;
            }
            else {

                //storing the maximum summation
                if(isValueGreaterThanMaximum(count_of_summation_value, max_summation_value))
                    max_summation_value = count_of_summation_value;


                count_of_summation_value += array[endIndex++];

                /*if the summation of the previous numbers are less than zero then
                you shouldn't consider it as it will decrease the sum*/
                if(isValueLessThanEqualToZero(count_of_summation_value)){
                    count_of_summation_value = 0;
                    startIndex = endIndex;
                }

            }
        }
        /*checking because if the last element is +ve and
             the summation is greater than the previous maximum element*/
        if(startIndex !=array.length && isValueGreaterThanMaximum(count_of_summation_value, max_summation_value))
            max_summation_value = count_of_summation_value;

        return max_summation_value;
    }

    private static boolean isValueLessThanEqualToZero(int count_of_summation_value) {
        return count_of_summation_value <= 0;
    }

    private static boolean isValueGreaterThanMaximum(int value, int max_summation_value) {
        return value > max_summation_value;
    }
}
