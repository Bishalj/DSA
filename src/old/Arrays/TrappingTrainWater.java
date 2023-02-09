package old.Arrays;

public class TrappingTrainWater {
    public static void main(String[] args) {
        int arr[] = {10, 0, 20, 30, 1, 2, 33, 1, 0 ,1};
        System.out.println(getTheTrappedWaterQuantity(arr, arr.length));
    }

    private static int getTheTrappedWaterQuantity(int[] arr, int n) {

        int leftMaximumPosition = 0, rightMaximumPosition = n -1, amountOfWaterStored = 0;
        int loop_counter = 0;
        for(int leftIndex =0, rightIndex = n-1; leftIndex < rightIndex;){

            loop_counter ++;
            System.out.println("looping for : " + loop_counter);

            if(arr[leftMaximumPosition] >= arr[rightMaximumPosition]){
                int previousRightPosition = rightMaximumPosition;
                int currentRightPosition = --rightIndex;
                if(arr[previousRightPosition] > arr[currentRightPosition])
                    amountOfWaterStored += arr[previousRightPosition] - arr[currentRightPosition];
                else
                    rightMaximumPosition =  currentRightPosition;
            }else{
                int previousLeftPosition = leftMaximumPosition;
                int currentLeftPosition = leftIndex++;
                if(arr[previousLeftPosition] > arr[currentLeftPosition])
                    amountOfWaterStored += arr[previousLeftPosition] - arr[currentLeftPosition];
                else
                    leftMaximumPosition =  currentLeftPosition;
            }
        }
        return amountOfWaterStored;
    }
}
