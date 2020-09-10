package leetCode.array_04;

import java.util.HashSet;
import java.util.PriorityQueue;

public class E_414_ThridMaximumNumber {

    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer num : nums) {
            //去重
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue; //这利用equals不用'=='的原因如下
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }

    /**
     * Time O(n) 因为只有3个值 log3常数值
     * Space O(1)
     * PriorityQueue + HashSet
     * @param nums
     * @return
     */
    public int thirdMax1(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 默认最小堆
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            //去重
            if (set.add(num)) { //如果之前没有就是 true并加入， 如果有则是false
                pq.offer(num);
                if (pq.size() > 3) pq.poll();
            }
        }
        if (pq.size() == 2) pq.poll(); // poll出来最小值，返回最大的
        return pq.peek();
    }


    public static void main(String[] args) {
        /**
         * Integer 是一个对象，用equals比较保险
         * Integer范围如果在128之内 用 '==' 也是没有问题的， 但是在128则不行
         */
        int a = 5;
        int b = 5;
        int c = 157;
        int d = 157;
        Integer a1 = 5;
        Integer b1 = 5;
        Integer c1 = 157;
        Integer d1 = 157;
        System.out.println(a == b); //true
        System.out.println(c == d); //true
        System.out.println(a1 == b1); //true
        System.out.println(c1 == d1); //false
        System.out.println(c1.equals(d1)); //true
    }
}
