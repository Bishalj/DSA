package Arrays;

public class LongSubOfEvenOdd {

    public static void main(String[] args) {
        int array[] = {88,28,19,94,57,90,84,14,50,9,25,69,93,18,70,25,24,29,47,50,14,87,72,14,65,50,68,30,68,60,37,79,93,87,63};
        System.out.println(maxEvenOdd(array, array.length));
    }
    public static int maxEvenOdd(int arr[], int n)
    {
        int maxCount = 0;
        int temoCount = 0;
        boolean considerEvenElement = true;
        for (int i=0; i<arr.length; i++){
            if(considerEvenElement){
                if(arr[i]%2 == 0){
                    considerEvenElement = false;
                    temoCount++;
                }else {
                    if(temoCount > maxCount)
                        maxCount = temoCount;
                    temoCount = 1;
                }
            }
            else{
                if(arr[i] %2 != 0){
                    considerEvenElement = true;
                    temoCount++;
                }else {
                    considerEvenElement = false;
                    if(temoCount > maxCount)
                        maxCount = temoCount;
                    temoCount = 1;
                }
            }

        }
        if(temoCount > maxCount)
            maxCount = temoCount;
        return maxCount;
    }
}
