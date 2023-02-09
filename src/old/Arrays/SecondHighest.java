package old.Arrays;

public class SecondHighest {

    public static void main(String[] args) {
        int arr[] = {4, 5, 10, 9, 21, 15, 16};
        int max= arr[0];
        int secondMax = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i] > secondMax){
                secondMax = arr[i];
            }
        }

        System.out.println(secondMax);
    }
}
