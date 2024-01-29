package crack_google.gfg.recursion;

public class GenerateSubSet {

	public static void main(String args[]){
		StringBuffer sb = new StringBuffer();
		printSubset("ABC".split(""), 0, sb);
	}

	private static void printSubset(String[] str, int pos, StringBuffer sb) {
		if(pos == str.length) {
			System.out.println(sb.toString());
			return;
		}
		printSubset(str, pos+1, new StringBuffer(sb).append(str[pos]));
		printSubset(str, pos+1, new StringBuffer(sb));

	}
}
