package leetCode.math_03;

public class M_264_UglyNumberII {
    /**
     * 超时
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int count = 2;
        int num = 0;
        int res = 2;
        if (n == 1) return 1;
        while (count <= n) {
            num = res;
            for (int i = 2; i < 6; i++) {
                while (num % i == 0) {
                    num /= i;
                }
            }
            if (num == 1) {
                count++;
                res++;
            } else {
                res++;
            }
        }
        return res - 1;
    }

    /**
     * 通过
     * Time O(n)
     * Space O(n)
     * @param n
     * @return
     */
    //(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
    //(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
    //(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
    public int nthUglyNumber1(int n) {
        // i : 0  1  2  3  4  5  6  7  8  9  10
        //     1  2  3  4  5  6  8  9  10 12 14
        // factor1 : 2 4 6 8 10 12 14
        // index1  : 0 1 2 3 4  5  6
        // factor2 : 3 6 9 12 15
        // index2  : 0 1 2 3  4
        // factor3 : 5 10 15
        // index3  : 0 1  2

        int[] nums = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if (nums[i] == nums[index2] * 2) index2++;
            if (nums[i] == nums[index3] * 3) index3++;
            if (nums[i] == nums[index5] * 5) index5++;

        }
        return nums[n - 1]; //要取第n个数，在数组中是n-1
    }

}
