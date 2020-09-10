package algorithm.stack;

/**
 * 解释栈和递归
 */
public class StackRecursion {

    public static void test() {
        test1();
    }

    public static void test1() {
        System.out.println("第一个调用");
        test2();
        System.out.println("第一个调用结束");
    }

    public static void test2() {
        System.out.println("第二个调用");
        test3();
        System.out.println("第二个调用结束");
    }

    public static void test3() {
        System.out.println("第三个调用");
        System.out.println("第三个调用结束");
    }

    /**
     * 尾递归
     */
    public static int f(int num) {
        if (num == 1) {
            return 1;
        }
        return f(num - 1);

    }

    /**
     * 不是尾递归
     * @param num
     * @return
     */
    public static int f2(int num) {
        if (num == 1) {
            return 1;
        }
        return 1 + f(num - 1);

    }

    public static void main(String[] args) {
        test();
    }
}
