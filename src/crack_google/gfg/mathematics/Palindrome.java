package crack_google.gfg.mathematics;

public class Palindrome {
	public static void main(String[] args) {
		int number = 12344321;
		System.out.println(isPalindrome(number));
		System.out.println(isPalindrome(1234564321));
	}

	private static boolean isPalindrome(int number){
		int num = number, reverseNumber = 0;
		while (num > 0){
			reverseNumber =	reverseNumber*10 + num%10;
			num/=10;
		}
		return number == reverseNumber;
	}
}
