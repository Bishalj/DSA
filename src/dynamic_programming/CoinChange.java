package dynamic_programming;

public class CoinChange {

    public static void main(String[] args) {


        int coins[] = {1,2,3};
        int sum = 4;
        int arr[][] = new int[coins.length][sum+1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < sum + 1; j++) {
                arr[i][j] = -1;
            }
        }
        System.out.println(getTheNUmberOfPossibility(coins, coins.length, sum));
        System.out.println(getTheNUmberOfPossibilityV2(coins, 0, sum, arr));
    }

    private static int getTheNUmberOfPossibility(int[] coins, int position, int sum) {
        if(sum == 0)
            return 1;

        if(position == 0)
            return 0;

        int result = getTheNUmberOfPossibility(coins, position-1, sum);
            if(coins[position-1] <= sum)
                result += getTheNUmberOfPossibility(coins, position, sum - coins[position-1]);

        return result;
    }

    private static int getTheNUmberOfPossibilityV2(int[] coins, int position, int sum, int arr[][]) {
        if(sum == 0)
            return 1;

        int count = 0;
        for (int i = position; i < coins.length; i++) {
            int leftSum = sum - coins[i];

            if(leftSum >= 0) {
                int possibility = 0;
                if(arr[i][leftSum] == -1) {
                    possibility = getTheNUmberOfPossibilityV2(coins, i, sum - coins[i], arr);
                    arr[i][leftSum] = possibility;
                }else {
                    possibility = arr[i][leftSum];
                }
                count += possibility;

            }

        }

        return count;
    }

}
