package crack_google.gfg.mathematics;

public class IterativePower {
	public static void main(String[] args) {
		int num = 2, power = 4;
		System.out.println(computePowerUsingIterativeMethod(num, power));
	}

	private static int computePowerUsingIterativeMethod(int num, int power) {
		int x = num, prev = 1;
		while(power > 0){
			if(power%2 != 0)
				prev *= x;

			x *= x;
			power >>= 1;
		}
		return prev;
	}
}
