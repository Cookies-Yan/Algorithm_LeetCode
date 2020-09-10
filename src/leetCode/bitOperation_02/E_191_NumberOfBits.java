package leetCode.bitOperation_02;

public class E_191_NumberOfBits {
    /**
     * n &= (n - 1)最低位1改为0
     *
     * (n & (n - 1))
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    /**
     * 判断奇偶数 n & 1(返回1表示奇数，0表示偶数)
     * 末尾取1
     * 而>>=和<<=，就是对变量进行位运算移位之后的结果再赋值给原来的变量，可以类比赋值运算符+=和-=可以理解。
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {

            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
