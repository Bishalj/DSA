package prepare.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindMedianOfAStream {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public FindMedianOfAStream(){
		 maxHeap = new PriorityQueue<>((a,b) -> b-a);
		 minHeap = new PriorityQueue<>();
	}

	public void add(int data){
		int len = (maxHeap.size() + minHeap.size())%2;
		if(len==0){
			if(!minHeap.isEmpty() && minHeap.peek()<data){
				maxHeap.add(minHeap.poll());
				minHeap.add(data);
			}else
				maxHeap.add(data);
		}else{
			if(!maxHeap.isEmpty() && maxHeap.peek()>data){
				minHeap.add(maxHeap.poll());
				maxHeap.add(data);
			}else
				minHeap.add(data);
		}

		System.out.println(Arrays.toString(maxHeap.toArray()) + Arrays.toString(minHeap.toArray()) + " --> " + getMedian());
	}

	public double getMedian() {
		if ((maxHeap.size() + minHeap.size()) % 2 != 0)
			return maxHeap.peek();
		return (maxHeap.peek()+minHeap.peek())/2.0;
	}

	public static void main(String[] args) {
		FindMedianOfAStream fms = new FindMedianOfAStream();
		fms.add(25);
		fms.add(7);
		fms.add(10);
		fms.add(15);
		fms.add(20);
	}
}


class Solution {
	public long maximumHappinessSum(int[] happiness, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue();

		for(int i=0 ;i<happiness.length; i++){
			pq.add(happiness[i]);
			if(pq.size()>k)
				pq.poll();
		}
		PriorityQueue<Integer> pqReverse = new PriorityQueue<Integer>((a,b) -> b-a);
		pq.addAll(pq);
		int deduction = 0, maximumHappiness = 0;
		while(!pqReverse.isEmpty()){
			int data = pqReverse.peek()-deduction <= 0 ? 0 : pqReverse.peek()-deduction;
			maximumHappiness += data;
			deduction++;
			pqReverse.poll();
		}
		return maximumHappiness;
	}
}