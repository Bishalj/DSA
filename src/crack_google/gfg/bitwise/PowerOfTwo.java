package crack_google.gfg.bitwise;

public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(5));
		System.out.println(isPowerOfTwo(2));
		System.out.println(isPowerOfTwo(4));
		System.out.println(isPowerOfTwo(8));
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(32));
		System.out.println(isPowerOfTwo(64));
		System.out.println(isPowerOfTwo(128));
		System.out.println(isPowerOfTwo(256));
		System.out.println(isPowerOfTwo(512));
		System.out.println(isPowerOfTwo(511));
		System.out.println(isPowerOfTwo(411));
		System.out.println(isPowerOfTwo(5241));
		System.out.println(isPowerOfTwo(2111));
		System.out.println(isPowerOfTwo(5414));
		System.out.println(isPowerOfTwo(511));


	}

	private static boolean isPowerOfTwo(int num) {
		return (num&(num-1)) == 0;
	}
}
