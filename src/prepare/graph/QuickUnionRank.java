package prepare.graph;

public class QuickUnionRank {
	private final int[] root;

	public QuickUnionRank(int vertex){
		root = new int[vertex];
		for (int i = 0; i < vertex; i++) {
			root[i] = i;
		}
	}

	public int find(int x){
		while (x != root[x]) {
			x = root[x];
		}
		return x;
	}

	public void union(int x, int y){
		int rootX = find(x);
		int rootY = find(y);
		if(rootX != rootY){
			root[rootY] = rootX;
		}
	}

	public boolean isConnected(int x, int y){
		for (int data : root)
			System.out.print(data+" ");
		System.out.println();
		return find(x) == find(y);
	}

	public static void main(String[] args) {
		QuickUnionRank quickUnion = new QuickUnionRank(5);
		quickUnion.union(0,2);
		quickUnion.union(1,3);
		quickUnion.union(3,2);

		System.out.println(quickUnion.isConnected(0,4));


		quickUnion.union(4,1);

		System.out.println(quickUnion.isConnected(0,4));

	}
}


