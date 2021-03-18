package src; /**
 * Date: 12/11/20
 * Question Description
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _380_InsertDeleteGetRandom {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rnd;
    /** Initialize your data structure here. */
    public _380_InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new LinkedList<>();
        rnd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        return true;
    }

    /** Get a random element from the set.
     * Time complexity:O(1);
     * Space complexity: O(n);
     * */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }
}
