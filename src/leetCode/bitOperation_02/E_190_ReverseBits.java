package leetCode.bitOperation_02;

/**
 * 位运算，(n & 1)可以判断奇偶
 */
public class E_190_ReverseBits {

    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) res++;
            n >>= 1;
        }
        return res;
    }

}
