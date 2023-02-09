package old.graph;

public class CollapseRoad {

    public static void main(String[] args) {
        System.out.println("A");
        int a[][] ={
                {1,2},
                {2,3}
    };
        int arr[] = Solution(3,2,a);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args) {
        System.out.println("B");
    }

    static int[] Solution(int N, int M, int[][] roads){
        // Write your code here
        int maxNumberOfRoads = (N*(N-1)/2) - M;

        int result[] = new int[M];
        for(int i=0; i<M; i++) {
            result[i] = ++maxNumberOfRoads;
        }
        return result;
    }
}
