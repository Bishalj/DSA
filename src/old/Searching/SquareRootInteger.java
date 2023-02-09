package old.Searching;

public class SquareRootInteger {

    public static void main(String[] args) {
        int actualSquareNumber = 226;
        int lowerBoundIndex = 0;
        int upperBoundIndex = actualSquareNumber - 1;
        System.out.println("Square Root is: " + getSquareRootOfTheNumber(actualSquareNumber, lowerBoundIndex, upperBoundIndex));
    }

    //Time Complexity is BigO(Log(actualSquareNumber))
    private static int getSquareRootOfTheNumber(int actualSquareNumber, int lowerBoundIndex, int upperBoundIndex) {
        if(actualSquareNumber == 0 || actualSquareNumber == 1)
            return actualSquareNumber;
        int middleIndex = -1;
         while ( lowerBoundIndex < upperBoundIndex){
             middleIndex = (lowerBoundIndex + upperBoundIndex)/2;

             long generatedSquareNumber = middleIndex*middleIndex;
             if(generatedSquareNumber == actualSquareNumber)
                 return middleIndex;
             else if(generatedSquareNumber > actualSquareNumber)
                 upperBoundIndex = middleIndex - 1;
             else
                 lowerBoundIndex = middleIndex + 1;
         }
         System.out.println("lower Bound Index: " + lowerBoundIndex);
         System.out.println("Upper Bound Index: " + upperBoundIndex);
         System.out.println("Middle Bound Index before last run: " + middleIndex);
         middleIndex = (lowerBoundIndex + upperBoundIndex)/2;
         if(middleIndex*middleIndex > actualSquareNumber)
             middleIndex = middleIndex - 1;
         return  middleIndex;
    }
}
