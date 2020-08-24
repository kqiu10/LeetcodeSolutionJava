package Random随机.基础;
/**
 * Package Name : Random随机.基础;
 * File name : InsertDeleteGetRandomDuplicatesallowed381;
 * Creator: Kane;
 * Date: 8/20/20
 */

import java.util.*;

/**
 * Time complexity:O(1);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _381_InsertDeleteGetRandomDuplicatesallowed {
    HashMap<Integer, HashSet<Integer>> map;
    Random rnd;
    List<Integer> list;

    /** Initialize your data structure here. */
    public _381_InsertDeleteGetRandomDuplicatesallowed() {
        map = new HashMap<>();
        rnd = new Random();
        list = new ArrayList<>();

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new HashSet<>());

        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;




    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (map.get(val).size() == 0) map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.get(lastVal).remove(list.size());
            map.get(lastVal).add(index);
        }
        return true;


    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));

    }
}
