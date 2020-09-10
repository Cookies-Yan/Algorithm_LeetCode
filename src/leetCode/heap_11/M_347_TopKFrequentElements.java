package leetCode.heap_11;

import java.util.*;

public class M_347_TopKFrequentElements {

    /**
     * PriorityQueue : time : O(klogn) Space : O(n) 输出的并不是 k=2 的所有的数
     * 返回[1, 2] 或者 [1, 3]
     *
     *  1）获取所有键值对对象的集合---entrySet()方法
     *  2）遍历键值对对象的集合，获取到每一个键值对对象---foreach遍历
     *  3）根据键值对的得到键和值---getKey()和getValue()方法
     *     思路2：键找值方式
     *  1）获取所有键的集合----keySet()
     *  2）遍历键的集合，获取到每一个键---foreach遍历→注意判断是否非空
     *  3）根据键找值----get(K key)→value
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =   //按频数从大到小排
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue())); //getValue 拿到值

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            maxHeap.add(entry);                     //扔到最大堆
        }
        List<Integer> list = new ArrayList<>();
        while (list.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();  //getKey 拿到键
            list.add(entry.getKey());
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 运行样例
     * TreeMap: time : O(klogn) Space : O(n) 返回[1, 2, 3]
     * num : freq
     * 1 : 3
     * 2 : 2
     * 3 : 2
     * 4 : 1
     *
     * freqMap:
     * freq : num
     * 3 : 1
     * 2 : 2,3
     * 1 : 4
     */
    public int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();

        for (int num : map.keySet()) { //KeySet() 给出来的东西是随机的
            int freq = map.get(num);
            if (freqMap.containsKey(freq)) {
                freqMap.get(freq).add(num);
            } else {
                freqMap.put(freq, new LinkedList<>());
                freqMap.get(freq).add(num);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (list.size() < k) {
            //java默认排序函数都是升序，但是我们要最大,所以在TreeMap中pollLast
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            list.addAll(entry.getValue());
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * Bucket Sort Time O(n) Space O(n)
     * 运行样例：
     *
     *        [1, 1, 1, 2, 2, 3, 3, 4] length = 8
     *
     *        [0, 1, 2, 3, 4, 5, 6, 7, 8] frequent 防止上面数组全是1， 那么1的频率是8
     * freq :     4  2  1
     *               3
     * num : freq
     * 1 : 3
     * 2 : 2
     * 3 : 2
     * 4 : 1
     *
     * 返回[1, 2, 3]
     *
     */
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(num);
        }


        List<Integer> list = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && list.size() < k; i--) { //从大到小，从后往前走
            if(bucket[i] != null) {
                list.addAll(bucket[i]);
            }
        }
        /** 这么写不是返回全部，而是返回[1 ,2] 或者 [1, 3]
        for (int i = bucket.length - 1; i >= 0; i--) {
            int j = 0;
            while (bucket[i] != null && j < bucket[i].size() && k > 0) {
                list.add(bucket[i].get(j++));
                k--;
            }
        }
         */
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
