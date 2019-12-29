package Arrays;

public class StockBuyProblemPart1 {

    public static void main(String[] args) {
        int arr[] = {688,
                7369,
                7917,
                9917,
                6996,
                3324,
                7743,
                9470,
                2183,
                8490,
                5499,
                9772,
                6725,
                5644,
                5590,
                7505,
                8139,
                2954,
                9786,
                7669,
                8082,
                8542,
                8464,
                197,
                9507,
                9355,
                8804,
                6348,
                8611};
        getAllProfitsOfStock(arr, arr.length);
    }

    private static void getAllProfitsOfStock(int[] price, int n) {

        int max=0, min=0;
        boolean noProfitFlag = true;
        for(int i=1; i<n; i++){
            if(price[i] > price[max])
                max = i;
            else{
                if(isProfitAvailable(max, min)) {
                    noProfitFlag = false;
                    System.out.print("(" + min + " " + max + ") ");
                }
                min = max = i;
            }
        }
        if(isProfitAvailable(max,min))
            System.out.println("("+min+" "+max+") ");
        else if(noProfitFlag)
            System.out.println("No Profit");
    }

    private static boolean isProfitAvailable(int max, int min) {
        return max != min;
    }
}
