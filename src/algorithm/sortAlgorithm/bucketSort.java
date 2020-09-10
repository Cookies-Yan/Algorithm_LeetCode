package algorithm.sortAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 空间换时间
 * n : 待排序的数据 m : 代表桶的数量
 * Time(best):O(n);
 *     (avg):O(n+c); c = n * (logn~logm),因为我们用了内部排序
 *     (worst):没意义;
 * Space:(n + m);
 * 稳定性：稳定
 *
 * 限定O(n) 排序，100%是用桶排序
 */
public class bucketSort {

    public static void bucketSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        //至少要有一个桶, 防止差值小于数组的长度
        int bucketNum = (max - min) / nums.length + 1;
        System.out.println("max , min," + max + ", " + min + " bucketNum : " + bucketNum);
        List<List<Integer>> bucket = new ArrayList<>();
        //给内部小List初始化
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        //具体放入到哪个桶
        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] - min) / nums.length;
            bucket.get(num).add(nums[i]);
        }

        //遍历每一个桶并给桶里面的数字排序
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }
        System.out.println(bucket.toString());

    }

    public static void main(String[] args) {
            int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8, 20};
            bucketSort(nums);

    }
}
