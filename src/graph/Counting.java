package graph;

import java.util.LinkedList;

public class Counting {

    public static void main(String[] args) {
        int N = 5;
        int colors[] = {0,1,0,1,0};
        int edges[][] = {
                {1,2},
                {2,3},
                {3,4},
                {4,5}
        };
        System.out.println(CountPairs(N, colors, edges));
    }

    static long CountPairs(int N, int[] colors, int[][] edges){
        Graphh graphh = new Graphh(N, colors, edges);
        return graphh.countPairsByDFS();
    }
}

class VertexDetail{
    int index;
    int color;

    public VertexDetail(int destination, int destinationColor) {
        this.index = destination;
        this.color = destinationColor;
    }
}

class Graphh{
    private int vertex;
    private LinkedList<VertexDetail>[] adjacentList;
    private int[] colors;

    public Graphh(int vertex, int[] colors, int[][] edges){
        this.vertex = vertex;
        adjacentList = new LinkedList[vertex];
        this.colors = colors;
        initializeEdges(vertex);
        mapEdges(colors, edges);
    }

    private void mapEdges( int[] colors, int[][] edges) {
        for (int[] edge : edges) {
            int source = edge[0] - 1;
            int destination = edge[1] - 1;
            int destinationColor = colors[destination];
            addEdge(source, destination, destinationColor);
        }
    }

    private void initializeEdges(int vertex) {
        for (int position = 0; position < vertex; position++) {
            adjacentList[position] = new LinkedList();
        }
    }

    private void addEdge(int source, int destination, int destinationColor){
        VertexDetail vertexDetail = new VertexDetail(destination, destinationColor);
        adjacentList[source].add(vertexDetail);
    }


    public long countPairsByDFS() {
        boolean[] visited = new boolean[vertex];
        boolean[] iterations = new boolean[vertex];
        long count = 0;
        boolean isAnyWhiteBallInBetween = false;
        for (int index=0 ; index < vertex; index++){
            if(isColorBlack(colors[index])) {
                long pairs = getPairsFromAVertex(index, visited, isAnyWhiteBallInBetween,0);
                count += pairs;
            }
            iterations[index] = true;
            System.arraycopy(iterations, 0, visited, 0, vertex);
        }
        return count;
    }

    private boolean isColorBlack(int color) {
        return color == 0;
    }

    private long getPairsFromAVertex(int index, boolean[] visited, boolean isAnyWhiteBallInBetween, long totalCount) {
        visited[index] = true;
        LinkedList<VertexDetail> adjList = adjacentList[index];

        int totalRes = 0;
        for(int i=0; i<adjList.size(); i++){
            boolean isPreviousWhite = isAnyWhiteBallInBetween;
            int value = 0;
            VertexDetail vertexDetail = adjList.get(i);

            if(!visited[vertexDetail.index]){
                if(isColorBlack(vertexDetail.color)){
                    if(isAnyWhiteBallInBetween) {
                        value = 1;
                    }
                }else
                    isPreviousWhite = true;
                boolean newVisited[] = new boolean[vertex];
                System.arraycopy(visited, 0, newVisited, 0, vertex);
                totalCount = value + getPairsFromAVertex(vertexDetail.index, newVisited, isPreviousWhite, totalCount);
            }
            totalRes += totalCount;
        }
        return totalRes;
    }


}


