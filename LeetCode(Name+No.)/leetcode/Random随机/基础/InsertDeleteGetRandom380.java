package Random随机.基础;
/**
 * Package Name : Random随机.基础;
 * File name : InsertDeleteGetRandom380;
 * Creator: Kane;
 * Date: 8/20/20
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Time complexity:O(1);
 * Space complexity: O(n);
 * Description: TODO
 */
public class InsertDeleteGetRandom380 {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rnd;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom380() {
        map = new HashMap<>();
        list = new ArrayList<>();
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
        if(!map.containsKey(val)) return false;
        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));

    }
}
