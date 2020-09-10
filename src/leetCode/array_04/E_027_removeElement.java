package leetCode.array_04;

import java.util.Arrays;

public class E_027_removeElement {

    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[res++] = nums[i];
            }
        }

//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == val) {
//                 continue;
//             }
//             nums[res++] = nums[i];
//        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int res = removeElement(nums, 3);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }
}
