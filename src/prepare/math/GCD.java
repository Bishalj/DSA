package prepare.math;

public class GCD {

	public static void main(String[] args) {
		int a = 26;
		int b = 143;
		System.out.println("GCD : " + findGCD(a, b));
		System.out.println("LCM : " + a*b/findGCD(a, b));
	}

	private static int findGCD(int a, int b) {
		if(b%a==0)
			return a;
		return findGCD(b%a,b);
	}
}
