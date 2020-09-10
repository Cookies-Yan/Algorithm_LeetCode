package leetCode.bitOperation_02;

public class NotIm_E_371_SumOfTwoInteger {

    /**
     * Time O(1) / O(logn)
     *
     * 1 + 1 = 10
     *
     * 3 : 00011
     * 5 : 00101
     * a : 00110
     * b : 00010
     *
     * 8 : 01000
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
