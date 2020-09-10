package leetCode.bitOperation_02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class M_187_RepeatedDNASequences {
    /**
     * Time : O(n)
     * Space : O(n)
     * BitMap 也可以用HashSet去写，用HashSet比较简单
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        /**
         * add函数返回的是true || false, 之前加过了返回false
         */
        for (int i = 0; i < s.length() - 9; i++) {
            String set = s.substring(i, i + 10);
            if (!seen.add(set)) {
                repeated.add(set);
            }
        }

        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = findRepeatedDnaSequences(s);
        System.out.println(res);

    }
}
