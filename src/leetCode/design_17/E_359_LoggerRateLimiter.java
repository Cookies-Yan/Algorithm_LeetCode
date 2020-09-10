package leetCode.design_17;

import java.util.HashMap;

public class E_359_LoggerRateLimiter {

    /**
     * Time O(1)
     * Space O(n)
     */
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public void Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}
