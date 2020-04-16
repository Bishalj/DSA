package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatMazeProblem {

    static Boolean b[] = new Boolean[5];
    public static void main(String[] args) {

        float f1= 10.20f;
        float f2= 10.20f;

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(4);
        System.out.println(Collections.binarySearch(list, 6));
        System.out.println(f1==f2);
        int arr[][] = {
                {1,1,1,1},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}
        };

        System.out.println(getValue());

        int pathArray[][] = new int[arr.length][arr[0].length];
        RatLocation ratLocation = new RatLocation(0, 0);
        System.out.println(canRatFindTheCheese(arr, ratLocation, pathArray));
    }

    private static int getValue() {
        int i=1;
        try{
            i=100/0;
            return i;
        }catch (Exception e){
            i = 200;
            return i;
        }finally {
            i = 300;
            return i;
        }
    }

    private static void show(Object o) {
        System.out.println("O");
    }


    private static void show(String o) {
        System.out.println("S");
    }

    private static void show(StringBuffer o) {
        System.out.println("SB");
    }

    private static boolean canRatFindTheCheese(int[][] arr, RatLocation ratLocation, int[][] pathArray) {

        if(ratLocation.row == arr.length -1 && ratLocation.col == arr[0].length-1) {
            pathArray[ratLocation.row][ratLocation.col] = 1;
            display2DArray(pathArray);
            return true;
        }

        if(isColumnIncreementLocationValid(arr, ratLocation)){
            pathArray[ratLocation.row][ratLocation.col] = 1;
            if(canRatFindTheCheese(arr, new RatLocation(ratLocation.row, ratLocation.col + 1), pathArray))
                return true;
            else
                pathArray[ratLocation.row][ratLocation.col] = 0;
        }

        if(isRowIncreementLocationValid(arr, ratLocation)) {
            pathArray[ratLocation.row][ratLocation.col] = 1;
            if(canRatFindTheCheese(arr, new RatLocation(ratLocation.row+1, ratLocation.col), pathArray))
                return true;
            else
                pathArray[ratLocation.row][ratLocation.col] = 0;
        }

        return false;
    }

    private static boolean isRowIncreementLocationValid(int[][] arr, RatLocation ratLocation) {
        return ratLocation.row + 1 != arr.length &&
                arr[ratLocation.row + 1][ratLocation.col] == 1;
    }

    private static boolean isColumnIncreementLocationValid(int[][] arr, RatLocation ratLocation) {
        return ratLocation.col + 1 != arr[0].length &&
                arr[ratLocation.row][ratLocation.col + 1] == 1;
    }

    private static void display2DArray(int[][] pathArray) {
        for (int i = 0; i < pathArray.length; i++) {
            for (int j = 0; j < pathArray[i].length; j++) {
                System.out.print(pathArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class RatLocation{
    int row;
    int col;

    public RatLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
