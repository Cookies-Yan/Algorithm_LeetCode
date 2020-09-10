package leetCode.heap_11;

import java.util.PriorityQueue;

public class M_378_KthSmallestElementInASortedMatrx {

    /**
     * 方法1： PriorityQueue 链表
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     * return 13
     *
     * pq: 1 5 9
     * 1 -> 10 -> 12
     * 5 -> 11 -> 13
     * 9 -> 13 -> 15
     * Time O(nlogn) Space O(n)
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(matrix.length, (a, b) -> (a.val - b.val));
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = pq.poll();
            if (tuple.x == matrix.length - 1) continue;
            pq.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
        }
        return pq.poll().val;
    }

    class Tuple {
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    /**
     * Binary Search 二分法数个数
     *
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     * return 13
     * min = 1 max = 15 mid = 8
     *
     * 如果mid前面有k个 就在左边你找，否则在右边找
     *
     * Time O(n*log(max - min))  Space O(1)
     *
     */
    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            int num = count(matrix, mid);
            if (num >= k) right = mid;
            else left = mid;
        }
        if (count(matrix, right) <= k - 1) return right;
        return left;
    }

    private int count(int[][] matrix, int target) {
        int n = matrix.length;
        int res = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                res += i + 1;
                j++;
            } else i--;
        }
        return res;
    }
    /**
     * 方法超时了
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        if (matrix == null) return -1;
        if (matrix.length - 1 * matrix[0].length - 1 == k) return matrix[matrix.length - 1][matrix[0].length - 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{matrix[0][0], 0, 0});
        int res = 0;
        matrix[0][0] = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (k - 1 == 0) {
                res = cur[0];
            }
            if (cur[1] == matrix.length - 1 && cur[2] + 1 <= matrix[0].length - 1) {
                pq.offer(new int[]{matrix[cur[1]][cur[2] + 1], cur[1], cur[2] + 1});
                matrix[cur[1]][cur[2] + 1] = Integer.MAX_VALUE;
            }
            if (cur[1] + 1<= matrix.length - 1 && cur[2] == matrix[0].length - 1) {
                pq.offer(new int[]{matrix[cur[1] + 1][cur[2]], cur[1] + 1, cur[2]});
                matrix[cur[1] + 1][cur[2]] = Integer.MAX_VALUE;
            }
            if(cur[1] < matrix.length - 1 && cur[2] < matrix[0].length - 1) {
                pq.offer(new int[]{matrix[cur[1]][cur[2] + 1], cur[1], cur[2] + 1});
                matrix[cur[1]][cur[2] + 1] = Integer.MAX_VALUE;
                pq.offer(new int[]{matrix[cur[1] + 1][cur[2]], cur[1] + 1, cur[2]});
                matrix[cur[1] + 1][cur[2]] = Integer.MAX_VALUE;
            }
            k--;
        }
        return res;
    }

}
