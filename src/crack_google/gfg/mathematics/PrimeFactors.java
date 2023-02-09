package crack_google.gfg.mathematics;

public class PrimeFactors {
	public static void main(String[] args) {
		int num = 26;
		System.out.println("Process prime number");
		printPrimeFactors(num);
		System.out.println("Process completed");
		printPrimeFactors(12);
		printPrimeFactors(10);
	}

	private static void printPrimeFactors(int num) {
		int value = num;
		for(int i=2; i*i<=num; i++){
			if(isPrime(i)){
				while(value%i == 0){
					System.out.print(i+" ");
					value /= i;
				}
			}
			if(value == 1)
				break;
		}
		if(value > 1)
			System.out.print(value);
		System.out.println();
	}

	public static boolean isPrime(int num) {
		if(num == 1)
			return false;
		else if(num==2 || num==3)
			return true;
		else if(num % 2 == 0 || num % 3 == 0)
			return false;
		for(int i=5; i*i<=num; i+=6){
			if(num%i==0 || num%(i+2)==0)
				return false;
		}
		return true;
	}
}
