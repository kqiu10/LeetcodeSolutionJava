/**
 * Date: 12/11/20
 * Question Description
 Design a data structure that supports all following operations in average O(1) time.

 Note: Duplicate elements are allowed.
 insert(val): Inserts an item val to the collection.
 remove(val): Removes an item val from the collection if present.
 getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 Example:

 // Init an empty collection.
 RandomizedCollection collection = new RandomizedCollection();

 // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 collection.insert(1);

 // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 collection.insert(1);

 // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 collection.insert(2);

 // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 collection.getRandom();

 // Removes 1 from the collection, returns true. Collection now contains [1,2].
 collection.remove(1);

 // getRandom should return 1 and 2 both equally likely.
 collection.getRandom();
 */

import java.util.*;

/**
 * Description: TODO
 * Time complexity:O(1);
 * Space complexity: O(n);

 */
public class _381_InsertDeleteGetRandomDuplicatesAllowed {
    HashMap<Integer, HashSet<Integer>> map;
    List<Integer> list;
    Random rnd;
    /** Initialize your data structure here. */
    public _381_InsertDeleteGetRandomDuplicatesAllowed() {
        map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        rnd = new Random();
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
        if (!map.containsKey(val)) return false;
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
