import java.math.BigInteger;

public class Palindrome {
	public static void main(String[] args) {
		String palindrome = "1236";
		System.out.println("1236 --> " + getNextPalindrome(palindrome));
		System.out.println("94187978322 --> "+ getNextPalindrome("94187978322"));
		System.out.println("999 --> "+ getNextPalindrome("999"));
		System.out.println("1221 --> "+ getNextPalindrome("1221"));
		System.out.println("1234 --> "+ getNextPalindrome("1234"));
		System.out.println("83422869 --> "+ getNextPalindrome("83422869"));
		System.out.println("783322 --> "+ getNextPalindrome("783322"));
		System.out.println("125322 --> "+ getNextPalindrome("125322"));
		System.out.println("14587678322 --> "+ getNextPalindrome("14587678322"));
		System.out.println("12921 --> "+ getNextPalindrome("12921"));
		System.out.println("713322 --> "+ getNextPalindrome("713322"));
		System.out.println("1234628 --> "+ getNextPalindrome("1234628"));
		System.out.println("94187978322 --> "+ getNextPalindrome("94187978322"));
		System.out.println("3 --> "+ getNextPalindrome("3"));
		System.out.println("0 --> "+ getNextPalindrome("0"));
		System.out.println("1999 --> "+ getNextPalindrome("1999"));
		System.out.println("998 --> "+ getNextPalindrome("998"));
		System.out.println("9999 --> "+ getNextPalindrome("9999"));
		System.out.println("-------------------------------------------------------------------------");

		System.out.println("1236 --> " + getNextPalindromeGfg(palindrome));
		System.out.println("94187978322 --> "+ getNextPalindromeGfg("94187978322"));
		System.out.println("999 --> "+ getNextPalindromeGfg("999"));
		System.out.println("1221 --> "+ getNextPalindromeGfg("1221"));
		System.out.println("1234 --> "+ getNextPalindromeGfg("1234"));
		System.out.println("83422869 --> "+ getNextPalindromeGfg("83422869"));
		System.out.println("783322 --> "+ getNextPalindromeGfg("783322"));
		System.out.println("125322 --> "+ getNextPalindromeGfg("125322"));
		System.out.println("14587678322 --> "+ getNextPalindromeGfg("14587678322"));
		System.out.println("12921 --> "+ getNextPalindromeGfg("12921"));
		System.out.println("713322 --> "+ getNextPalindromeGfg("713322"));
		System.out.println("1234628 --> "+ getNextPalindromeGfg("1234628"));
		System.out.println("94187978322 --> "+ getNextPalindromeGfg("94187978322"));
		System.out.println("3 --> "+ getNextPalindromeGfg("3"));
		System.out.println("0 --> "+ getNextPalindromeGfg("0"));
		System.out.println("1999 --> "+ getNextPalindromeGfg("1999"));
		System.out.println("998 --> "+ getNextPalindromeGfg("998"));
		System.out.println("9999 --> "+ getNextPalindromeGfg("9999"));

		System.out.println("94187978322 --> "+ getNextPalindrome("94187978322").equals(getNextPalindromeGfg("94187978322")));
		System.out.println("999 --> "+ getNextPalindrome("999").equals(getNextPalindromeGfg("999")));
		System.out.println("1221 --> "+ getNextPalindrome("1221").equals(getNextPalindromeGfg("1221")));
		System.out.println("1234 --> "+ getNextPalindrome("1234").equals(getNextPalindromeGfg("1234")));
		System.out.println("83422869 --> "+ getNextPalindrome("83422869").equals(getNextPalindromeGfg("83422869")));
		System.out.println("783322 --> "+ getNextPalindrome("783322").equals(getNextPalindromeGfg("783322")));
		System.out.println("125322 --> "+ getNextPalindrome("125322").equals(getNextPalindromeGfg("125322")));
		System.out.println("14587678322 --> "+ getNextPalindrome("14587678322").equals(getNextPalindromeGfg("14587678322")));
		System.out.println("12921 --> "+ getNextPalindrome("12921").equals(getNextPalindromeGfg("12921")));
		System.out.println("713322 --> "+ getNextPalindrome("713322").equals(getNextPalindromeGfg("713322")));
		System.out.println("1234628 --> "+ getNextPalindrome("1234628").equals(getNextPalindromeGfg("1234628")));
		System.out.println("94187978322 --> "+ getNextPalindrome("94187978322").equals(getNextPalindromeGfg("94187978322")));
		System.out.println("3 --> "+ getNextPalindrome("3").equals(getNextPalindromeGfg("3")));
		System.out.println("0 --> "+ getNextPalindrome("0").equals(getNextPalindromeGfg("0")));
		System.out.println("1999 --> "+ getNextPalindrome("1999").equals(getNextPalindromeGfg("1999")));
		System.out.println("998 --> "+ getNextPalindrome("998").equals(getNextPalindromeGfg("998")));
	}

	private static String getNextPalindrome(String palindrome) {
		int mid = (palindrome.length()+1)/2;
		String finalNum = "";
		String even = palindrome.substring(0, mid);
		if(palindrome.length()%2==0){
			finalNum = even + (new StringBuffer(even).reverse());
		}else{
			finalNum = even + (new StringBuffer(even.substring(0, mid-1)).reverse());
		}

		if(Long.parseLong(finalNum) <= Long.parseLong(palindrome)){
			String intialString = String.valueOf(Long.parseLong(even)+1);
			String num = intialString;
			if(num.length() > even.length())
				num = num.substring(0,num.length()-1);
			String lastNum;
			if(palindrome.length()%2==0)
				lastNum = new StringBuilder(num).reverse().toString();
			else
				lastNum = new StringBuilder(num.substring(0, num.length()-1)).reverse().toString();
			finalNum = intialString+lastNum;
		}
		return finalNum;
	}

	private static String getNextPalindromeGfg(String palindrome) {
		if(isAllNine(palindrome))
			return "1" + getZero(palindrome.length()-1) + "1";
		int mid = (palindrome.length()+1)/2;
		int left = ((palindrome.length())/2)-1;
		int right = palindrome.length()%2==0? left+1:left+2;
		String newNum = palindrome.substring(0,mid);
		while (left >= 0 && palindrome.charAt(left) == palindrome.charAt(right)) {
			left--;
			right++;
		}

		if (left<0 || palindrome.charAt(left) < palindrome.charAt(right))
			newNum = String.valueOf(new BigInteger(newNum).add(new BigInteger("1")));


		if(palindrome.length()%2==0)
			return newNum + new StringBuilder(newNum).reverse();
		return newNum + new StringBuilder(newNum.substring(0, newNum.length()-1)).reverse();
	}

	private static String getZero(int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= len; i++) {
			sb.append("0");
		}
		return sb.toString();
	}

	private static boolean isAllNine(String palindrome) {
		for (int i = 0; i < palindrome.length(); i++) {
			if(palindrome.charAt(i) != '9')
				return false;
		}
		return true;
	}
}
