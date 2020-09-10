package leetCode.bitOperation_02;

public class E_231_PowerOfTwo {
    /**
     * 与操作
     * (n & (n - 1))
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

}
