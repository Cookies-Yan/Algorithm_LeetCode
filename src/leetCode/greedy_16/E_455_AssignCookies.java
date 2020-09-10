package leetCode.greedy_16;

import java.util.Arrays;

public class E_455_AssignCookies {
    /**
     * Time O(N)
     * Space O(1)
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else if (g[i] > s[j]) {
                j++;
            }
        }
        return res;
    }
}
