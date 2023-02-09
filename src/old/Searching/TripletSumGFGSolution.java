package old.Searching;

public class TripletSumGFGSolution {

    public static void main(String[] args) {
        int array [] = {1, 3, 4, 8, 9, 20, 40} ;
        int tripletSummationNumber = 30;
        final int upperBoundIndex = array.length - 1;
        for(int i=0; i<array.length; i++){
            final int pairSumElementNeeded = tripletSummationNumber - array[i];
            final int lowerBoundIndex = i+1;
            if(isPairSumElementPresent(array, pairSumElementNeeded, lowerBoundIndex, upperBoundIndex)){
                System.out.println("Start Element: "+ array[i]);
                System.out.println("Yes");
                break;
            }
        }
    }

    private static boolean isPairSumElementPresent(int[] array, int pairSumElementNeeded, int lowerBoundIndex, int upperBoundIndex) {
        while(lowerBoundIndex < upperBoundIndex){
            int calculatedPairSum = array[lowerBoundIndex] + array[upperBoundIndex];
            if(calculatedPairSum == pairSumElementNeeded) {
                System.out.println("Middle Element: "+ array[lowerBoundIndex]);
                System.out.println("End Element: "+ array[upperBoundIndex]);
                return true;
            }
            else if(calculatedPairSum > pairSumElementNeeded)
                upperBoundIndex--;
            else
                lowerBoundIndex++;
        }
        return false;
    }
}
