package leetCode.math_03;

public class NotIm_M_390_EliminationGame {
    /**
     * Time O(logn)
     * Space O(1)
     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int res = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                res = res + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return res;
    }
}
