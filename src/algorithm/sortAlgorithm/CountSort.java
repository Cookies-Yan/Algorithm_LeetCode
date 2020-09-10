package algorithm.sortAlgorithm;

import java.util.Arrays;

/**
 * 空间换时间
 * Time(best):O(n);
 *     (avg):O(n+k); k : 整数的范围
 *     (worst):没意义;
 * Space:(k);
 * 稳定性：稳定
 */
public class CountSort {

    public static void CountSort(int[] nums){

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int[] count = new int[max + 1];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]] = count[nums[i]] + 1;
        }
        System.out.println(Arrays.toString(count));

        int index = 0;
        for(int i = 0; i <= max; i++){
            for(int j = 0; j < count[i]; j++){
                nums[index++] = i;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        CountSort(nums);
    }

}
