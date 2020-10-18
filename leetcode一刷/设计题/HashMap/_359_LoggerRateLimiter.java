package 设计题.HashMap;
/**
 * Date: 10/18/20
 * Question Description
 */

import java.util.HashMap;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _359_LoggerRateLimiter {
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public _359_LoggerRateLimiter() {
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
