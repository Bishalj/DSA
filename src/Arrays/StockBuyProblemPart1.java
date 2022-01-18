package Arrays;

public class StockBuyProblemPart1 {

    public static void main(String[] args) {
        int arr[] = {57,69,12,59,5,9,29,29,99};
        stockBuySell(arr, arr.length);
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

    static void stockBuySell(int price[], int n) {
        int boughtIndex = 0;
        int sellIndex = 0;
        for(int i=0; i<price.length-1;i++){
            if(price[i] < price[i+1])
                sellIndex++;
            else{
                if(price[i] != price[i+1]) {
                    if (boughtIndex != sellIndex)
                        System.out.print("(" + boughtIndex + " " + sellIndex + ") ");
                    boughtIndex = i + 1;
                    sellIndex = i + 1;
                }else{
                    sellIndex++;
                }
            }
        }

        if(boughtIndex != sellIndex)
            System.out.print("(" + boughtIndex + " " + sellIndex + ") ");

    }
}
