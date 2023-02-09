package old.gfg;

import old.utils.CommonUsedUtils;

public class LPSArray {

    private static int[] getLPS(String str){
        if(str.length() == 0)
            return null;
        int arr[] = new int[str.length()];

        for(int i=1; i<str.length(); i++){
            if(str.charAt(arr[i-1]) == str.charAt(i))
                arr[i] = arr[i-1] + 1;
        }
        return arr;
    }

  public static void main(String[] args) {
        String str = "abbabb";
        int lps[] = getLPS(str);
      CommonUsedUtils.displayArray(lps);
  }
}
