package graph;

public class GraphOperations {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(1,2);
        graph.addEdge(1,3);

        graph.addEdge(2,3);
        graph.addEdge(4,3);
        graph.addEdge(0,3);
        graph.addEdge(3,0);
        graph.addEdge(0,4);

        //disconnected edge
        graph.addEdge(5,6);

        graph.display();
        graph.printBFSPath(0);
        graph.printBFSPath(1);
        graph.printBFSPath(2);
        graph.printBFSPath(3);
        graph.printBFSPath(4);

        graph.printBFSPathForDisconnectedGraph();

//        graph.printDFSPathMail(0);
        graph.printDFSPathMail(1);
        graph.printDFSPathMail(2);
        graph.printDFSPathMail(3);
        graph.printDFSPathMail(4);

        graph.shortestPathInAnUnweightedGraph(0);

        System.out.println("cycle is: " +graph.detectACycleInDirectedGraph());

        System.out.println("--------------------------------");

        GraphWithArraylist graphWithArraylist = new GraphWithArraylist(5);
        graphWithArraylist.addEdge(1,2);
        graphWithArraylist.addEdge(1,1);
        graphWithArraylist.addEdge(1,3);

        graphWithArraylist.addEdge(2,3);
        graphWithArraylist.addEdge(4,3);
        graphWithArraylist.addEdge(0,3);
        graphWithArraylist.addEdge(0,4);

        graphWithArraylist.display();
    }
}
