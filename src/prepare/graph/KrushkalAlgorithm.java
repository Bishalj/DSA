package prepare.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KrushkalAlgorithm {
    public static void main(String[] args) {
        List<int[]> allEdges = new ArrayList<>();
        allEdges.add(new int[]{1,3,3});
        allEdges.add(new int[]{3,4,15});
        allEdges.add(new int[]{2,3,4});
        allEdges.add(new int[]{2,4,12});
        allEdges.add(new int[]{1,2,5});
        allEdges.add(new int[]{0,1,10});
        allEdges.add(new int[]{0,2,8});
        int vertices = 5;
        QuickUnionRankPathCompression quickUnionRankPathCompression = new QuickUnionRankPathCompression(vertices);
        List<Edge> egdesSortedByWeight = new ArrayList<>();
        for(int[] data: allEdges){
            Edge edge = new Edge(data[0], data[1], data[2]);
            egdesSortedByWeight.add(edge);
        }
        Collections.sort(egdesSortedByWeight);
        int minimumWeight = 0;
        for(Edge aEdge: egdesSortedByWeight){

            if(quickUnionRankPathCompression.isConnected(aEdge.src, aEdge.des)) {
                System.out.println("Its a cycle skip, Edge: " + aEdge);
                continue;
            }
            System.out.println("A edge: " + aEdge);
            quickUnionRankPathCompression.union(aEdge.src, aEdge.des);
            minimumWeight += aEdge.weight;
            if(--vertices == 1)
                break;
        }
        System.out.println("Minimum Weight: " + minimumWeight);
    }
}

class Edge implements Comparable<Edge>{
    int src, des, weight;
    public Edge(int src, int des, int weight){
        this.src = src;
        this.des = des;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", des=" + des +
                ", weight=" + weight +
                '}';
    }
}