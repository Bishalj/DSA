package crack_google.gfg.bitwise;

public class KthSetBit {
	public static void main(String[] args) {
		int num = 5, k = 1;
		System.out.println(isKthBiTSet(num, k));
		System.out.println(isKthBiTSet(2, 1));
		System.out.println(isKthBiTSet(8, 2));
		System.out.println(isKthBiTSet(0, 3));
	}

	private static boolean isKthBiTSet(int num, int k) {
		k--;
		return (num & (1<<k)) != 0;
	}
}
