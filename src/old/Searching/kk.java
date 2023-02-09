package old.Searching;

import old.utils.CommonUsedUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class kk {

    public static void main(String[] args)throws IOException {
        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int arraySize = Integer.parseInt(br.readLine());
            String array[] = br.readLine().split(" ");
            int intehgerArray[] = getIntegerArray(array);
            int k = Integer.parseInt(br.readLine());
            int numberOfFieldsToBeSorted =k;
            System.out.println(getTheSmallestKthIndexElementUsingQuickSort1  (arraySize, intehgerArray, numberOfFieldsToBeSorted));
        }
    }
    private static int[] getIntegerArray(String[] array) {
        int arr[] =new int [array.length];
        for (int i = 0; i <array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        return arr;
    }

    private static int getTheSmallestKthIndexElementUsingQuickSort1(int arraySize, int[] intehgerArray, int numberOfFieldsToBeSorted) {
        int tmpSum = 0;
        for(int i=0; i<arraySize-numberOfFieldsToBeSorted+1; i++){
            tmpSum += intehgerArray[i];
        }
        int maximumSum = tmpSum;
        int t1,t2,t3;
        t1 = t2 = t3 = tmpSum;
        int tr = tmpSum;
        CommonUsedUtils.displayArray(intehgerArray);
        for(int i=arraySize - numberOfFieldsToBeSorted + 1; i<arraySize; i++) {
            System.out.println("i: "+ i);
            if (intehgerArray[i - (arraySize - numberOfFieldsToBeSorted + 1)] > tmpSum + intehgerArray[i])
                t1 = intehgerArray[i - (arraySize - numberOfFieldsToBeSorted + 1)];
            if (tmpSum < intehgerArray[i])
                t2 = intehgerArray[i];
            if(tmpSum + intehgerArray[i] - intehgerArray[i - (arraySize - numberOfFieldsToBeSorted + 1)] > tmpSum)
                t3 = tmpSum + intehgerArray[i] - intehgerArray[i - (arraySize - numberOfFieldsToBeSorted + 1)];

            if(t1 < t2) {
                if (t1 < t3)
                    tr = t1;
            }

            if(t2 < t3) {
                if (t2 < t1)
                    tr = t2;
            }

            if(t3 < t1) {
                if (t3 < t2)
                    tr = t3;
            }

            if(tr < maximumSum)
                maximumSum = tr;

            tmpSum = tmpSum + intehgerArray[i] - intehgerArray[i - (arraySize - numberOfFieldsToBeSorted + 1)];
        }
        return maximumSum;
    }
}
