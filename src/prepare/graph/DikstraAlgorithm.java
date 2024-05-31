package prepare.graph;

import old.Array_String.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DikstraAlgorithm {
	List<List<Pair<Integer, Integer>>> adjacencyList;
	public DikstraAlgorithm(int vertex){
		adjacencyList = new ArrayList<>();
		for(int i=0; i<vertex; i++)
			this.adjacencyList.add(new ArrayList<>());
	}

	private void addEdge(int s, int d, int w){
		this.adjacencyList.get(s).add(new Pair<>(d, w));
		this.adjacencyList.get(d).add(new Pair<>(s, w));
	}

	private int[] shortestPath(int src){
		int d[] = new int[adjacencyList.size()];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[src] = 0;
		PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<Pair<Integer, Integer>>((a,b) -> a.getValue()-b.getValue());
		priorityQueue.add(new Pair<>(src, 0));
		while (!priorityQueue.isEmpty()){
			Pair<Integer, Integer> vertexDetails = priorityQueue.poll();
			int weight = vertexDetails.getValue();
			int u = vertexDetails.getKey();
			int du = d[u];

			if (weight > du)
				continue;
			for(Pair<Integer, Integer> pair : adjacencyList.get(u)){
				int uw = pair.getValue();
				int dw = d[pair.getKey()];
				if(du+uw < dw){
					d[pair.getKey()] = du+uw;
					priorityQueue.add(pair);
				}
			}
		}
		return d;
	}

	public static void main(String[] args) {
		int V=9;
		DikstraAlgorithm g = new DikstraAlgorithm(V);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);

		int[] dist = g.shortestPath(0);
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; i++) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}
}

