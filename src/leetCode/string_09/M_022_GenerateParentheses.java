package leetCode.string_09;

import java.util.ArrayList;
import java.util.List;

public class M_022_GenerateParentheses {

    public static List<String> generateParenthesis(int n) {

        if ( n < 0) {
            throw new IllegalArgumentException("n cannot be a negative number");
        }

        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        helper(res, "", n, n);
        return res;

    }
    public static void helper(List<String> res, String s, int left, int right) {

        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(-1));
    }
}
