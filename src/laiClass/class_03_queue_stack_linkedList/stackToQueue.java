package laiClass.class_03_queue_stack_linkedList;

import java.util.Stack;

public class stackToQueue {
    /**
     * How could we implement a queue by using two stacks?
     * stack1: 4 5 6
     * stack2:
     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public stackToQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        } else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }

    public int peek() {
        if (empty()) {
            return -1;
        } else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        } else {
            return stack2.peek();
        }
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     * 变形2
     * How to use multiple stacks to implement a de-queue(deque)??
     * 见leetCodeM_641_DesignCircularDeque
     * @param args
     */


    public static void main(String[] args) {
        stackToQueue a = new stackToQueue();
        a.push(1);
        a.push(2);
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.peek());
        System.out.println(a.empty());
    }
}
