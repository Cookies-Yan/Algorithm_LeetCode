package leetCode.stack_08;

import java.util.Stack;

public class M_394_DecodeString {
    /**
     * 有中括号的一般都得用stack(剥洋葱的形式)
     * 对于stack的题
     * 1.有顺序
     * 2.最近原则，取最近的元素
     * 不同的内容不要放到同一个stack里面，比如又有数字还有字母
     * @param s
     * @return
     */
    /** 1.数字2.[ 3.] 4.字母
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = ""; //扫描了bc, 存入一下
        int idx = 0;

        while (idx < s.length()) { //数字
            if (Character.isDigit(s.charAt(idx))) {
                int num = 0;
                //不一定是1，2，3 数字有可能是32，64等等
                while (Character.isDigit(s.charAt(idx))){
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                numStack.push(num);
            } else if (s.charAt(idx) == '[') {       // '['
                resStack.push(res);
                res = "";  //对于[abc2[c]]，我们push完abc还要重新解析完2[c]，再push，所重置res
                idx++;
            } else if (s.charAt(idx) == ']') {  // ']'
                StringBuilder temp = new StringBuilder(resStack.pop());
                int time = numStack.pop();
                for (int i = 0; i < time; i++) {
                    temp.append(res); //append 是接上,变为acc
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
