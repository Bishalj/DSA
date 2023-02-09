package old.Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountOnlyRepeated {
    public static void main(String[] args)throws IOException {


        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            br.readLine();
            String []arrayStr = br.readLine().split(" ");
            int[] array = Arrays.stream(arrayStr).mapToInt(Integer::parseInt).toArray();
            printTheCountOfRepeatedElement(array, 0 , array.length - 1);
        }

    }

    private static int printTheCountOfRepeatedElement(int[] array, int lowerBoundIndex, int upperBoundIndex) {

        if (lowerBoundIndex > upperBoundIndex)
            return -1;

            int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;

            //Checking if middle index is not the first position
            // checking if previous element is same
            int result= 0;
            if(middleIndex != 0 &&array[middleIndex] == array[middleIndex - 1]){
                int searchElement = array[middleIndex];
                int leftMostIndexOfTheElement = getTheLeftMostIndexOfTheElement(lowerBoundIndex, middleIndex -1, searchElement, array);
                result = result + middleIndex - leftMostIndexOfTheElement;
            }
            if(middleIndex != array.length - 1 && array[middleIndex] == array[middleIndex + 1]){
                int searchElement = array[middleIndex];
                int rightMostIndexOfTheElement = getTheRightMostIndexOfTheElement(middleIndex + 1, upperBoundIndex, searchElement, array);
                result = result + rightMostIndexOfTheElement - middleIndex;
            }
            if (result != 0) {
                System.out.println(array[middleIndex] + " " + (result+1));
                return result+1;
            }

            int leftArrayResult = printTheCountOfRepeatedElement(array, lowerBoundIndex, middleIndex -1);
            if (leftArrayResult != -1)
                return leftArrayResult;

            int rightArrayResult =  printTheCountOfRepeatedElement(array, middleIndex + 1, upperBoundIndex);
            if(rightArrayResult != -1)
                return rightArrayResult;
            return -1;
    }

    private static int getTheLeftMostIndexOfTheElement(int lowerBound, int upperBoundIndex, int searchElement, int[] array) {
        if(lowerBound > upperBoundIndex)
            return -1;
        int middleIndex = (lowerBound+upperBoundIndex)/2;

        if(array[middleIndex] == searchElement && (middleIndex == 0 || array[middleIndex - 1] != searchElement)){
                return middleIndex;
        }else if(array[middleIndex] >= searchElement){
            return getTheLeftMostIndexOfTheElement(lowerBound, middleIndex-1, searchElement, array);
        }else{
            return getTheLeftMostIndexOfTheElement(middleIndex+1, upperBoundIndex, searchElement, array);
        }
    }

    private static int getTheRightMostIndexOfTheElement(int lowerBound, int upperBoundIndex, int searchElement, int[] array) {
        if(lowerBound > upperBoundIndex)
            return -1;
        int middleIndex = (lowerBound+upperBoundIndex)/2;

        if(array[middleIndex] == searchElement && ( middleIndex == array.length-1 || array[middleIndex + 1] != searchElement )){
                return middleIndex;
        }else if(array[middleIndex] <= searchElement){
            return getTheRightMostIndexOfTheElement(middleIndex+1, upperBoundIndex, searchElement, array);
        }else{
            return getTheRightMostIndexOfTheElement(lowerBound, middleIndex-1, searchElement, array);
        }
    }
}
