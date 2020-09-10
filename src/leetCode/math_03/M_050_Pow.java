package leetCode.math_03;

public class M_050_Pow {
    /**
     * 递归
     * Time O(logn)
     * Space O(n)
     * eg. 2^2 = 2^1 * 2^1 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) = (1 * 1 * 2) * (1 * 1 * 2) = 4
     * eg. 2^3 = 2^1 * 2^1 * 2 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) * 2 = (1 * 1 * 2) * (1 * 1 * 2) * 2 = 8
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1.0 / pow(x, n);
        }
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
    /**
     * 迭代
     * Time O(logn)
     * Space O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        //int : -6..~ +6.. -2^32 ~ 2^32-1 Integer.MAX_VALUE;
        long abs = Math.abs((long)n); //防止越界
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }
}
