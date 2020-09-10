package leetCode.stack_08.E_155_MinStack;

import java.util.Stack;

/**
 * 容易存储重复元素
 * 见main函数
 */
public class E_155_MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public E_155_MinStack() {

        stack = new Stack<>();

        minStack = new Stack<>();

    }

    public void push(int x) {

        stack.push(x);
        if (!minStack.isEmpty()) {
            int min = minStack.peek();
            if (x <= min) { //小于等于很重要
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {

        int x = stack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        E_155_MinStack a = new E_155_MinStack();
        a.push(-3);
        a.push(-3);
        a.push(-3);
        a.push(-3);
        a.push(-3);
        a.push(-3);
        a.push(-3);

        a.push(-3);
        a.push(-3);
        a.push(-3);
        a.push(-3);
        a.push(-3);
        a.push(0);
        a.push(0);
        a.push(-3);
        a.pop();
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());

    }
 }
