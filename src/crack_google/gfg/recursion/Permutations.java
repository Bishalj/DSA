package crack_google.gfg.recursion;

public class Permutations {
	public static void main(String[] args) {
		String s = "ABC";
		printPermutations(s, 0);
	}

	private static void printPermutations(String s, int i) {
		if(i == s.length()-1)
			System.out.println(s);
        else {
			for (int j = i; j < s.length(); j++) {
				String swappedText = swapString(i, j, s);
				printPermutations(swappedText, i + 1);
			}
		}
	}

	private static String swapString(int i, int j, String s) {
		char ch1 = s.charAt(i);
		char ch2 = s.charAt(j);
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(i, ch2);
		sb.setCharAt(j, ch1);
		return sb.toString();
	}
}
