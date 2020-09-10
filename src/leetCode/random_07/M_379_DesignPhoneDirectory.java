package leetCode.random_07;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class M_379_DesignPhoneDirectory {

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    int maxNumbers;
    HashSet<Integer> used;
    Queue<Integer> queue;
    public M_379_DesignPhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        this.used = new HashSet<>();
        this.queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer res = queue.poll();
        if (res == null) {
            return -1;
        }
        used.add(res);
        return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= maxNumbers || number < 0) {
            return false;
        }
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.remove(number)) {
            queue.offer(number);
        }
    }
}
