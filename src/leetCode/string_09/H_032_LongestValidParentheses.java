package leetCode.string_09;

import java.util.Stack;

public class H_032_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int j = -1; // j等于-1 处理')()()' j控制start i控制end
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {            //右括号
                if (stack.isEmpty()) {
                    j = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {    // '(( ))' '(()('
                        res = Math.max(res, (i - j));
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }

}
