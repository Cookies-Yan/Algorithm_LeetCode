package leetCode.string_09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class H_030_SubstringWithConcatenationOfAllWords {

    /**
     * Time O(n ^ 2)
     * Space O(n)
     *
     * Input:
     *   s = "barfoothefoobarman",
     *   words = ["foo","bar"]
     *
     * Output: [0,9]
     *
     * Input:
     *   s = "wordgoodgoodgoodbestword",
     *   words = ["word","good","best","word"]
     * Output: []
     *
     * Test case running:
     *
     *  s    :   b a r f o o t h e f o o b a r m a n
     *           i
     *           j
     *           k = 2
     *  map  :   foo : 1
     *           bar : 1
     */
    public List<Integer> findSubstring(String s, String[] words) {

        if (s == null || words == null || words.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int n = words.length; //数组长度
        int m = words[0].length(); //每个单词的长度，每个单词长度都是一样的
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        // 有点滑动窗口的意思, 减去n * m是因为如果不到n * m肯定不能用完所有的数组
        for (int i = 0; i <= s.length() - n * m; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n;
            int j = i;
            while (k > 0) {
                String str = s.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += m;
            }
            if (k == 0) res.add(i);
        }
        return res;
    }

}
