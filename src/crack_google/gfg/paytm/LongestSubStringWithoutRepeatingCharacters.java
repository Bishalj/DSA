package crack_google.gfg.paytm;

/*
* Input = abcabcab
* map
* a,0
* b,1
* c,2
*
*
*
*
*
*
* pos = 1, current = 4
* result = current - pos
* */

import crack_google.gfg.utility.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(getMaxIndex("abcabcab"));
		System.out.println(getMaxIndex("bbbbb"));
		System.out.println(getMaxIndex("pwwkew"));
	}

	private static int getMaxIndex(String ss) {
		int[] repeatedIndex = new int[ss.length()];
		int maxIndex = 0;
		Map<Character, Integer> repeatedCharacterIndexMap = new HashMap<>();
		for(int i = 0; i< ss.length(); i++){
			char ch = ss.charAt(i);
			repeatedIndex[i] = repeatedCharacterIndexMap.getOrDefault(ch, -1);
			repeatedCharacterIndexMap.put(ch, i);
		}
		ArrayUtils.display(repeatedIndex);
		int prev = -1;
		for(int i=0; i<repeatedIndex.length; i++){

			if(repeatedIndex[i] > prev)
				prev = repeatedIndex[i];
			maxIndex = Math.max(maxIndex, i-prev);
		}
		return maxIndex;
	}
}
