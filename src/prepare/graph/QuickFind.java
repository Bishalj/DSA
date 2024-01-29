package prepare.graph;

import java.util.Arrays;
import java.util.stream.Stream;

public class QuickFind {
	private final int[] root;

	public QuickFind(int vertex){
		root = new int[vertex];
		for (int i = 0; i < vertex; i++) {
			root[i] = i;
		}
	}

	public int find(int x){
		return root[x];
	}

	public void union(int x, int y){
		int rootX = find(x);
		int rootY = find(y);
		if(rootX != rootY){
			for (int i = 0; i < root.length; i++) {
				if(root[i] == rootY)
					root[i] = rootX;
			}
		}
	}

	public boolean isConnected(int x, int y){
		for (int data : root)
			System.out.print(data+" ");
		System.out.println();
		return root[x] == root[y];
	}

	public static void main(String[] args) {
		QuickFind quickFind = new QuickFind(5);
		quickFind.union(0,2);
		quickFind.union(4,1);
		quickFind.union(1,3);

		System.out.println(quickFind.isConnected(0,4));

		quickFind.union(3,2);

		System.out.println(quickFind.isConnected(0,4));

	}
}


