package cracking_the_coding_interview.Array_String;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacters {

  public static void main(String[] args) {
	  String s = "abcdert";
	  

	  System.out.println(isWordUnique(s));

	  String s1 = "abcdbjde";
	  System.out.println(isWordUnique(s1));
  }

	private static Boolean isWordUnique(String s) {
		int arr[] = new int[26];
		for(int i = 0; i< s.length(); i++)
			arr[s.charAt(i)-97]++;
		for(int i=0; i<26; i++){
			if(arr[i] >= 2)
				return false;
		}
		return true;
	}
}
