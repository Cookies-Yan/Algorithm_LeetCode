package leetCode.stack_08;

import java.util.Stack;

public class M_641_DesignCircularDeque {
    Stack<Integer> stackF;
    Stack<Integer> stackB;
    Stack<Integer> buffer;
    int size;
    public M_641_DesignCircularDeque(int k) {
        this.size = k;
        stackF = new Stack<>();
        stackB = new Stack<>();
        buffer = new Stack<>();
    }
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (!isFull()) {
            stackF.push(value);
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (!isFull()) {
            stackB.push(value);
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (stackF.isEmpty()) {
            if (stackB.size() == 1) {
                stackB.pop();
                return true;
            } else {
                int temp = stackB.size() / 2;
                for (int i = 0; i < temp; i++) {
                    buffer.push(stackB.pop());
                }
                while (!stackB.isEmpty()) {
                    stackF.push(stackB.pop());
                }
                while (!buffer.isEmpty()) {
                    stackB.push(buffer.pop());
                }
            }
        }
        stackF.pop();
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (stackB.isEmpty()) {
            if (stackF.size() == 1) {
                stackF.pop();
                return true;
            } else {
                int temp = stackF.size() / 2;
                for (int i = 0; i < temp; i++) {
                    buffer.push(stackF.pop());
                }
                while (!stackF.isEmpty()) {
                    stackB.push(stackF.pop());
                }
                while (!buffer.isEmpty()) {
                    stackF.push(buffer.pop());
                }
            }
        }
        stackB.pop();
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        if (stackF.isEmpty()) {
            if (stackB.size() == 1) {
                return stackB.peek();
            } else {
                int temp = stackB.size() / 2;
                for (int i = 0; i < temp; i++) {
                    buffer.push(stackB.pop());
                }
                while (!stackB.isEmpty()) {
                    stackF.push(stackB.pop());
                }
                while (!buffer.isEmpty()) {
                    stackB.push(buffer.pop());
                }
            }
        }
        return stackF.peek();
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        if (stackB.isEmpty()) {
            if (stackF.size() == 1) {
                return stackF.peek();
            } else {
                int temp = stackF.size() / 2;
                for (int i = 0; i < temp; i++) {
                    buffer.push(stackF.pop());
                }
                while (!stackF.isEmpty()) {
                    stackB.push(stackF.pop());
                }
                while (!buffer.isEmpty()) {
                    stackF.push(buffer.pop());
                }
            }
        }
        return stackB.peek();
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return stackF.isEmpty() && stackB.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return stackF.size() + stackB.size() >= size;
    }
}
