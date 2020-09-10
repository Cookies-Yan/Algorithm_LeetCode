package leetCode.heap_11;

import java.util.*;

public class H_218_TheSkylineProblem {
    /**
     *
     *   buildings : [2 9 10],[3 7 15],[5 12 12],[15 20 10],[19 24 8]
     *   heights :  [2 -10][3 -15][5 -12][7 15][9 10][12 12][15 -10][19 -8][20 10][24 8]
     *   map   15 : 1 ×
     *         12 : 1 ×
     *         10 : 1 ×
     *         8  : 1 ×
     *         0  : 1
     *   prev :  8
     * 起点是负数
     * @param buildings
     * @return
     *
     * Time O(n^2)
     * Space O(n)
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]); //时间复杂度为n，如果不小于0 代表是终点，应该删除掉
            }
            int cur = pq.peek();
            if (prev != cur) {
                List<Integer> list = new ArrayList<>();
                list.add(h[0]);
                list.add(cur);
                res.add(list);
                prev = cur;
            }
        }
        return res;
    }

    /**
     * 不同的数据结构
     * Time O(nlogn)
     * Space O(n)
     */
    public List<List<Integer>> getSkyline1(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); //逆序排列
        map.put(0, 1);
        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                map.put(-h[1], map.getOrDefault(-h[1], 0) + 1);
            } else {
                int cnt = map.get(h[1]);
                if (cnt == 1) {
                    map.remove(h[1]);
                } else {
                    map.put(h[1], cnt - 1);
                }
            }
            int cur = map.firstKey();
            if (prev != cur) {
                List<Integer> list = new ArrayList<>();
                list.add(h[0]);
                list.add(cur);
                res.add(list);
                prev = cur;
            }
        }
        return res;
    }
}
