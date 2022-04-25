package access_specifiers.com.bishal;

import access_specifiers.com.A;

import java.util.*;

public class D extends A {
    public static void main(String[] args) {
        A a = new A();
        a.a();
//        a.b(); -> error
        a.c();
        aa da = () -> {
                System.out.println("Bishal");
                return 1;
        };
        int data = da.aaa();
        System.out.println(data);
        Set s = new HashSet();
        Map<Integer, Integer> ddd = new LinkedHashMap<>();
        ddd.put(1,1);
        ddd.put(2,2);
        ddd.put(1,2);
        ddd.put(3,3);
        ddd.put(1,5);
        ddd.put(2,15);
        for (Map.Entry<Integer, Integer> map: ddd.entrySet()){
            System.out.println(map.getKey() + " --> " + map.getValue());
        }
//        List
        char aaa[][] = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };
        System.out.println(isValidSudoku(aaa));
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap();
        Map<Integer, Set<Character>> columnMap = new HashMap();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != '.'){
                    if(rowMap.get(i) == null){
                        Set<Character> characters = new HashSet();
                        characters.add(board[i][j]);
                        rowMap.put(i, characters);
                    }else{
                        Set<Character> characters = rowMap.get(i);
                        if(characters.contains(board[i][j]))
                            return false;
                        characters.add(board[i][j]);
                    }


                }
            }
        }

        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.') {
                    if (columnMap.get(i) == null) {
                        Set<Character> characters = new HashSet();
                        characters.add(board[j][i]);
                        columnMap.put(i, characters);
                    } else {
                        Set<Character> characters = columnMap.get(i);
                        if (characters.contains(board[j][i]))
                            return false;
                        characters.add(board[j][i]);
                    }
                }
            }
        }


        for(int i=0; i<board.length; i=i+3){
            for(int j=0; j<board[0].length; j=j+3){
                Set<Character> characters = new HashSet();
                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        if(characters.contains(board[k][l]))
                            return false;
                        else if(board[k][l] != '.')
                            characters.add(board[k][l]);
                    }
                }
            }
        }
        return true;
    }
}

@FunctionalInterface
interface aa{
    int aaa();
}
