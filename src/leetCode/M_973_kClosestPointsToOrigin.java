package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class M_973_kClosestPointsToOrigin {

        public static int [][] KClosest(int[][] points, int K){
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[0]*a[0] - a[1]*a[1]));
            for(int[] p : points){
                pq.offer(p);
                if(pq.size() > K){pq.poll();}
            }
            int[][] ans = new int[K][2];
            while(K-- > 0){ans[K] = pq.poll();}
            return ans;

        }

    public static void main(String[] args) {
        int[][] cool =  new int[][]{{1,3},{-2,2}};
        int[][] res = KClosest(cool,1);

    }
}
