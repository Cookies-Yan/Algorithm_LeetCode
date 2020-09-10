package leetCode.binarySearch_05;

import java.util.Arrays;

public class BinarySearch {

    /**
     * 递归二分查找
     *  Time: O(logn)
     *  Space: O(logn)
     * @return
     */
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (high < low) {
            return -1;
        }
        /**
         * 一般不写(left + right) / 2 因为会越界
         */
        int mid = low + (high - low) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, high, target);
        } else {
            return mid;
        }

    }

    /**
     * Java源码采用的方法
     * 迭代写法， left <= right
     * 最终结果应该是: right < target < left
     *               right + 1 = left
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1; //[left, right]
        /**
         * 都是以闭区间去走的
         * 只有 right < left才能结束
         */
        while (left <= right) {      //left = right 还是执行的
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {   // [left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;         //[mid + 1, right]
            } else {
                return mid;
            }
            System.out.println("mid: " + nums[mid] + " left: " +nums[left] + " right: " + nums[right]);
        }
        System.out.println("第一种 left : " + left + " right : " + right);
        return -1;
    }

    /**
     *
     * *******最好倾向于这种*********
     *
     *
     * 迭代写法， left < right
     * 最终结果应该是: target < left = right
     *               left = right
     *
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        /**
         * 如果是nums.legnth - 1的话，最后一个元素是找不到的，也就是[1,2,3], 3是找不到的
         * 因为尽管index走到了最后一个，但是没有进入while语句进行判断，
         * 可以加最后加一行if(nums[right] == target)来弥补
         */
        int right = nums.length;  //[left, right)
        while (left < right) {    // left = right 才不执行
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {   // [left, mid)
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;         //[mid + 1, right)
            } else {
                return mid;
            }
            System.out.println("mid: " + nums[mid] + " left: " +nums[left] + " right index : " + right);
        }
        System.out.println("第二种 left : " + left + " right : " + right);
        return -1;
    }

    /**
     * 迭代写法， left  + 1 < right
     * 最终结果应该是: left < target < right
     *               left + 1 = right
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;      //[left, right], 用了闭区间也不用 mid + 1 或者 - 1
        while (left + 1 < right) {       // 例子 : [1, 2, 3]
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {     // [left, mid]
                right = mid;
            } else if (nums[mid] < target) {  // [ mid, right]
                left = mid;
            } else {
                return mid;
            }
            System.out.println("mid: " + nums[mid] + " left: " +nums[left] + " right: " + nums[right]);
        }
        //因为一旦相邻，就没有办法进行判断， 1，2，3. left是2的话 2 + 1 !< 3
        /**
         * 相邻即为直接相邻，如 一共2个数(1，2) 找1或者2
         */
        if (target == nums[left]) {
            return left;
        } else if (target == nums[right]) {
            return right;
        }
        System.out.println("第三种 left : " + left + " right : " + right);
        return -1;

    }



    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 5, 9, 10};
        System.out.println(Arrays.toString(nums) + " target: 6");
        binarySearch3(nums, 6);
    }

}
