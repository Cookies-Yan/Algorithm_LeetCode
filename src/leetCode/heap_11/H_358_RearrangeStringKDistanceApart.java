package leetCode.heap_11;

import java.util.*;

public class H_358_RearrangeStringKDistanceApart {
    /**
     * 第一种解法：
     * int[] count 字母出现次数
     * int[] valid 字母出现位置
     * s = "aabbcc", k = 3
     * count[a] = 2    count--  ->  count[a] = 1
     * count[b] = 2
     * count[c] = 2
     * valid[a] = 0    valid[a]+k ->  valid[a] = 3
     *
     * s = "aaadbbcc", k = 2
     * a : 2
     * b : 2
     * c : 2
     * d : 1
     *
     */
    public static String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[26];
        int[] valid = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int nextLetter = findNext(count, valid, i);
            if (nextLetter == -1) {
                return "";
            }
            res.append((char)('a' + nextLetter));
            valid[nextLetter] = i + k;
            count[nextLetter]--;
        }
        return res.toString();
    }
    //找到字母最多的那个，如果不能满足，则整个字符串都不能满足，把字母最多的放在最前面处理
    private static int findNext(int[] count, int[] valid, int index) {
        int max = 0, res = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && valid[i] <= index) {
                res = i;
                max = count[i];
            }
        }
        return res;
    }

    /**
     * 利用tough变量 来提前判断是否可以达成字符串输出。
     */
    int tough = 0;
    public String rearrangeString1(String s, int k) {
        int len = s.length();
        if (s == null || len == 0) {
            return s;
        }
        int[] count = new int[26];
        int[] valid = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int nextLetter = findNext1(count, valid, i);
            if (tough * (k - 1) > s.length()) {
                return "";
            }
            if (nextLetter == -1) {
                return "";
            }
            res.append((char)('a' + nextLetter));
            valid[nextLetter] = i + k;
            count[nextLetter]--;
        }
        return res.toString();
    }

    private int findNext1(int[] count, int[] valid, int index) {
        int max = 0, res = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && valid[i] <= index) {
                res = i;
                max = count[i];
            }
        }
        tough = max;
        return res;
    }

    //HashMap Time O(nlogn) Space O(n)
    public static String rearrangeString2(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(map.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            res.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            queue.offer(cur); //queue空出来是看是否进行了K次，控制同样的元素 不能小于K的距离
            if (queue.size() < k) continue;
            Map.Entry<Character, Integer> front = queue.poll();
            if (front.getValue() > 0) {
                pq.offer(front);
            }
        }
        return res.length() == s.length() ? res.toString() : "";

    }

    public static void main(String[] args) {
        String s = rearrangeString("aaadbbcc", 2);
        System.out.println(s);
    }

}
