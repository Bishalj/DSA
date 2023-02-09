package old.heap;

public class HeapMain {

    public static void main(String[] args) {
        HeapOperations heapOperations = new HeapOperations(5);

        heapOperations.insert(5);
        heapOperations.display();
        heapOperations.insert(10);
        heapOperations.display();
        heapOperations.insert(4);
        heapOperations.display();
        heapOperations.insert(12);
        heapOperations.display();
        heapOperations.insert(33);
//        heapOperations.display();
//        heapOperations.insert(33);
        heapOperations.display();

        System.out.println(heapOperations.getMinimumElement());
        heapOperations.deleteTheMinimumElement();
        heapOperations.display();

        heapOperations.decreaseKeyOperation(4, 6);
        heapOperations.display();
        heapOperations.deleteElementAtGivenPosition(1);
        int[] arr ={45,22,67,46,3,1,5,2};
        arr = heapOperations.heapSort(arr);
        heapOperations.display(arr);
    }
}
