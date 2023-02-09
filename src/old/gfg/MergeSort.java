package old.gfg;

public class MergeSort {

    int inversionCount = 0;
    private void merge(int low, int mid, int high, int arr[]){
        int n1 = mid - low + 1, n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i=0; i<n1; i++)
            left[i] = arr[low+i];

        for(int i=0; i<n2; i++)
            right[i] = arr[mid + i + 1];

        int i=0,j=0,k=low;
        while(i<n1 && j<n2){
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else{
                arr[k++] = right[j++];
                inversionCount++;
            }
        }

        while(i<n1)
            arr[k++] = left[i++];

        while(j<n2)
            arr[k++] = right[j++];

//        printArray(arr);
    }


    public void sort(int low, int high, int[] arr){
        if(low < high){
            int mid = (low+high)/2;
            sort(low, mid, arr);
            sort(mid+1, high, arr);
            merge(low, mid, high, arr);
//            mergeArray(arr, low, mid, high);

        }
    }

  public static void main(String[] args) {
        int arr[] = {2,4,1,3,5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort( 0, arr.length-1, arr);
        printArray(arr);
    System.out.println("inversion count : " + mergeSort.inversionCount);
  }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}



class MergeSortInversion {

    int inversionCount = 0;
    private int merge(int low, int mid, int high, int arr[]){
        int n1 = mid - low + 1, n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i=0; i<n1; i++)
            left[i] = arr[low+i];

        for(int i=0; i<n2; i++)
            right[i] = arr[mid + i + 1];

        int i=0,j=0,k=low;
        while(i<n1 && j<n2){
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else{
                arr[k++] = right[j++];
                inversionCount += n1 - i;
            }
        }

        while(i<n1)
            arr[k++] = left[i++];

        while(j<n2)
            arr[k++] = right[j++];

        return inversionCount;
    }


    public int sort(int low, int high, int[] arr){
        int res = 0;
        if(low < high){
            int mid = (low+high)/2;
            res += sort(low, mid, arr);
            res += sort(mid+1, high, arr);
            return res + merge(low, mid, high, arr);
//            mergeArray(arr, low, mid, high);

        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {40, 30, 20 ,10};
        MergeSortInversion mergeSort = new MergeSortInversion();
        mergeSort.sort( 0, arr.length-1, arr);
        printArray(arr);
        System.out.println("inversion count : " + mergeSort.inversionCount);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
