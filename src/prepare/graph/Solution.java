package prepare.graph;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int edges[][] = {
				{0,1},
				{1,2},
				{2,0}
		};
		System.out.println(solution.validPath(4, edges, 1, 4));
	}
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph4 graph = new Graph4(n);
        if(edges.length == 0)
            return true;
        for(int i=0; i<edges.length; i++)
            graph.addEdge(edges[i][0], edges[i][1]);

        return graph.dFSPathMail(source, destination);
    }
}

class Graph4 {

	private List<List<Integer>> adjacencyList;

	public Graph4(int size){
		adjacencyList = new ArrayList(size);
		for(int i=0; i<size; i++)
			adjacencyList.add(new ArrayList<>());
	}

	public void addEdge(int u, int v){
		adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
	}

    public boolean dFSPathMail(int source, int destination){
        System.out.println("-------------------- Print DFS with Source "+source+" ------------------------------");
        final boolean[] visited = new boolean[adjacencyList.size()];
        return printDFSPath(source, destination, visited);
    }

    private boolean printDFSPath(int source, int destination, boolean[] visited){
        visited[source] = true;
        for(int i=0; i<adjacencyList.get(source).size(); i++){
            int data = adjacencyList.get(source).get(i);
            if(data == destination)
                return true;
            if(vertexIsNotVisited(visited[data])) {
                if(printDFSPath(data, destination, visited))
                    return true;
            }
        }
        return false;
    }

       private boolean vertexIsNotVisited(boolean b) {
        return b == false;
    }
}
