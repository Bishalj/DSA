package crack_google.gfg.mathematics;

public class Power {
	public static void main(String[] args) {
		int num = 5, power = 6;
		System.out.println(computePower(num,power));

	}

	private static int computePower(int num, int power) {
		if(power == 0)
			return 1;
		else if(power == 1)
			return num;
		else if(power%2 != 0)
			return num*computePower(num, power-1);
		else
			return computePower(num,power/2)*computePower(num, power/2);
	}
}
