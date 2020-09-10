package leetCode.math_03;

public class E_204_CountPrimes {

    /**
     * 厄拉多塞筛法，求一组质数，时间复杂度仅有O(nloglogn)
     * 如果从1到n-1分别判断质数，时间复杂度为O（nsqrt(n)）
     * 1,  2,  3,  4,  5,  6,  7,  8,  9,  10
     * 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
     * @param n
     * @return
     *
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }
}
