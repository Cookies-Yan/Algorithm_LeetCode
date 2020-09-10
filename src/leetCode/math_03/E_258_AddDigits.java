package leetCode.math_03;

public class E_258_AddDigits {

    public int addDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        boolean go = true;
        while (go) {
            sum = sum + num % 10;
            num /= 10;
            if (num == 0) {
                if (sum < 10) {
                    go = false;
                } else {
                    num = sum;
                    sum = 0;
                }
            }
        }
        return sum;
    }
}
