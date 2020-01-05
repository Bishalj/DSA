package Sorting;

public class UnionOfSortedArray {

    public static void main(String[] args) {
        int arrayOne[] = {1, 2, 3, 4, 5};
        int arrayTwo[] = {1,2,3};

        printDistinctElements(arrayOne, arrayTwo);
    }

    private static void printDistinctElements(int[] arrayOne, int[] arrayTwo) {

        int firstArrayIndex = 0, secondArrayIndex = 0;
        int previousIndexFirstArray = 0;
        int previousIndexSecondArray = 0;

        while (firstArrayIndex < arrayOne.length && secondArrayIndex < arrayTwo.length){
            if(arrayOne[firstArrayIndex] < arrayTwo[secondArrayIndex]){

                if(firstArrayIndex == 0 || arrayOne[firstArrayIndex] != arrayOne[previousIndexFirstArray])
                     System.out.print(arrayOne[firstArrayIndex] + " ");
                previousIndexFirstArray = firstArrayIndex++;
            }else if(arrayTwo[secondArrayIndex] < arrayOne[firstArrayIndex]){
                if(secondArrayIndex == 0 || arrayTwo[secondArrayIndex] != arrayTwo[previousIndexSecondArray])
                    System.out.print(arrayTwo[secondArrayIndex] + " ");
                previousIndexSecondArray = secondArrayIndex++;
            }else{
                if(firstArrayIndex ==0)
                    System.out.print(arrayOne[firstArrayIndex] + " ");
                else if( secondArrayIndex == 0)
                    System.out.print(arrayTwo[secondArrayIndex] + " ");
                else if(arrayOne[previousIndexFirstArray] != arrayOne[firstArrayIndex] &&
                    arrayTwo[previousIndexSecondArray] != arrayTwo[secondArrayIndex]){
                    System.out.print(arrayOne[firstArrayIndex] + " ");
                }
                previousIndexFirstArray = firstArrayIndex++;
                previousIndexSecondArray = secondArrayIndex++;
            }
        }

        while(firstArrayIndex < arrayOne.length) {
            if (firstArrayIndex == 0 || arrayOne[firstArrayIndex] != arrayOne[previousIndexFirstArray])
                System.out.print(arrayOne[firstArrayIndex] + " ");
            previousIndexFirstArray = firstArrayIndex++;
        }

        while(secondArrayIndex < arrayTwo.length) {
            if (secondArrayIndex == 0 || arrayTwo[secondArrayIndex] != arrayTwo[previousIndexSecondArray])
                System.out.print(arrayTwo[secondArrayIndex] + " ");
            previousIndexSecondArray = secondArrayIndex++;
        }
    }
}
