package old.gfg.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
	int arr[];
	int size;
	int capacity;
	public Heap(int capacity){
		arr = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	public void add(int data){
		if(size == capacity){
			System.out.println("Heap is Full");
			return;
		}
		int childIndex = size;
		arr[size++] = data;
		minify(childIndex, data);
		display();
	}

	public int deleteMinimum(){
		if(size == 0){
			System.out.println("Heap is Empty");
			return Integer.MIN_VALUE;
		}
		arr[0] = arr[size-1];
		size--;
		if(size == 0)
			return arr[0];
		heapify(0);
		display();
		return arr[0];
	}


	public void decreaseKey(int i, int data){
		if(i >= size){
			System.out.println("Invalid Index");
		}
		arr[i] = data;
		int leftChildIndex = getLeftChildIndex(i);
		int rightChildIndex = getRightChildIndex(i);
		if(
				(leftChildIndex < size && getLeftChildValue(i) < data) ||
				(rightChildIndex < size && getRightChildValue(i) < data)
		)
			heapify(i);
		else
			minify(i, data);

		display();
	}

	private void heapify(int i) {
		int left = getLeftChildIndex(i);
		int right = getRightChildIndex(i);
		int smallest = i;
		if(left < size && arr[left] < arr[i])
			smallest = left;
		if(right < size && arr[right] < arr[smallest])
			smallest = right;

		if(smallest != i){
			swapIndexValue(i, smallest);
			heapify(i);
		}
	}

	private void minify(int childIndex, int data) {
		while (childIndex != 0){
			int parentIndex = getParentIndex(childIndex);
			int parentValue = getParentValue(childIndex);
			if(parentValue < data)
				return;
			swapIndexValue(parentIndex, childIndex);
			childIndex = parentIndex;
		}
	}

	private void sortKSortedArray(int arr[], int k) {
		if(k == 0)
			return;

		PriorityQueue<Integer> minHeap = new PriorityQueue();
		for(int i=0; i<k; i++)
			minHeap.add(arr[i]);
		int count=0;
		for(int i=k; i<arr.length; i++){
			minHeap.add(arr[i]);
			arr[count++] = minHeap.poll();
		}
		while (!minHeap.isEmpty())
			arr[count++] = minHeap.poll();

		display(arr);
	}

	private void kClosetElement(int arr[], int k, int x) {
		if(k == 0)
			return;

		PriorityQueue<KthClosest> maxHeap = new PriorityQueue<>((a, b) -> b.diff > a.diff ? 1 : -1);
		for (int i = 0; i< k; i++) {
			int diff = Math.abs(arr[i] - x);
			System.out.println("diff: "+diff);
			maxHeap.add(new KthClosest(arr[i], diff));
		}

		for (int i = k; i <arr.length; i++) {
			int diff = Math.abs(arr[i] - x);
			int peek = maxHeap.peek().diff;
			System.out.println("diff: "+diff + " , peek: " + peek);
			if(maxHeap.peek().diff > diff ){
				maxHeap.poll();
				maxHeap.add(new KthClosest(arr[i], diff));
			}
		}
		PriorityQueue<KthClosest> minHeap = new PriorityQueue<>((a, b) -> b.diff < a.diff ? 1 : -1);
		minHeap.addAll(maxHeap);
		maxHeap.clear();
		while (!minHeap.isEmpty())
			System.out.print(minHeap.poll().value + " ");

		System.out.println();
	}

	public void medianOfAStream(int arr[]){
		PriorityQueue<Integer> minHeap = new PriorityQueue();
		PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

    for (int i = 0; i <arr.length; i++) {
    	int data = arr[i];
		if(i%2 == 0){
			if(!maxHeap.isEmpty() && data > minHeap.peek()){
				int min = minHeap.poll();
				minHeap.add(data);
				maxHeap.add(min);
			}
			else
				maxHeap.add(data);
			System.out.print(maxHeap.peek() + " ");
		}else{
			if(data < maxHeap.peek()){
				int max = maxHeap.poll();
				maxHeap.add(data);
				minHeap.add(max);
			}
			else
				minHeap.add(data);
			System.out.print(((minHeap.peek() + maxHeap.peek())/2.0)+ " ");
		}
    }
	}

	private void swapIndexValue(int parentIndex, int childIndex) {
		int tmp = arr[parentIndex];
		arr[parentIndex] = arr[childIndex];
		arr[childIndex] = tmp;
	}

	private int getLeftChildIndex(int parentIndex){
		return 2*parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex){
		return 2*parentIndex + 2;
	}

	private int getParentIndex(int childIndex){
		return (childIndex -1)/2;
	}

	private int getLeftChildValue(int parentIndex){
		return arr[getLeftChildIndex(parentIndex)];
	}

	private int getRightChildValue(int parentIndex){
		return arr[getRightChildIndex(parentIndex)];
	}

	private int getParentValue(int childIndex){
		return arr[getParentIndex(childIndex)];
	}

	private void display(){
		for (int i = 0; i< size; i++) {
			System.out.print(arr[i] + " ");
		}
    	System.out.println();
	}

	private void display(int arr[]){
		for (int i = 0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
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
	  heap.deleteMinimum();
	  heap.deleteMinimum();

	  heap.add(12);
	  heap.add(3);
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	 /* heap.add(10);
	  heap.add(80);
	  heap.add(15);
	  heap.add(100);
	  heap.add(85);
	  heap.add(18);
	  heap.add(20);
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.add(118);
	  heap.add(120);
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.deleteMinimum();
	  heap.add(10);
	  heap.add(80);
	  heap.add(15);
	  heap.add(100);
	  heap.add(85);
	  heap.add(18);
	  heap.add(20);
	  heap.decreaseKey(3, 4);
	  int arr1[] = {9, 8, 7, 18, 17, 19};
	  heap.sortKSortedArray(arr1, 2);

	  int arr2[] = {10, 9, 8, 7, 4, 70, 50, 60};
	  heap.sortKSortedArray(arr2, 4);

	  int arr3[] = {10, 80, 100, 5, 120};
	  heap.kClosetElement(arr3, 3, 2);

	  int m[] = {25, 7, 10, 15, 20};
	  heap.medianOfAStream(m);*/
  }
}
