package leetcode.ArrayList数组.HashMap;
/**
 * Date: 9/25/20
 * Question Description
 Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

 Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.



 Follow up:
 Could you do both operations in O(1) time complexity?



 Example:

 LFUCache cache = new LFUCache( 2 capacity );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Description: TODO
 * Time complexity:O(1); all operations take O(1)
 * Space complexity: O(n);

 */
public class _460_LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> list;
    int capacity;
    int min;

    public _460_LFUCache(int capacity) {
        vals = new HashMap<>();
        counts = new HashMap<>();
        list = new HashMap<>();
        list.put(1, new LinkedHashSet<>());
        this.capacity = capacity;
        min = -1;
    }

    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);
        list.get(count).remove(key);
        if (count == min && list.get(count).size() == 0) {
            min++;
        }
        if (!list.containsKey(count + 1)) {
            list.put(count + 1, new LinkedHashSet<>());
        }
        list.get(count + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= capacity) {
            int evit = list.get(min).iterator().next();
            list.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        list.get(1).add(key);
    }
}
