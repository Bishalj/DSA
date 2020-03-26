package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

class CharactersInAMatrix {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dimensions[]  = br.readLine().split(" ");

        String charactersArray[][] = new String
                [Integer.parseInt(dimensions[0])]
                [Integer.parseInt(dimensions[1])];
        for(int j=0; j<Integer.parseInt(dimensions[0]); j++){
            String charaters[]  = br.readLine().split( "");
            for (int k = 0; k < Integer.parseInt(dimensions[1]); k++) {
                charactersArray[j][k] =charaters[k];
            }
        }

//        for (int j = 0; j < dimensions[0]; j++) {
//            for (int k = 0; k <dimensions[1]; k++) {
//                System.out.print(charactersArray[j][k] + " ");
//            }
//            System.out.println();
//        }
        int k = Integer.parseInt(dimensions[2]);
        System.out.println(getTheMaximumNumberOfStars(charactersArray, k));


    }

    private static int getTheMaximumNumberOfStars(String[][] charactersArray, int restrictedSize) {
        if(charactersArray.length < restrictedSize)
            restrictedSize = charactersArray.length;
        if(restrictedSize == 0)
            return 0;
        int maxStarsCount = 0;


        for (int i = 0; i < restrictedSize; i++) {
            for (int j = 0; j <restrictedSize; j++) {
                if("*".equalsIgnoreCase(charactersArray[i][j]))
                    maxStarsCount++;
            }
        }

//        for (int i = 0; i < charactersArray.length - restrictedSize; i++) {
//////            for (int j = 0; j < charactersArray[0].length - restrictedSize; j++) {
//////                int countOfStars = countStar(i, j, charactersArray, restrictedSize);
//////                if(countOfStars > maxStarsCount)
//////                    maxStarsCount = countOfStars;
//////            }
//////        }
        int countOfStars = 0;
        for (int i = 0; i < charactersArray.length - restrictedSize; i++) {
            for (int j = 0; j < charactersArray[0].length - restrictedSize; j++) {

                countOfStars = countStar(i, j, charactersArray, restrictedSize);

                if(countOfStars > maxStarsCount)
                    maxStarsCount = countOfStars;
            }
        }

        return maxStarsCount;
    }

    private static int countStar(int row, int column, String[][] charactersArray, int restrictedSize) {
        int countOfStars = 0;
        for (int i = row; i < row + restrictedSize; i++) {
            for (int j = column; j < column + restrictedSize; j++) {
                if("*".equalsIgnoreCase(charactersArray[i][j]))
                    countOfStars++;
            }
        }
        return countOfStars;
    }
}
