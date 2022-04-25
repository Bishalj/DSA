package graph;

import java.util.*;

public class Graph2 {
    LinkedList<Integer>[] adjacencyList;
    int vertexSize;

    Graph2(int vertexSize){
        this.vertexSize = vertexSize;
        adjacencyList = new LinkedList[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            adjacencyList[i] = new LinkedList();
        }
    }

    public void addEdge(int source, int destination){
        adjacencyList[source].add(destination);
    }

    void searchDfs(int vertex){
        boolean visited[] = new boolean[vertexSize];
        dfs(vertex, visited);
        for(int i=0; i<vertexSize; i++){
            if(visited[i] == false)
                dfs(i, visited);
        }
    }

    private void dfs(int vertex, boolean visited[]){
        System.out.print(vertex+" ");
        visited[vertex] = true;

        LinkedList<Integer> adjacentVertexs = adjacencyList[vertex];
        while(adjacentVertexs.isEmpty() == false){
            int currentVertex = adjacentVertexs.poll();
            if(visited[currentVertex] == false)
                dfs(currentVertex, visited);
        }
    }
    public void topSort() {
        boolean visited[] = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if(!visited[i])
                topSort(i, visited, new Stack<>());
        }
    }

        private void topSort(int vertex, boolean visited[], Stack<Integer> stack){

        visited[vertex] = true;

        LinkedList<Integer> adjacentVertexs = adjacencyList[vertex];
        while(adjacentVertexs.isEmpty() == false){
            int currentVertex = adjacentVertexs.poll();
            if(visited[currentVertex] == false)
                topSort(currentVertex, visited, stack);
        }
        System.out.print(vertex+" ");
    }
}

class Operation{
    public static void main(String[] args) {
        Graph2 graph2 = new Graph2(5);
        graph2.addEdge(0,2);
        graph2.addEdge(0,1);
        graph2.addEdge(2,1);
        graph2.addEdge(3,4);
        graph2.addEdge(1,4);
//        graph2.searchDfs(2);
        System.out.println();
        graph2.topSort();
    }
}
