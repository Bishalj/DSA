package crack_google.gfg.mathematics;

import static crack_google.gfg.mathematics.PrimeFactors.isPrime;

public class AllPrimeDivisors {
	public static void main(String[] args) {
		int num = 100;
		printAllPrimeDivisors(num);
	}

	private static void printAllPrimeDivisors(int num) {
		StringBuilder sb = new StringBuilder();
		if(num >= 2)
			sb.append(2).append(" ");
		if(num >= 3)
			sb.append(3).append(" ");
		for(int i=5; i<=num; i+=6){
			if(isPrime(i))
				sb.append(i).append(" ");
			if(isPrime(i+2))
				sb.append(i+2).append(" ");
		}
		System.out.println(sb);
	}
}
