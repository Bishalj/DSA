package matrix;

public class SearchInRowAndColumnWiseSortedMatrix {

    public static void main(String[] args) {
        int matrix[][] = {
                {10,20,50},
                {15,25,80},
                {34,35,100}
        };
        int searchNumber = 35;
        displayMatrix(matrix);
        System.out.println("Is element " + searchNumber +  " is present: " + searchNumberInSortedMatrix(matrix, searchNumber));
    }

    private static boolean searchNumberInSortedMatrix(int[][] matrix, int searchNumber) {
        int maximumValidColumnSize = matrix[0].length;
        int maximumValidRowize = matrix[0].length;
        int counter = 0;
        for(int i=0; i<maximumValidRowize; i++){
            if(maximumValidColumnSize < 0)
                break;
            for (int j=0; j<maximumValidColumnSize; j++){
                System.out.println("Traversal: "+counter++);
                if (matrix[i][j] == searchNumber)
                    return true;
                else if(matrix[i][j] > searchNumber){
                    maximumValidColumnSize = j;
                    break;
                }

            }
        }
        return false;
    }

    private static void displayMatrix(int[][] matrix){
        System.out.println("---------------------------------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
    }
}
