package leetCode.stack_08;

import java.util.Stack;

/**
 * ".."返回上一层目录，可以用stack中的pop解决
 * 对于String的题，边界条件非常重要
 */
public class M_071_SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        /**
         * 正则表达式，将string用 "/" 分隔开
         */
        String[] paths = path.split("/+");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                /**
                 * 对于"."和"" 我们什么也不需要做，在代码中我们用！(取非得方式)来解决此类问题
                 * 此行表示对于，是a,b,c的字符，我们压入栈内
                 */
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        /**
         * 将处理过的字符串连起来
         */
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        /**
         * 如果什么都没有，就返回根目录
         */
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }
}
