package leetCode.math_03;

/**
 * Time O(logn)
 * Space O(n)
 * 2 * 5 = 10
 * 5出现的次数必定比2少，所以有多少5 就有多少零
 *
 */
public class E_172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 :n / 5 + trailingZeroes(n / 5);
    }
}
