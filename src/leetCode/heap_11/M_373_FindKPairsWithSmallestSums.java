package leetCode.heap_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class M_373_FindKPairsWithSmallestSums {
    /**
     * Time O(klogk)
     * Space O(k)
     * nums1 = [1,7,11], nums2=[2,4,5] k = 3
     * 1,2,0  7,2,0  11,2,0
     * 1,2 -> 1,4 -> 1,6
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k ==0) {
            return res;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        /**
         * 可能在k之前，可能在k之后
         */
        for (int i = 0; i < k && i < nums1.length; i++) {
            priorityQueue.offer(new int[]{nums1[i], nums2[0], 0}); //第三个参数是nums2的index
        }

        while (!priorityQueue.isEmpty() && k-- > 0) {
            int[] cur = priorityQueue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(cur[0]);
            list.add(cur[1]);
            res.add(list);
            if (cur[2] == nums2.length - 1) continue;
            priorityQueue.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }

        return res;
    }
    //跑的很慢
    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1) - b.get(0) - b.get(1)));
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                pq.add(list);
            }
        }
        while (!pq.isEmpty() && k > 0) {
            res.add(pq.poll());
            k--;
        }
        return res;
    }

    //与上面输出不同
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {

        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k ==0) {
            return res;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < k && i < nums1.length; i++) {
            priorityQueue.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (!priorityQueue.isEmpty() && k-- > 0) {
            int[] cur = priorityQueue.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) continue;
            priorityQueue.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        M_373_FindKPairsWithSmallestSums a = new M_373_FindKPairsWithSmallestSums();
        List<int[]> res = a.kSmallestPairs2(nums1, nums2, 4);
        for (int[] list : res) {
            System.out.println(Arrays.toString(list));
        }

    }
}
