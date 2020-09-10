package leetCode.stack_08;

import java.util.Stack;

public class H_224_BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) { //也可以用while循环
            if (Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop(); //第一次是+或减的符号位，第二次是符号前面的数字值
            }
        }
        return res;
    }

    public static void main(String[] args) {
        H_224_BasicCalculator a = new H_224_BasicCalculator();
        System.out.println(a.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
