package leetCode.random_07;

import java.util.Random;

public class M_384_ShuffleAnArray {

    /**
     * Time O(n)
     */
    private int[] nums;
    private Random rmd;

    public M_384_ShuffleAnArray(int[] nums) {
        this.nums = nums;
        rmd = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;
        int[] clone = nums.clone();
        for (int i = 1; i < clone.length; i++) {
            int random = rmd.nextInt(i + 1);
            swap(clone, i, random);
        }
        return clone;
    }

    private void swap(int[] clone, int i, int j) {
        int temp = clone[i];
        clone[i] = clone[j];
        clone[j] = temp;
    }
}
