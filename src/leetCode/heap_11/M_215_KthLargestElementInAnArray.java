package leetCode.heap_11;

import java.util.PriorityQueue;

/**
 * Two method :  priority queue && QuickSort;
 * Time O(n)
 * Space O(1)
 */

public class M_215_KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while(true){
            int pos = partition(nums, left, right);
            if(pos + 1 == k){
                return nums[pos];
            }else if(pos + 1 > k){
                right = pos - 1;
            }else{
                left = pos + 1;
            }
        }
    }
    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left]; //选择最左边的数取出来当中心点
        int l = left + 1;
        int r = right;
        while(l <= r){
            if(nums[l] < pivot && nums[r] > pivot){
                swap(nums, l++, r--);
            }
            if(nums[l] >= pivot) l++;
            if(nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] =nums[i];
        nums[i] = temp;

    }

    /**
     * time O(nlogk)
     * Space O(k)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        if (nums == null || nums.length == 0) return 0;
        /**
         * 这里并不是offer是logn得出的nlog(n)
         * 而是O(log1+log2+.....+logn) = O(log(n!)) = O(nlogn)
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num); //add也行
            /**
             * 始终保持最大的两位
             */
            if (minHeap.size() > k) {
                minHeap.poll();
            }

        }

        return minHeap.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,4,5};
        int res = findKthLargest(nums,5);
        System.out.println(res);

    }
}
