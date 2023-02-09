package old.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Test {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        int numberOfQueries = Integer.parseInt(br.readLine());
        int intArray[] = new int[arraySize];

        for(int i=0; i<arraySize; i++)
            intArray[i] = Integer.parseInt(array[i]);

        for(int i=0; i<numberOfQueries; i++){
            String query[] = br.readLine().split(" ");

            if("UPDATE".equalsIgnoreCase(query[0]))
                intArray[Integer.parseInt(query[1])-1] = Integer.parseInt(query[2]);
            else if("Increment".equalsIgnoreCase(query[0]))
                intArray[Integer.parseInt(query[1])-1] = intArray[Integer.parseInt(query[1])-1] + 1;
            else if("?".equalsIgnoreCase(query[0]))
                System.out.println(intArray[Integer.parseInt(query[1])-1]);
            else if("Left".equalsIgnoreCase(query[0]))
                leftRotateArrayByOne(intArray);
            else if("Right".equalsIgnoreCase(query[0]))
                rightRotateArrayByOne(intArray);
        }


    }

    static void leftRotateArrayByOne(int arr[])
    {
        int firstElement = arr[0];
        for(int i=0 ;i<arr.length-1; i++)
            arr[i] = arr[i+1];
        arr[arr.length-1] = firstElement;
    }

    static void rightRotateArrayByOne(int arr[])
    {
        int lastElement = arr[arr.length-1];
        for(int i=arr.length - 1 ;i>0; i--)
            arr[i] = arr[i-1];
        arr[0] = lastElement;
    }
}
