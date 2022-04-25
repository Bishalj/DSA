package tree;

public class Heap {
    int arr[];
    int size;
    int position;

    public Heap(int size){
        this.size = size;
        this.position = -1;
    }

    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex + 2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private int getLeftChild(int parentIndex){
        return arr[getLeftChildIndex(parentIndex)];
    }

    private int getRightChild(int parentIndex){
        return arr[getRightChildIndex(parentIndex)];
    }

    private int getParent(int childIndex){
        return arr[getParentIndex(childIndex)];
    }

    public void insert(int data){
        if(position == arr.length-1){
            System.out.println("Heap is full");
            return;
        }
        arr[++position] = data;
        heapify();
    }

    private void heapify() {
        int currentPosition = position;
        while(getParent(currentPosition) > arr[currentPosition]){
            swapData(getParent(currentPosition), currentPosition);
            currentPosition = getParent(currentPosition);
        }
    }

    public int pop(){
        if(position == -1){
            System.out.println("Heap is Empty");
            return -1;
        }
        int data = arr[0];
        arr[0]= arr[position];
        position--;

        minify();

        return 0;
    }

    private void minify() {

//        while ()
    }

    private void swapData(int parent, int position) {
        int data = arr[parent];
        arr[parent] = arr[position];
        arr[position] = data;
    }
}
