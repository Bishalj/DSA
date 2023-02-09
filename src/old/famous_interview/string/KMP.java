package old.famous_interview.string;

import old.utils.CommonUsedUtils;

public class KMP {

  public static void main(String[] args) {
	  String s = "aaaaab";
	  String pattern = "aaaa";
	  findOccurrence(s, pattern);
	  System.out.println("--------------------------------------------------------");
	  findOccurrence("ababcababaad", "ababa");
  }

	private static void findOccurrence(String s, String pattern) {
		int lps[] = getLpsArray(pattern);
		CommonUsedUtils.displayArray(lps);
		int index=0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == pattern.charAt(index)){
				if(index == pattern.length()-1){
					System.out.println("("+(i-index) + ", " + i + ")");
					index = lps[index];
				}else {
					index++;
				}
			}else {
				index = 0;
			}
		}
	}

	private static int[] getLpsArray(String pattern) {
		int lps[] = new int[pattern.length()];
		for(int i=1; i<lps.length; i++){
			if(pattern.charAt(lps[i-1]) == pattern.charAt(i))
				lps[i] = lps[i-1] + 1;
		}
		return lps;
	}
}
