package prepare.bit;

public class TwoOdd {
	public int[] singleNumber(int[] nums) {
		int bitValue = 0;
		for (int data : nums)
			bitValue ^= data;

		int x = bitValue & ~(bitValue - 1);
		int res1 = 0, res2 = 0;
		for (int data : nums)
			if ((x & data) != 0)
				res1 ^= data;
			else
				res2 ^= data;

		return new int[]{res1, res2};
	}
}
