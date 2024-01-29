package crack_google.gfg.recursion;

public class RopeCutting {

	public static void main(String[] args) {
		int n=5,a=2,b=5,c=1;
		System.out.println(getMaxCut(n, a, b, c));
		System.out.println(getMaxCut(23, 12, 9, 11));
		System.out.println(getMaxCut(5, 4, 9, 11));
		System.out.println(getMaxCut(9, 2, 2, 2));
	}

	private static int getMaxCut(int n, int a, int b, int c) {
		if(n == 0)
			return 0;
		if(n < 0)
			return -1;

		int result = Math.max(Math.max(getMaxCut(n-a, a, b, c), getMaxCut(n-b, a, b, c)),getMaxCut(n-c, a, b, c));
		if(result == -1)
			return -1;
		return result+1;
	}
}
