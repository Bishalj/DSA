package Searching;

public class SquareRootInteger {

    public static void main(String[] args) {
        //suppose the array is infinite
        int actualSquareNumber = 146;
        int lowerBoundIndex = 0;
        int upperBoundIndex = actualSquareNumber - 1;
        System.out.println(getSquareRootOfTheNumber(actualSquareNumber, lowerBoundIndex, upperBoundIndex));
    }

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
         System.out.println("Middle Bound Index: " + middleIndex);
         if(middleIndex*middleIndex > actualSquareNumber)
             upperBoundIndex = upperBoundIndex - 1;
         return  upperBoundIndex;
    }
}
