package old.Arrays;

import java.util.ArrayList;

public class LeadersInAnArray {

    public static void main(String[] args) {
        int arr[] = {4 ,1 ,4};
        System.out.println(leaders(arr, arr.length).toString());
    }

    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        if(n <= 0)
            return arrList;

        int max = arr[n-1];
        arrList.add(max);
        for(int i=n-2; i>=0; i--){
            if(arr[i] >= max){
                max = arr[i];
                arrList.add(0, max);
            }
        }
        return arrList;
    }
}
