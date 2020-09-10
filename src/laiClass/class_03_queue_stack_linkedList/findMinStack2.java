package laiClass.class_03_queue_stack_linkedList;

import javafx.util.Pair;

import java.util.Stack;

/**
 * 变形2
 * How to implement the min{} function when using stack with time Complexity O(1)
 * 直接用stack存pair节省空间
 */
public class findMinStack2 {


    /** initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Pair> stack2;
    public findMinStack2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(new Pair<>(x, stack1.size()));
        } else {
            if (x < (int)stack2.peek().getKey()) {
                stack2.push(new Pair<>(x, stack1.size()));
            }
        }
    }

    public void pop() {
        if (stack1.isEmpty()) {
            return;
        } else if (stack1.size() == (int)stack2.peek().getValue()){
            stack1.pop();
            stack2.pop();
        } else {
            stack1.pop();
        }
    }

    public int top() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }

    public int getMin() {
        if (stack1.isEmpty()) {
            return -1;
        } else{
            return (int)stack2.peek().getKey();
        }
    }

    public static void main(String[] args) {
        findMinStack2 a = new findMinStack2();
        a.push(-1);
        a.push(-1);
        a.push(-1);
        a.push(-1);
        a.push(-1);
        a.push(-1);
        a.push(-1);
        a.push(-1);
        a.push(-1);
        a.push(-1);
        a.push(-1);
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
