package matrix;

public class SpiralMatrix {

    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,3, 4,5, 11},
                {16, 17, 18, 19, 6, 11},
                {15, 24, 25, 20, 7, 11},
                {14, 23, 22, 21, 8, 11},
                {13, 12, 11, 10, 9, 11},
                {1,2,3, 4,5, 6}
        };
        printTheSpiralMatrix(matrix);
    }

    private static void printTheSpiralMatrix(int[][] matrix) {
        int size = (matrix.length - 1)/2;
        int n =matrix.length;
        int row =0, column = 0;
        while(size >= 0){
            for(int i=row; i<n - column; i++)
                System.out.print(matrix[row][i] + " ");

            for(int i=row+1; i<n - column; i++)
                System.out.print(matrix[i][ n - column - 1] + " ");

            for(int i=n - row - 2; i>=column; i--)
                System.out.print(matrix[n - row - 1][i] + " ");

            for(int i=n-column-2; i>=row+1; i--)
                System.out.print(matrix[i][column] + " ");

            row++;
            column++;
            size--;
        }
    }

}
