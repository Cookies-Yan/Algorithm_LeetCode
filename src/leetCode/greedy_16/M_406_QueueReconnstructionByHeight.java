package leetCode.greedy_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_406_QueueReconnstructionByHeight {
    /**
     * Time O(n^2)
     * Space O(n)
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0])); //nlogn
        for (int[] cur : people) { // n
            res.add(cur[1], cur); // n
        }
        return res.toArray(new int[people.length][]);
    }
}
