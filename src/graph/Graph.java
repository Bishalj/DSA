package graph;

import java.util.LinkedList;

public class Graph {

    private LinkedList<Integer> adjacentList[];
    private int size;

    Graph(int size){
        this.size = size;
        adjacentList = new LinkedList[size];

        for (int i = 0; i < size; i++)
            adjacentList[i] = new LinkedList<>();
    }

    void addEdge(int src, int des){
        adjacentList[src].add(des);
        adjacentList[des].add(src);
    }

    void display(){
        LinkedList<Integer> displayLinklist[] = this.adjacentList;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < displayLinklist[i].size(); j++) {
                System.out.print(displayLinklist[i].get(j) + " ");
            }
            System.out.println();
        }
    }



}
