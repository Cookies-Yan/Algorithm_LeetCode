package laiClass.class_02_recursive_binary;

public class recursive {

    /**
     * 基础斐波那切数列
     * @param n
     * @return
     */
    public int fibo (int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibo(n - 1) + fibo(n - 2);
    }


    /**
     * 变形1
     * Q2: Example question: how to calculate a^b(Where a is an integer and b is also an integer,
     * we do not care about the corner case where a = 0 or b < 0 for now)
     *
     * Time O(logb)
     * Space O(logb)
     */
    public int powerable(int a, int b) {
        if (b == 0) return 1;
        int half_res = powerable(a, b / 2);
        if (b % 2 == 0) {
            return half_res * half_res;
        } else {
            return half_res * half_res * a;
        }
    }

    public static void main(String[] args) {
        recursive a = new recursive();
        System.out.println(a.fibo(11));
        System.out.println(a.powerable(2,10));
    }
}
