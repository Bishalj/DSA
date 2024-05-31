package prepare.graph;

import java.util.ArrayList;
import java.util.List;

public class QuickUnionRankPathCompression {
	private final int[] root;
	private final int[] rank;

	public QuickUnionRankPathCompression(int vertex){
		root = new int[vertex];
		rank = new int[vertex];
		for (int i = 0; i < vertex; i++) {
			root[i] = i;
			rank[i] = 1;
		}
	}

	public int find(int x){
		if(x == root[x])
			return x;
		return root[x] = find(root[x]);
	}

	public void union(int x, int y){
		int rootX = find(x);
		int rootY = find(y);
		if(rootX != rootY){
			if(rank[rootX] > rank[rootY])
				root[rootY] = rootX;
			else if(rank[rootX] < rank[rootY])
				root[rootX] = rootY;
			else{
				root[rootY] = rootX;
				rank[rootX] += 1;
			}
		}
	}

	public boolean isConnected(int x, int y){
		/*for (int data : root)
			System.out.print(data+" ");
		System.out.println();*/
		return find(x) == find(y);
	}

	public static void main(String[] args) {
		QuickUnionRankPathCompression quickUnion = new QuickUnionRankPathCompression(5);
		quickUnion.union(0,2);
		quickUnion.union(1,3);
		quickUnion.union(3,2);

		System.out.println(quickUnion.isConnected(0,4));


		quickUnion.union(4,1);

		System.out.println(quickUnion.isConnected(0,4));

	}
}


class RoomDetails{
	int roomNumber;
	int meetingIndex;
	int meetingDuration;

	public RoomDetails(int roomNumber, int meetingIndex, int meetingDuration){
		this.roomNumber = roomNumber;
		this.meetingIndex = meetingIndex;
		this.meetingDuration = meetingDuration;
	}


}
