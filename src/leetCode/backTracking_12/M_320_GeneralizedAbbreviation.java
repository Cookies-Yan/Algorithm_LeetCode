package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time O(2 ^ n)
 * Space O(n)(不确定)
 *
 * "word"
 * 输出顺序为:
 * ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]
 */
public class M_320_GeneralizedAbbreviation {

    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }

    public static void helper(List<String> res, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0)  {
                cur += count;
            }
            res.add(cur);
        } else {
            helper(res, word, pos + 1, cur, count + 1);
            helper(res, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }

    public static void main(String[] args) {
        String a = "word";
        System.out.println(Arrays.asList(generateAbbreviations(a)));
    }
}
