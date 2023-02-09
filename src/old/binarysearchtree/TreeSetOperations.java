package old.binarysearchtree;
import java.util.TreeSet;

public class TreeSetOperations {

    public static void main(String[] args) {
//        int arr[] = {2,8,30,15,25,12};
//        int arr[] = {30,20,10};
//        int arr[] = {10,20,30};
        int arr[] = {6,18,4,5};
        printTheCeilingElements(arr);
    }

    private static void printTheCeilingElements(int[] arr) {
        final TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int i=0; i<arr.length; i++){
            Integer ceiling = treeSet.higher(arr[i]);
            System.out.print((ceiling == null ? -1 : ceiling) + " ");
            treeSet.add(arr[i]);
        }
    }
}
