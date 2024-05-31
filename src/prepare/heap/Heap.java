package prepare.heap;

public class Heap {
	int heap[];
	int capacity;
	int size;
	Heap(int capacity){
		heap = new int[capacity];
		this.capacity = capacity;
		size=0;
	}

	public void add(int data){
		if(size==capacity) {
			System.out.println("Heap is full");
			System.out.println("----------------------------------------------------------");
		} else{
			heap[size++] = data;
			minify();
			display();
		}
	}

	public int poll(){
		if(size==0) {
			System.out.println("Heap is null");
			System.out.println("----------------------------------------------------------");
			return -1;
		}
		else{
			--size;
			int firstElement = heap[0];
			if(size==0)
				return firstElement;
			heap[0] = heap[size];
			heapify(0);
			System.out.println("Poll: " + firstElement);
			display();
			return firstElement;
		}
	}

	private void minify() {
		int index = size-1;
		while(getParent(index) > heap[index]){
			int tmp = getParent(index);
			heap[getParentIndex(index)] = heap[index];
			heap[index] = tmp;
			index = getParentIndex(index);
		}
	}

	private void heapify(int parentIndex){
		int left = getLeftChildIndex(parentIndex);
		int right = getRightChildIndex(parentIndex);
		int smallest = parentIndex;
		if(left<size && heap[left]<=heap[parentIndex])
			smallest = left;
		if(right<size && heap[right]<=heap[smallest])
			smallest = right;

		if(smallest != parentIndex){
			swapIndexValue(smallest, parentIndex);
			heapify(smallest);
		}
	}

	private void swapIndexValue(int parentIndex, int childIndex) {
		int tmp = heap[parentIndex];
		heap[parentIndex] = heap[childIndex];
		heap[childIndex] = tmp;
	}

	private int getLeftChildIndex(int parentIndex){
		return 2 * parentIndex + 1;
	}

	private int getLeftChild(int parentIndex){
		return heap[getLeftChildIndex(parentIndex)];
	}

	private int getRightChildIndex(int parentIndex){
		return 2 * parentIndex + 2;
	}

	private int getRightChild(int parentIndex){
		return heap[getRightChildIndex(parentIndex)];
	}

	private int getParentIndex(int childIndex){
		return (childIndex-1)/2;
	}

	private int getParent(int childIndex){
		return heap[getParentIndex(childIndex)];
	}

	private void display(){
		for (int i = 0; i< size; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
		System.out.println("----------------------------------------------------------");
	}

	public static void main(String[] args) {
		Heap heap = new Heap(6);
		heap.add(1);
		heap.add(5);
		heap.add(10);
		heap.add(2);
		heap.add(6);
		heap.add(9);
		heap.add(11);
		heap.add(12);
		heap.poll();
		heap.poll();

		heap.add(12);
		heap.add(3);
		heap.poll();
		heap.poll();
		heap.poll();
		heap.poll();
		heap.poll();
		heap.poll();
		heap.poll();
		heap.poll();
		heap.poll();
		heap.add(12);
		heap.add(3);
		heap.add(12);
		heap.add(3);

	}
}


/*
*
* 1
1 5
1 5 10
1 2 10 5
1 2 10 5 6
1 2 9 5 6 10
Heap is Full
Heap is Full
2 10 9 5 6
6 10 9 5
6 10 9 5 12
3 10 6 5 12 9
6 10 9 5 12
9 10 12 5
5 10 12
10 12
12
* */