package leetCode.dynamic_18;

import java.util.Arrays;

public class E_509_FibonacciNumber {

    /**
     * 递归，有大量重复计算
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    //数组最大长度为15464691，不是max
//    static int[] memorization = new int[15464691];
    //时间换空间优化算法，中间做了存储
    static int[] memorization = new int[10];
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        if ( memorization[N] == 0) {
            memorization[N] = fib2(N - 1) + fib2(N - 2);
        }
        System.out.println(Arrays.toString(memorization));
        return memorization[N];
    }

    public int fib3(int N) {

        if (N < 1) {
            return N;
        }
        /**
         * 从f(0) 求到 f(n)， 需要N + 1个数字
         */
        int[] dp = new int[N + 1];
        dp[1] = 1; //f(0) = 0, f(1) = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public int fib4(int N) {
        if (N < 1) {
            return N;
        }
        int a = 0, b = 1;
        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        E_509_FibonacciNumber a = new E_509_FibonacciNumber();
        a.fib2(5);

    }
}
