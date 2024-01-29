package crack_google.uber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

	}
}


class Solution {
	Set<String> set = new HashSet();
	public boolean wordBreak(String s, List<String> wordDict) {
		if(s.length() == 0)
			return true;
		else if(set.contains(s))
			return false;
		for(String word: wordDict){
			if(s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict))
				return true;
		}
		set.add(s);
		return false;
	}
}