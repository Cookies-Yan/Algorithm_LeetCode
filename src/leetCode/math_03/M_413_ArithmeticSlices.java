package leetCode.math_03;

public class M_413_ArithmeticSlices {
    /**
     * Time O(n)
     * Space O(1)
     * 数组            等差数列的数目         与上一数组的等差数列数目比较
     * 1 2 3                1                     1 - 0 = 1
     * 1 2 3 4              3                     3 - 1 = 2
     * 1 2 3 4 5            6                     6 - 3 = 3
     * 1 2 3 4 5 6         10                    10 - 6 = 4
     * 1 2 3 4 5 6 7       15                    15 - 10 = 5
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr++;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
