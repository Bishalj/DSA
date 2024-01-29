/*
package crack_google.gfg.bitwise;

import java.util.*;

class MKAverage {
	int m, k;
	Queue<Integer> queue = new LinkedList<>();
	public MKAverage(int m, int k){
	m = this.m;
	k = this.k;
	}

	public void addElement(int num) {
		if(queue.size() >= m)
			queue.poll();
		queue.add(num);
	}

	public int calculateMKAverage() {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		int sum = 0;
		Queue<Integer> copyQueue = new LinkedList<>(queue);
		System.out.println("queue: " + queue.toString());
			while(!copyQueue.isEmpty()){
				int data = copyQueue.poll();
				sum += data;
				if(maxHeap.isEmpty() || minHeap.isEmpty()){
					maxHeap.add(data);
					minHeap.add(data);
				}else if(maxHeap.peek() > data){
					maxHeap.add(data);
				}else if(minHeap.peek() < data){
					minHeap.add(data);
				}
				if(maxHeap.size() > k)
					maxHeap.poll();
				if(minHeap.size() > k)
					minHeap.poll();
			}
		System.out.println("Max Heap: " + maxHeap.toString());
		System.out.println("Min Heap: " + minHeap.toString());
			int minus = 0;
			while(!maxHeap.isEmpty())
				minus += maxHeap.poll();

			while(!minHeap.isEmpty())
				minus += minHeap.poll();
			return sum-minus;
		}
	}

*/
/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 *//*



class RandomizedSet {

	Set<Integer> set;
	int size;
	public RandomizedSet() {
		this.set = new HashSet();
		this.size = 0;
	}

	public boolean insert(int val) {
		if(!set.contains(val)){
			size++;
			set.add(val);
			return true;
		}
		return false;
	}

	public boolean remove(int val) {
		if(set.contains(val)){
			size--;
			set.remove(val);
			return true;
		}
		return false;
	}

	public int getRandom() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(size);
		return set.[randomNumber];
	}
}*/
