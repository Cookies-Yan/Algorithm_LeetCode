package leetCode.math_03;

/**
 * 二分法
 * Time O(logn) Space O(1)
 */
public class E_367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        return false;
    }

    /**
     * x*x > num
     * 写法上x*x更简便，但复杂度sqrt是大于logn的解法，注意
     * Time O(sqrt(n)) Space O(1)
     */
    public boolean isPerfectSquare1(int num) {
        if (num < 0) return false;
        if (num == 1) return true;
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) return true;
        }
        return false;
    }

    /**
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * @param num
     * @return
     */
    public boolean isPerfectSquare3(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /**
     * 牛顿法
     */
    public boolean isPerfectSquare2(int num) {
            long x = num;
            while (x * x > num) {
                x = (x + num / x) / 2;
            }
            return x * x == num;
    }
}
