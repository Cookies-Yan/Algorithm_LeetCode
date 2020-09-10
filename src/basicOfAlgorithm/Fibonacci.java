package basicOfAlgorithm;

public class Fibonacci {

    static int count = 0;

    public static int fibonacci(int num) {
        if(num == 1 || num == 2) {
            return 1;
        } else {
            count++;
            for (int i = 0; i < count; i++) {
                System.out.print("-");
            }
            System.out.println(num);
            return fibonacci(num - 1) + fibonacci(num - 2);
        }

    }

    //数组最大长度为15464691，不是max
    static int[] memorization = new int[15464691];
    //时间换空间优化算法，中间做了存储
    public static int fibonacci2(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        if ( memorization[num] == 0) {
            memorization[num] = fibonacci2(num - 1) + fibonacci2(num - 2);
        }

        return memorization[num];
    }


    public static void main(String[] args) {
        fibonacci(5);
    }
}
