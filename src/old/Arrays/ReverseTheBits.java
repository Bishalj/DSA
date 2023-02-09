package old.Arrays;

public class ReverseTheBits {
    public static int reverseBits(int n)
    {
        int rev = 0;

        // traversing bits of 'n'
        // from the right
        while (n > 0)
        {
            // bitwise left shift
            // 'rev' by 1
            System.out.println("Before rev <<= 1 -> "+ rev);
            rev <<= 1;
            System.out.println("After rev <<= 1 -> "+ rev);
            // if current bit is '1'
            if ((int)(n & 1) == 1)
                rev ^= 1;

            // bitwise right shift
            //'n' by 1
            n >>= 1;
        }
        // required number
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(11));
    }
}
