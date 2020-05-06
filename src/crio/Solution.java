package crio;

import java.util.*;

public class Solution {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0 ; t < T ; ++t) {
            int n = scanner.nextInt();
            String[] words = new String[n];
            for(int i = 0 ; i < n ; ++i) {
                words[i] = scanner.next();
            }
            /* Enter your code here.Print output to STDOUT. Your class should be named Solution. */
            Map<Character, Integer> boundedCharacters = new HashMap();
            mapBoundedCharactersWithValue(boundedCharacters);
            int numberOfBoundedRegions = 0;
            for(int index=0; index<words.length; index++){
                for(int position=0; position<words[index].length(); position++){
                    char character = words[index].charAt(position);
                    Integer boundedRegion = boundedCharacters.get(character);
                    if(boundedRegion != null)
                        numberOfBoundedRegions += boundedRegion;
                }
            }
            System.out.println(numberOfBoundedRegions);
        }
        scanner.close();
    }

    public static void mapBoundedCharactersWithValue(Map<Character, Integer> boundedCharacters){
        mapSmallCaseBoundedRegionAlphabets(boundedCharacters);
        mapCapitalCaseBoundedRegionAlphabets(boundedCharacters);
        mapBoundedRegionNumbers(boundedCharacters);
    }

    private static void mapBoundedRegionNumbers(Map<Character, Integer> boundedCharacters) {
        boundedCharacters.put('0',1);
        boundedCharacters.put('6',1);
        boundedCharacters.put('4',1);
        boundedCharacters.put('8',2);
        boundedCharacters.put('9',1);
    }

    private static void mapCapitalCaseBoundedRegionAlphabets(Map<Character, Integer> boundedCharacters) {
        boundedCharacters.put('A',1);
        boundedCharacters.put('B',2);
        boundedCharacters.put('D',1);
        boundedCharacters.put('O',1);
        boundedCharacters.put('P',1);
        boundedCharacters.put('Q',1);
        boundedCharacters.put('R',1);
    }

    private static void mapSmallCaseBoundedRegionAlphabets(Map<Character, Integer> boundedCharacters) {
        boundedCharacters.put('a',1);
        boundedCharacters.put('b',1);
        boundedCharacters.put('d',1);
        boundedCharacters.put('e',1);
        boundedCharacters.put('g',1);
        boundedCharacters.put('o',1);
        boundedCharacters.put('p',1);
        boundedCharacters.put('q',1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = scanner.nextInt();
            }
        }
        Set<String> turtleCanCommunicate = new HashSet<>();
        for (int row = 0; row < grid.length-1; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if(isTurtlePresent(row,column, grid)){
                    mapNumberOfTurtleCommunicating(row, column, grid, k, turtleCanCommunicate);
                }
            }
        }

        System.out.println(turtleCanCommunicate.size());

        scanner.close();
    }

    private static void mapNumberOfTurtleCommunicating(int row, int column, int[][] grid, int k, Set<String> turtleCanCommunicate) {
        boolean areTurtlesCommunicatingInRightDiagonal = areTurtlesCommunicatingInRightDiagonal(row, column, grid, k, turtleCanCommunicate);
        boolean areTurtlesCommunicatingInLeftDiagonal = areTurtlesCommunicatingInLeftDiagonal(row, column, grid, k, turtleCanCommunicate);
        if(areTurtlesCommunicatingInLeftDiagonal || areTurtlesCommunicatingInRightDiagonal)
            addCurrentTurtle(row,column,turtleCanCommunicate);
    }

    private static void addCurrentTurtle(int row, int column, Set<String> turtleCanCommunicate) {
        insertPositionInMap(row,column,turtleCanCommunicate);
    }

    private static boolean areTurtlesCommunicatingInLeftDiagonal(int row, int column, int[][] grid, int k, Set<String> turtleCanCommunicate) {
        boolean isTurtlesCommunicating = false;
        for (int i = row+1, j=column-1; i <grid.length && j >=0 && k-- != 0; i++, j--) {
            if(isTurtlePresent(i,j,grid)){
                insertPositionInMap(i, j, turtleCanCommunicate);
                isTurtlesCommunicating = true;
            }
        }
        return isTurtlesCommunicating;
    }

    private static void insertPositionInMap(int i, int j, Set<String> turtleCanCommunicate) {
        turtleCanCommunicate.add(i+"-"+j);
    }

    private static boolean areTurtlesCommunicatingInRightDiagonal(int row, int column, int[][] grid, int k, Set<String> turtleCanCommunicate) {
        boolean isTurtlesCommunicating = false;
        for (int i = row+1, j=column+1; i <grid.length && j <grid[0].length && k-- != 0 ; i++, j++) {
            if(isTurtlePresent(i,j,grid)) {
                insertPositionInMap(i, j, turtleCanCommunicate);
                isTurtlesCommunicating = true;
            }
        }
        return isTurtlesCommunicating;
    }

    private static boolean isTurtlePresent(int row, int column, int[][] grid) {
        return grid[row][column] == 1;
    }


}