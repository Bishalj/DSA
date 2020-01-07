package matrix;

public class PrintTheMatrixInSnakePattern {

    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        printTheMatrixInSnakePatter(matrix);
    }

    private static void printTheMatrixInSnakePatter(int[][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i % 2 == 0)
                    System.out.print(matrix[i][j] + " ");
                else
                    System.out.print(matrix[i][matrix[i].length - j - 1] + " ");
            }
            System.out.println();
        }
    }
}
