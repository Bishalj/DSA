package old.Arrays;

public class WavePattern {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        convertToWave(arr, arr.length);
    }

    public static void convertToWave(int arr[], int n){
        int loops = n/4;
        if(n%4 != 0)
            loops += 1;
        for(int i=0; i<loops; i++){
            int arrayPosition = i*4;
            int firstPosition = arrayPosition + 2;
            int secondPosition = arrayPosition + 1;
            int thirdPosition = arrayPosition + 4;
            int fourthPosition = arrayPosition + 3;
            if(firstPosition <= n)
                System.out.print(arr[firstPosition-1]+ " ");
            if(secondPosition <= n)
                System.out.print(arr[secondPosition-1]+ " ");
            if(thirdPosition <= n)
                System.out.print(arr[thirdPosition-1]+ " ");
            if(fourthPosition <= n)
                System.out.print(arr[fourthPosition-1]+ " ");
        }
        System.out.println();

    }

    public static void betterConvertToWave(int arr[], int n){
            for(int i=1; i<n; i=i+2){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
        }


}
