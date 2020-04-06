package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphWithArraylist {
    private ArrayList<ArrayList<Integer>> adjacentList;
    private int size;

    GraphWithArraylist(int size){
        this.size = size;
        adjacentList = new ArrayList(size);

        for (int i = 0; i < size; i++)
            adjacentList.add(new ArrayList<Integer>());
    }

    void addEdge(int src, int des){
        adjacentList.get(src).add(des);
        adjacentList.get(des).add(src);
    }

    void display(){
        ArrayList<ArrayList<Integer>> arrayLists = this.adjacentList;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                System.out.print(arrayLists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

