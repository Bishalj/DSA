package prepare.graph;

import java.util.*;

public class BFS {
	public static void main(String[] args) {
		GraphBFS graphBFS = new GraphBFS(5);
		graphBFS.addEdge(0,1);
		graphBFS.addEdge(0,2);
		graphBFS.addEdge(1,2);
		graphBFS.addEdge(2,3);
		graphBFS.addEdge(3,4);
		graphBFS.printBfsPath(0);
	}
}



class GraphBFS{
	private List<List<Integer>> adjacencyList;
	GraphBFS(int vertex){
		this.adjacencyList = new ArrayList<>();
		for (int i = 0; i < vertex; i++)
			this.adjacencyList.add(new ArrayList<>());
	}

	void addEdge(int src, int des){
		this.adjacencyList.get(src).add(des);
	}

	public void printBfsPath(int src){
		boolean[] visited = new boolean[adjacencyList.size()];

		visited[src] = true;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		System.out.println(src);
		while (!queue.isEmpty()){
			List<Integer> paths = adjacencyList.get(queue.poll());
			for(Integer aPath : paths){
				if(!visited[aPath]){
					System.out.print(aPath + " ");
					queue.add(aPath);
					visited[aPath] = true;
				}
			}
			System.out.println();
		}
	}

	public List<List<Integer>> printAllBfsPath(int[][] graph){
		boolean[] visited = new boolean[adjacencyList.size()];

		visited[graph[0][0]] = true;
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> queue = new LinkedList<>();
		List<Integer> paths = new ArrayList<>();
		paths.add(0);
		queue.add(paths);
		while (!queue.isEmpty()){
			List<Integer> list = queue.poll();
			int data = list.get(list.size()-1);
			for(Integer aPath : graph[data]){
				List<Integer> tmpPath = new ArrayList<>(list);
				tmpPath.add(aPath);
				if(aPath == graph.length-1){
					result.add(tmpPath);
				}else{
					queue.add(tmpPath);
				}
			}
			System.out.println();
		}
		return result;
	}
}


class Solution {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		List<Map.Entry<Character, Integer>> list = new ArrayList<>();
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		System.out.println("map: " + map);

		StringBuilder sb = new StringBuilder();

		list.sort((a, b) -> b.getValue() - a.getValue());
		for(Map.Entry<Character, Integer> data: list){
			char ch = data.getKey();
			sb.append(String.valueOf(ch).repeat(data.getValue()));
		}
		return sb.toString();
	}
}