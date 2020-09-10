package leetCode.bitOperation_02;

public class E_136_SingleNumber_XOR {

    /**
     * 位运算
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
