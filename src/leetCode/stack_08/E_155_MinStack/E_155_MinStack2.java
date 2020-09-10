package leetCode.stack_08.E_155_MinStack;

import java.util.Stack;

/**
 * 优化：把两个stack合成一个stack
 */
public class E_155_MinStack2 {


    Stack<Integer> stack;
    int min;

    public E_155_MinStack2() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        E_155_MinStack2 s = new E_155_MinStack2();
        s.push(-2);
        s.push(-2);
        s.push(-0);
        s.push(-2);
        s.push(-3);

    }

}
