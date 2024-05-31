package prepare.graph;

import old.Array_String.Pair;

import java.util.*;

class PrimsAlgorithm {
	public static void main(String[] args) {
		List<int[]> allEdges = new ArrayList<>();
		allEdges.add(new int[]{1,3,3});
		allEdges.add(new int[]{3,4,15});
		allEdges.add(new int[]{2,3,4});
		allEdges.add(new int[]{2,4,12});
		allEdges.add(new int[]{1,2,5});
		allEdges.add(new int[]{0,1,10});
		allEdges.add(new int[]{0,2,8});
		int n = 5;
		int minimumWeight = 0;
		int edgeUsed = 0;
		boolean visited[] = new boolean[n];
		PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;

		heap.add(new Pair(0,0));
		while(edgeUsed < n){
			int weight = heap.peek().getKey();
			int vertex = heap.poll().getValue();
			if(visited[vertex])
				continue;

			visited[vertex] = true;
			minimumWeight += weight;
			edgeUsed++;
			System.out.println("Partial Minimum Weight : " + minimumWeight);
			for(int i=0; i<n; ++i){
				if(!visited[i]) {
					int x = Math.abs(allEdges.get(vertex)[0] - allEdges.get(i)[0]);
					int y = Math.abs(allEdges.get(vertex)[1] - allEdges.get(i)[1]);
					heap.add(new Pair(allEdges.get(i)[2], i));
				}
			}

		}

		System.out.println("Minimum Weight: " + minimumWeight);
	}
}