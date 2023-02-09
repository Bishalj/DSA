package old.matrix;

public class PrintBoundaryElements {
    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,3, 10},
                {4,5,6, 12},
                {7,8,9, 13},
                {14, 15, 16, 17}
        };
        printTheBoundaryElements(matrix);
    }

    private static void printTheBoundaryElements(int[][] matrix) {
        String right, left, down, upper;
        right = left = down = upper = "";

        for(int i=0; i<matrix[0].length; i++){
            right += matrix[0][i] + " ";
            left += matrix[matrix.length -1][matrix[0].length - 1 - i] + " ";
        }

        for(int i=1; i<matrix.length-1; i++){
            down  += matrix[i][matrix[0].length - 1] + " ";
            upper += matrix[matrix.length - 1 -i][0] + " ";
        }

        System.out.println(right + down + left + upper);
    }

}
