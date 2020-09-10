package leetCode.bitOperation_02;
/**
 * 特殊考察
 * 两种写法： 1. 位运算 2.数学解法
 */
public class M_397_IntegerReplacement {
    /**
     * 如果倒数第二位是0，那么n-1的操作比n+1的操作能消耗更多的1
     * 1001 + 1 = 1010
     * 1001 - 1 = 1000
     * 如果导数第二位是1，那么n+1的操作能比n-1的操作消掉更多的1
     * 1011 + 1 = 1100
     * 1111 + 1 = 10000
     *
     * 3比较特殊
     * 一个是减1, 3 2 1
     * 一个是加1，4 2 1
     */
    public int integerReplacement1(int n) {
        //防止越界
        long N = n;
        int res = 0;
        while (N != 1) {

            if (N % 2 == 0) {
                N >>= 1;
            } else {
                if (N == 3) {
                    res += 2;
                    break;
                }
                N = (N & 2) == 2 ? N + 1 : N - 1;
            }
            res++;
        }
        return res;

    }

    /**
     * 同上
     * Time : 小于O(n) : 接近logn
     * Space : O(1)
     * n = 2k + 1
     *
     * n + 1 = (2k + 2) / 2 : k + 1
     * n - 1 = 2k / 2 : k
     *
     * 9:
     *   +1 10->5
     *   -1  8->4->2
     *   可以直接除以4
     *
     * @param n
     * @return
     */
    public int integerReplacement2(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        int res = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                //n - 1 != 2还是对3进行处理
                if ( (n + 1) % 4 == 0 && (n - 1 != 2)) {
                    n++;
                } else {
                    n--;
                }
            }
            res++;
        }
        return res;
    }

}
