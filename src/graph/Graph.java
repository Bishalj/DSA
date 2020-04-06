package graph;

import java.util.LinkedList;
import java.util.Queue;

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

    void printBFSPath(int source){
        final Queue<Integer> queue = new LinkedList<>();
        final boolean[] visited = new boolean[size];
        queue.add(source);
        visited[source] = true;
        System.out.println("-------------------- Print BFS with Source "+source+" ------------------------------");
        while (queue.isEmpty() == false){
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            LinkedList<Integer> edges = adjacentList[vertex];
            for (int i = 0; i < edges.size(); i++) {
                int currentEdge = edges.get(i);
                if(visited[currentEdge] == false){
                    queue.add(currentEdge);
                    visited[currentEdge] = true;
                }
            }
        }
        System.out.println();
    }


    void printBFSPathForDisconnectedGraph(){
        boolean[] visited = new boolean[size];
        for(int i=0; i<size; i++){
            if(visited[i] == false)
                printBFSPathForDisconnectedGraph(i, visited);
        }
    }

    void printBFSPathForDisconnectedGraph(int source, boolean[] visited){
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        System.out.println("-------------------- Print BFS with Source "+source+" ------------------------------");
        while (queue.isEmpty() == false){
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            LinkedList<Integer> edges = adjacentList[vertex];
            for (int i = 0; i < edges.size(); i++) {
                int currentEdge = edges.get(i);
                if(visited[currentEdge] == false){
                    queue.add(currentEdge);
                    visited[currentEdge] = true;
                }
            }
        }
        System.out.println();
    }


}
