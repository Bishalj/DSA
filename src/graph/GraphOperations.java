package graph;

public class GraphOperations {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1,2);
        graph.addEdge(1,1);
        graph.addEdge(1,3);

        graph.addEdge(2,3);
        graph.addEdge(4,3);
        graph.addEdge(0,3);
        graph.addEdge(0,4);

        graph.display();
    }
}
