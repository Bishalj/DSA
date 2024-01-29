package crack_google.gfg.utility;

public class Sol {
	public static void main(String[] args) {
		String num = "12345";
		System.out.println(nextPalindromeNumber(num));
		System.out.println(nextPalindromeNumber("123"));
		System.out.println(nextPalindromeNumber("1099901"));
		System.out.println(nextPalindromeNumber("1000"));
		System.out.println(nextPalindromeNumber("99"));
		System.out.println(nextPalindromeNumber("99999"));
		System.out.println(nextPalindromeNumber("99899"));
		System.out.println(nextPalindromeNumber("9"));
		System.out.println(nextPalindromeNumber("3"));

	}

	private static long nextPalindromeNumber(String num) {
		String arr[] = num.split("");
		int mid = (arr.length+1)/2;
		long value = Long.parseLong(num.substring(0, mid));
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("9")) {
                count++;
            }
        }
		if(count == num.length()){
			return Long.parseLong(new StringBuffer("1").append("0".repeat(num.length()-1)).append("1").toString());
		}
		Long result = getResult(num, value);
		if(result > Long.parseLong(num))
			return result;
		return getResult(num, value+1);
	}

	private static long getResult(String num, long value) {
		StringBuffer first = new StringBuffer(String.valueOf(value));
		long size = num.length();
		StringBuffer sb;
		if(size %2 != 0)
			sb = new StringBuffer(first.substring(0, first.length()-1));
		else
			sb = new StringBuffer(first);
		return Long.parseLong(first.append(sb.reverse()).toString());
	}
}
