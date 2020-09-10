package leetCode.math_03;

/**
 * Time O(sqrt(n))
 * Space O(1)
 */
public class E_507_PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int res = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res += i + num / i;
            }
        }
        return res == num;
    }
}
