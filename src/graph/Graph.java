package graph;

import utils.CommonUsedUtils;

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
//        adjacentList[des].add(src);
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
            if(vertexIsNotVisited(visited[i]))
                printBFSPathForDisconnectedGraph(i, visited);
        }
    }

    void printBFSPathForDisconnectedGraph(int source, boolean[] visited){
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        System.out.println("-------------------- Print BFS with Source "+source+" ------------------------------");
        while (vertexIsNotVisited(queue.isEmpty())){
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            LinkedList<Integer> edges = adjacentList[vertex];
            for (int i = 0; i < edges.size(); i++) {
                int currentEdge = edges.get(i);
                if(vertexIsNotVisited(visited[currentEdge])){
                    queue.add(currentEdge);
                    visited[currentEdge] = true;
                }
            }
        }
        System.out.println();
    }
    public void printDFSPathMail(int source){
        System.out.println("-------------------- Print DFS with Source "+source+" ------------------------------");
        final boolean[] visited = new boolean[size];
        printDFSPath(source, visited);
        System.out.println();
    }

    private void printDFSPath(int source, boolean[] visited){
        System.out.print(source + " ");
        visited[source] = true;
        for(int i=0; i<adjacentList[source].size(); i++){
            int data = adjacentList[source].get(i);
            if(vertexIsNotVisited(visited[data])) {
                printDFSPath(data, visited);
            }
        }
    }

    public void shortestPathInAnUnweightedGraph(int source){
        boolean visited[] = new boolean[size];
        int shortestPath[] = new int[size];
        Queue<Integer> vertexQueue = new LinkedList<>();
        vertexQueue.add(source);
        visited[source] = true;
        shortestPath[source] = 0;
        int count=0;
        while (vertexIsNotVisited(vertexQueue.isEmpty())){
            count++;
            int vertex = vertexQueue.poll();

            LinkedList<Integer> edges = adjacentList[vertex];
            for (Integer value : edges) {
                if(vertexIsNotVisited(visited[value])) {
                    shortestPath[value] = count;
                    vertexQueue.add(value);
                    visited[value] = true;
                }
            }
        }
        System.out.println("----------------------Shortest Path in a Unweighted Graph-------------------------------");
        CommonUsedUtils.displayArray(shortestPath);
        System.out.println("-----------------------------------------------------");
    }

    public boolean detectACycleInDirectedGraph() {
        boolean visited[] = new boolean[size];
        boolean visitedTemp[] = new boolean[size];
        for (int i=0; i<size; i++) {
            if(vertexIsNotVisited(visited[i]) && detectACycleInDirectedGraph(i, visitedTemp))
                return true;

            visited = visitedTemp;
            visitedTemp = new boolean[size];
        }
        return false;
    }

    public boolean detectACycleInDirectedGraph(int source, boolean visited[]) {
        System.out.println(source);
        visited[source] = true;
        LinkedList<Integer> edges = adjacentList[source];
        while (vertexIsNotVisited(edges.isEmpty())){
            int vertex = edges.poll();
            if(vertexIsNotVisited(visited[vertex])){
                return false || detectACycleInDirectedGraph(vertex, visited);
            }else {
                return true;
            }
        }
        return false;
    }

    public void shortestPathInDAG(int source){
        boolean visited[] = new boolean[size];
        int shortestPath[] = new int[size];
        for(int i=0; i<size; i++)
            shortestPath[i] = Integer.MAX_VALUE;
        shortestPath[source] = 0;

        shortestPath(source, visited, shortestPath, 0);
        CommonUsedUtils.displayArray(shortestPath);

    }

    private void shortestPath(int source, boolean[] visited, int[] shortestPath, int previousPathSum) {
        visited[source] = true;
        shortestPath[source] = previousPathSum;
        LinkedList<Integer> edges = adjacentList[source];
        while (edgeIsNotEmpty(edges)){
            int vertex = edges.poll();
            if(vertexIsNotVisited(visited[vertex])){
                shortestPath(vertex, visited, shortestPath, shortestPath[vertex] + /*weight(u,v)*/ vertex);
            }
        }
    }



    private boolean vertexIsNotVisited(boolean b) {
        return b == false;
    }

    private boolean edgeIsNotEmpty(LinkedList<Integer> edges) {
        return vertexIsNotVisited(edges.isEmpty());
    }


}


