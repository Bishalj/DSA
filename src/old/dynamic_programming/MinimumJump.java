package old.dynamic_programming;

public class MinimumJump {
    public static void main(String[] args) {
        int arr[] = {3,4,2,1,1};
        int arr2[] = {4,1,5,3,1,3,2,1,8};
        int position = 0;

        System.out.println(getTheMinimumNumberOfJumps(arr, position));
        int minJump[] = getTheMinJump(arr);
        System.out.println(getTheMinimumNumberOfJumps(arr, position, minJump));


        System.out.println(getTheMinimumNumberOfJumps(arr2, position));
        minJump = getTheMinJump(arr2);
        System.out.println(getTheMinimumNumberOfJumps(arr2, position, minJump));
    }

    private static int getTheMinimumNumberOfJumps(int[] arr, int position, int[] minJump) {

        int minNumberOfJumps = Integer.MAX_VALUE;
        for (int i = 1; i <=arr[position]; i++) {
            int currentJumpPosition = position + i;

            if(isPositionValid(currentJumpPosition, arr.length)){
                if(isPositionNotProcessedEarlier(minJump[currentJumpPosition], Integer.MAX_VALUE)) {
                    int numberOfJump = 1 + getTheMinimumNumberOfJumps(arr, currentJumpPosition, minJump);
                    minNumberOfJumps = Math.min(minNumberOfJumps, numberOfJump);
                }else{
                    minNumberOfJumps = 1 + minJump[currentJumpPosition];
                }
            }else
                break;
        }

        minJump[position] = minNumberOfJumps;
        return minNumberOfJumps;
    }

    private static boolean isPositionNotProcessedEarlier(int i, int maxValue) {
        return i == maxValue;
    }

    private static boolean isPositionValid(int currentJumpPosition, int length) {
        return currentJumpPosition < length;
    }

    private static int[] getTheMinJump(int[] arr) {
        int minJump[] = new int[arr.length];
        for (int i = 0; i <arr.length-1; i++) {
            minJump[i] = Integer.MAX_VALUE;
        }
        minJump[arr.length-1] = 0;
        return minJump;
    }

    private static int getTheMinimumNumberOfJumps(int[] arr, int position) {
        if(position == arr.length -1)
            return 0;

        int minNumberOfJumps = Integer.MAX_VALUE;
        for (int i = 1; i <=arr[position]; i++) {
            if(position+i < arr.length) {
                int numberOfJump = 1 + getTheMinimumNumberOfJumps(arr, position + i);
                minNumberOfJumps = Math.min(minNumberOfJumps, numberOfJump);
            }else
                break;
        }
        return minNumberOfJumps;
    }
}
