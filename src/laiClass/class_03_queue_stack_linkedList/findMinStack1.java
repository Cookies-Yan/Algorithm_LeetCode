package laiClass.class_03_queue_stack_linkedList;

import java.util.HashMap;
import java.util.Stack;

/**
 * 变形2
 * How to implement the min{} function when using stack with time Complexity O(1)
 * 用 map节省空间
 */
public class findMinStack1 {

    /** initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    HashMap<Integer, Integer> map;

    public findMinStack1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
            map.put(x, stack1.size());
        } else {
            int min = stack2.peek();
            if (x < min) {
                stack2.push(x);
                map.put(x, stack1.size());
            }
        }
    }

    public void pop() {
        if (stack1.isEmpty()) {
            return;
        } else if (map.containsKey(stack1.peek()) && stack1.size() == map.get(stack2.peek())){
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
            return stack2.peek();
        }
    }
    public static void main(String[] args) {

        findMinStack1 a = new findMinStack1();
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
