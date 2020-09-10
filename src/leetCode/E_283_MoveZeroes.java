package leetCode;

public class E_283_MoveZeroes {

    /**
     * 最优算法
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    /**
     * 自己写的算法，时间复杂度较高
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        for(int i = nums.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++){
                if(nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
