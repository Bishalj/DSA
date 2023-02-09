package old.soc_gen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Virus {

    public static void main(String[] args)throws IOException {
        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        int numberOfTestCases = Integer.parseInt(br.readLine());


        for(int i=0; i<numberOfTestCases; i++){
            String grid[]= br.readLine().split(" ");
            int row = Integer.parseInt(grid[0]);
            int column= Integer.parseInt(grid[1]);
            String matrix[][] = new String[row][column];
            Map<String, String> positionValue = new HashMap<>();
            for(int j=0; j<row; j++) {
                String values[] = br.readLine().split("");

                for (int k = 0; k < column; k++) {
                    matrix[j][k] = values[k];
                    if(isValueEqualToZero(values[k]) == false && isValueNotEqualToDash(values[k])) {
                        insertValueInMap(positionValue, j + "_" + k, values[k]);
                    }
                }
            }

            System.out.println(getNumberOfDaysToInfect(positionValue, matrix));

        }

    }

    private static int getNumberOfDaysToInfect(Map<String, String> positionValue, String[][] matrix) {

        int count =0;

        ArrayList<Position> infectedPostions = new ArrayList<>();

        while(true){
            boolean isAnyOneInfected = false;
            Iterator<Map.Entry<String, String>> it = positionValue.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> mapData = it.next();
                if (positionValue.size() == 0) {
                    return count;
                } else if (isPositionCanBeInfected(mapData, matrix)) {
                    isAnyOneInfected = true;
                    addInfectedPositions(infectedPostions, mapData);
                    if ("1".equals(mapData.getValue()))
                        it.remove();
                    else if ("2".equals(mapData.getValue()))
                        mapData.setValue("1");

                }
            }

            decrementInfectedPositionValue(infectedPostions, matrix);
            if(isAnyOneInfected == false){
                if(positionValue.isEmpty() == false)
                    return -1;
                return count;
            }
            count++;
        }
    }

    private static void decrementInfectedPositionValue(ArrayList<Position> infectedPostions, String[][] matrix) {

        for (Position position: infectedPostions) {
            int row = position.getRow();
            int column = position.getColumn();

            String value = matrix[row][column];
            if("1".equals(value))
                matrix[row][column] = "0";
            else if("2".equals(value))
                matrix[row][column] = "1";
        }
    }

    private static void addInfectedPositions(ArrayList<Position> infectedPostions, Map.Entry<String, String> mapData) {
        int row = Integer.parseInt(mapData.getKey().split("_")[0]);
        int column = Integer.parseInt(mapData.getKey().split("_")[1]);
        infectedPostions.add(new Position(row, column));
    }

    private static boolean isPositionCanBeInfected(Map.Entry<String, String> mapData, String[][] matrix) {
        int row = Integer.parseInt(mapData.getKey().split("_")[0]);
        int column = Integer.parseInt(mapData.getKey().split("_")[1]);

        int maxRow = matrix.length;
        int maxColumn = matrix[0].length;
        if(row+1 < maxRow && isValueEqualToZero(matrix[row+1][column]))
            return true;
        if(row-1 >= 0 && isValueEqualToZero(matrix[row-1][column]))
            return true;
        if(column+1 < maxColumn && isValueEqualToZero(matrix[row][column+1]))
            return true;
        if(column-1 >= 0 && isValueEqualToZero(matrix[row][column-1]))
            return true;

        return false;
    }

    private static void insertValueInMap(Map<String, String> positionValue, String key, String value) {
        positionValue.put(key, value) ;
    }

    private static boolean isValueNotEqualToDash(String value) {
        return "_".equalsIgnoreCase(value) == false;
    }

    private static boolean isValueEqualToZero(String value) {
        return "0".equalsIgnoreCase(value);
    }
}

class Position{
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
