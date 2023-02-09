package old.backtracking;

public class NQueen {

    public static void main(String[] args) {
        int n= 5;

        printTheNQueenMatrix( n);
    }

    private static void printTheNQueenMatrix(int n) {
        int row =0;
        for(int i=0; i<n; i++){
            int column = i;
            int arr[][] = new int[n][n];
            System.out.println(isNQueen(arr, row, column));
        }
    }

    private static boolean isNQueen(int[][] arr, int row, int column) {

        if(positionIsValid(arr, row, column)) {

            if (arr.length-1 == row) {
                arr[row][column] = 1;
                printTheMatrix(arr);
                return true;
            }
            arr[row][column] = 1;
            for (int i = 0; i < arr[row].length; i++) {
                if(column != i) {
                    boolean value = isNQueen(arr, row + 1, i);
                    if(!value)
                        arr[row+1][i] = 0;
                }

            }
        }

        return false;
    }

    private static boolean positionIsValid(int[][] arr, int row, int column) {
        for (int i = 0; i < row; i++) {
            if(arr[i][column] == 1)
                return false;
        }

        for(int i = row-1; i>=0; i--){
            int leftDiagonalColumn = column + row - i;
            int rightDiagonalColumn = column - row + i;
            if(     (leftDiagonalColumn< arr[0].length  && arr[i][leftDiagonalColumn] == 1) ||
                    (rightDiagonalColumn >= 0 &&arr[i][rightDiagonalColumn] == 1))
                return false;
        }
        return true;
    }

    private static void printTheMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
