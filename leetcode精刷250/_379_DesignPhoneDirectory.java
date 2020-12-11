/**
 * Date: 12/11/20
 * Question Description
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _379_DesignPhoneDirectory {
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    HashSet<Integer> set;
    Queue<Integer> queue;
    int maxNum;
    public _379_DesignPhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        queue = new LinkedList<>();
        maxNum = maxNumbers;
        for (int i = 0; i < maxNum; i++) {
            queue.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            int res = queue.poll();
            set.add(res);
            return res;
        }

    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (set.contains(number)) {
            set.remove(number);
            queue.offer(number);
        }

    }
}
