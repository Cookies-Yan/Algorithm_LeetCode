package leetCode.array_04;

import java.util.ArrayList;
import java.util.List;

public class E_119_PascalsTriangleII {
    /**
     * Time O(n^2)
     * Space O(n)
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) { //因为是row的Index不是row所以需要+1或者<=
            res.add(0, 1);
            for (int j = 1; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }
}
