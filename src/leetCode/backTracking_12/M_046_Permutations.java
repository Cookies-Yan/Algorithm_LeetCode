package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Time: O(n * n!) //回溯法从本质去看，从数学原理看
 * Space: O(n! * n)
 * 理解不一样，所以不一定n!*n,有的人理解不*n
 */
public class M_046_Permutations {

    public  static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        /**
         * 一定要new
         */
        helper(res, new ArrayList<>(), nums);

        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        //跟visited一个逻辑
        if (list.size() == nums.length) {
            /**
             * 这里一定要new一个对象
             * 因为随着往上回溯，会不断的remove,所以最后全是空集。
             */
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums);
            /**
             * 回溯的精髓
             */
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    /***
     * 关于Instantiation of List (Java)：https://www.jianshu.com/p/96db9790e765
     * Java集合--List：  https://www.jianshu.com/p/25aa92f8d681
     * 关于JAVA泛型：  http://www.runoob.com/java/java-generics.html
     *               https://www.jianshu.com/p/95f349258afb
     *
     *关于list.remove:   remove(1)是删除索引为1的元素
     *                  remove(new Integer(1))则删除元素1
     *
     * LC backtracking 合计：https://blog.csdn.net/crystal6918/article/details/51924665
     *                      https://www.jianshu.com/p/11ad5ce0daad
     */
}
