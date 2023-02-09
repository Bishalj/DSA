package old.matrix;

public class TransposeMatrix {

    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        displayMatrix(matrix);
        transposeTheMatrix(matrix);
        displayMatrix(matrix);
    }

    private static void transposeTheMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                swapMatrixPosition(i,j,matrix);
            }
            System.out.println();

        }
    }

    private static void swapMatrixPosition(int i, int j, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private static void displayMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
    }
}
