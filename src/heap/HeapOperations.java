package heap;

import java.util.Arrays;

public class HeapOperations {
    int heapArray[];
    int size;
    int capacity;

    HeapOperations(int capacity){
        this.heapArray = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int getLeftChildIndex(int parentIndex){
        return 2*parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex){
        return 2*parentIndex + 2;
    }

    public int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    public int getLeftChildValue(int parentIndex){
        return heapArray[getLeftChildIndex(parentIndex)];
    }

    public int getRightChildValue(int parentIndex){
        return heapArray[getRightChildIndex(parentIndex)];
    }

    public int getParentValue(int childIndex){
        return heapArray[getParentIndex(childIndex)];
    }

    public void insert(int data){
        if(isHeapFull()){
            System.out.println("Heap is full");
            return;
        }
        heapArray[size++] = data;
        int childIndex = size -1;
        while(getParentValue(childIndex) > heapArray[childIndex]){
            int parentIndex = getParentIndex(childIndex);
            int temp = heapArray[parentIndex];
            heapArray[parentIndex] = heapArray[childIndex];
            heapArray[childIndex] = temp;
            childIndex = parentIndex;
        }
    }

    public boolean isHeapFull() {
        return size == capacity;
    }

    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }

    public int getMinimumElement() {
        return heapArray[0];
    }

    public void deleteTheMinimumElement() {
        if(size == 0)
            return;
        if(size > 1) {
            heapArray[0] = heapArray[size - 1];
            minify(0);
        }
        size--;
    }

    public void decreaseKeyOperation(int position, int newValue) {
        position = position-1;
        if(size == 0)
            return;
        if(position <= size) {
            heapArray[position] = newValue;
            while(getParentValue(position) > heapArray[position]){
                swap(getParentIndex(position), position);
                position = getParentIndex(position);
            }
        }
    }

    private void minify(int position) {
        int leftPosition = getLeftChildIndex(position);
        int rightPosition = getRightChildIndex(position);
        int smallestPosition = position;
        if(leftPosition < capacity && heapArray[smallestPosition] > heapArray[leftPosition])
            smallestPosition = leftPosition;
        if(rightPosition < capacity && heapArray[smallestPosition] > heapArray[rightPosition])
            smallestPosition = rightPosition;

        if (smallestPosition != position){
            swap(position, smallestPosition);
            minify(smallestPosition);
        }
    }

    public void deleteElementAtGivenPosition(int position) {
        decreaseKeyOperation(position, Integer.MIN_VALUE);
        deleteTheMinimumElement();
        display();
    }


    private void swap(int position, int smallestPosition) {
        int temp = heapArray[position];
        heapArray[position] = heapArray[smallestPosition];
        heapArray[smallestPosition] = temp;
    }

    private void swap(int position, int smallestPosition, int arr[]) {
        int temp = arr[position];
        arr[position] = arr[smallestPosition];
        arr[smallestPosition] = temp;
    }

    public int[] heapSort(int arr[]){
        for(int i=(arr.length-2)/2; i>=0; i--){
            minifyTheGivenArray(i, arr);
        }

        for(int i=arr.length-1; i>=1; i--){
            swap(0,i,arr);
            minifyTheGivenArray(0, arr, i);
        }
        return arr;
    }

    public void display(int arr[]){
        for (int value :
                arr) {
            System.out.print(value + " " );
        }
        System.out.println();

    }

    private void minifyTheGivenArray(int i, int[] arr, int maxLength) {
        int leftIndex = getLeftChildIndex(i);
        int rightIndex = getRightChildIndex(i);
        int smallestIndex = i;
        if(leftIndex <= maxLength && arr[leftIndex] < arr[smallestIndex])
            smallestIndex = leftIndex;
        if(rightIndex <= maxLength && arr[rightIndex] < arr[smallestIndex])
            smallestIndex = rightIndex;

        if(smallestIndex != i){
            swap(i, smallestIndex, arr);
            minifyTheGivenArray(smallestIndex, arr);
        }
    }

    private void minifyTheGivenArray(int i, int[] arr) {
        int leftIndex = getLeftChildIndex(i);
        int rightIndex = getRightChildIndex(i);
        int smallestIndex = i;
        if(leftIndex < arr.length && arr[leftIndex] < arr[smallestIndex])
            smallestIndex = leftIndex;
        if(rightIndex < arr.length && arr[rightIndex] < arr[smallestIndex])
            smallestIndex = rightIndex;

        if(smallestIndex != i){
            swap(i, smallestIndex, arr);
            minifyTheGivenArray(smallestIndex, arr);
        }
    }

}

