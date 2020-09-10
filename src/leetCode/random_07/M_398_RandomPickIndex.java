package leetCode.random_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class M_398_RandomPickIndex {

    //说到随机，100%用到random函数
    //用等概率只要一次抽中即可

    int[] nums;
    Random random;

    public M_398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        return list.get(random.nextInt(list.size()));

    }

    /**
     * 采用蓄水池算法，数据流思想，我们选择第一个出现的数，其也是等概率的事件。
     * 如果我们target 是2，不管后面出现了几个2，我们选取第一个，第一个流出的数据2，都是等概率的
     * [1,2,3,3,3,4,2,2,2,2]
     * @param target
     * @return
     */
    public int pick2(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (random.nextInt(count) == 0) {
                res = i;
            }
        }
        return res;

    }
}
