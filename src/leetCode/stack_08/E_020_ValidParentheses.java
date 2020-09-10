package leetCode.stack_08;

import java.util.Stack;

public class E_020_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                /**
                 * stack.isEmpty() 判断这种情况，"]})"
                 */
                if (stack.isEmpty() || stack.pop() != ch) { //顺序不能颠倒
                    return false;
                }
            }
        }
        /**
         * 判断这种特殊情况："((({[()]}"
         */
        return stack.isEmpty();
    }
    // toCharArray() 方法将字符串转换为字符数组，无参数
    // push(Object element)压入
    // pop (Object element)推出
    // isEmpty() 空集判断，T || F
}
