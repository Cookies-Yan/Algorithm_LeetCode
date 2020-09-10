package leetCode.greedy_16;

public class M_484_FindPermutation {
    /**
     * "D D I I D I"
     * 1 2 3 4 5 6 7
     * 遇到D就翻转
     * 3 2 1 4 6 5 7
     * Time O(n)
     * Space O(n)
     */
    public int[] findPermutation(String s) {
        int len = s.length();
        int[] res = new int[len + 1];
        /**
         * 升序数列
         */
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'D') {
                int start = i;
                while (i < len && s.charAt(i) == 'D') {
                    i++;
                }
                revers(res, start, i);
            }
        }
        return res;
    }

    public void revers(int[] array, int left, int right) {
        while (left < right) {
            int t = array[left];
            array[left] = array[right];
            array[right] = t;
            left++;
            right--;
        }
    }
}
