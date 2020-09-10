package algorithm.stack;


public class StackIteration {

    public static int sum;

    /**
     * 单个递归可以用while转化成迭代
     * 用stack也可以，但是while更简单
     * @param num
     */
    public static void sumOfN(int num) {
        if (num == 0) {
            return;
        }
        sum += num;
        //尾递归
        sumOfN(num - 1);
    }

    public static int sumOfN2(int num) {
        if (num == 0) {
            return 0;
        }
        //不是尾递归
        return num + sumOfN2(num - 1);
    }

    public static int iteration(int num) {
        int sum = 0;
//        int n = 1;
        while (1 <= num) {
            sum += num;
            num--;
        }
        return sum;
    }

    /**
     * 并列递归，一般在图的算法中利用， DFS
     * 例子：preOrder
     * 从递归转换成迭代用stack的方式进行转换.
     * @param args
     */

    /**
     * 多个递归climbStairs题目， 递归+递归
     * 转化成迭代，比较复杂
     * @param args
     */


    public static void main(String[] args) {
        System.out.println(sumOfN2(10));
        System.out.println(iteration(10));
    }

}
