package leetCode.heap_11;

import java.util.PriorityQueue;

public class M_313_SuperUglyNumer {
    /**
     * Input: n = 12, primes = [2,7,13,19]
     * Output: 32
     * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
     *              super ugly numbers given primes = [2,7,13,19] of size 4.
     *                    1 ->
     * 1 : 2, 7, 13, 19   2 -> 7 -> 13 -> 19
     * 2 : 2, 7, 13, 19   4 -> 14 -> 26 -> 38
     * 4 : 2, 7, 13, 19   8 -> 28 ->
     *
     * pq :
     * 2 1 2
     * 7 1 7
     * 13 1 13
     * 19 1 19
     *
     * [2,7,13,19]
     * res: 1 2 4 7 8 13 14 14
     * i: 4
     * pq :
     * (2  1 2)  (4 2 2)  (8 3 2)  (14 4 2)  16 5 2
     * 19 1 19
     * (13 1 13) 26 2 13
     * (7  1 7)  (14 2 7)  28 3 7
     *
     */
    // Time O(n*logk) k是primes长度 Space O(max(n,k) res长度
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;

        PriorityQueue<Num> pq = new PriorityQueue<>((a, b) -> (a.val - b.val)); //默认排一列数的第一位
        //将数字加入
        for (int i = 0; i < primes.length; i++) {
            pq.add(new Num(primes[i], 1, primes[i])); //将[2, 7, 13, 19]加入
        }

        for (int i = 1; i < n; i++) {
            res[i] = pq.peek().val;  //拿出来最小值
            while (pq.peek().val == res[i]) { //如果拿出来本身就是最小的，那么需要更新index和下一个的值
                Num next = pq.poll();
                pq.add(new Num(next.prime * res[next.index], next.index + 1, next.prime));
            }
        }
        return res[n - 1];
    }

    /*val乘积结果，res里面已经排好序的数*/
    /*prime是原有的质数，不变*/
    class Num {
        int val;
        int index;
        int prime;

        public Num(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
    }
}
