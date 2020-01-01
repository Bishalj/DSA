package Hackerrank.recursion;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TrystWithChess {



    public static void main(String[] args) throws IOException {
        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);
        int numberOfMoves = Integer.parseInt(arr[2]);
        int boardSize = 10;
        CalculateMoves calculateMoves = new CalculateMoves();
        System.out.println(calculateMoves.getNumberOfPossiblePositions(row, column, numberOfMoves, boardSize));

    }

}
class CalculateMoves{

    public int getNumberOfPossiblePositions(int row, int column, int numberOfMoves, int boardSize) {

        if(isPositionInvalid(row, column, boardSize))
            return 0;
        System.out.println("Row: "+ row+" , Column: "+column);
        if(numberOfMoves == 0)
           return 1;

        return  getNumberOfPossiblePositions(row + 2, column -1, numberOfMoves - 1, boardSize)
                + getNumberOfPossiblePositions(row + 2, column +1, numberOfMoves - 1, boardSize)
                + getNumberOfPossiblePositions(row - 2, column -1, numberOfMoves - 1, boardSize)
                + getNumberOfPossiblePositions(row - 2, column +1, numberOfMoves - 1, boardSize)
                + getNumberOfPossiblePositions(row + 1, column -2, numberOfMoves - 1, boardSize)
                + getNumberOfPossiblePositions(row - 1, column -2, numberOfMoves - 1, boardSize)
                + getNumberOfPossiblePositions(row + 1, column +2, numberOfMoves - 1, boardSize)
                + getNumberOfPossiblePositions(row - 1, column +2, numberOfMoves - 1, boardSize);

    }

    private static boolean isPositionInvalid(int currentRow, int currentColumn, int boardSize) {
        return currentRow > boardSize
                || currentRow <= 0
                || currentColumn > boardSize
                || currentColumn <= 0;
    }
}
