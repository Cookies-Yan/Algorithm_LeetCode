package laiClass.class_03_queue_stack_linkedList;

import java.util.Stack;

public class stackMathCalculate {
    /**
     * 变形1：
     * a * (b + c)			abc+*
     * a = 2   b = 1    c = 3		213+*
     * 2 * (1 + 3)   ==  8
     * 给的是post-fix
     */
    public int calculate(String s) {
        if (s.equals("") || s.length() == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stack.push(s.charAt(i) - '0');
            } else {
                int temp1 = stack.pop() ;
                int temp2 = stack.pop() ;
                if (s.charAt(i) == '+') {
                    res = temp2 + temp1;
                } else if (s.charAt(i) == '-') {
                    res = temp2 - temp1;
                } else if (s.charAt(i) == '*') {
                    res = temp2 * temp1;
                } else {
                    res = temp2 / temp1;
                }
                stack.push(res);
            }
        }
        return res;
    }

    /**
     * 变形2
     * 不给post-fix
     * 直接给"(1+(4+5+2)-3)+(6+8)"
     * 见 leetCode  H_224_BasicCalculator
     */

    public static void main(String[] args) {
        stackMathCalculate a = new stackMathCalculate();
        String s = "213+*";
        System.out.println(a.calculate(s));
    }
}
