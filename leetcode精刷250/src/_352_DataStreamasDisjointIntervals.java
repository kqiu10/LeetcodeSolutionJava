package src; /**
 * Date: 12/5/20
 * Question Description
 Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

 For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

 [1, 1]
 [1, 1], [3, 3]
 [1, 1], [3, 3], [7, 7]
 [1, 3], [7, 7]
 [1, 3], [6, 7]

 */

import java.util.TreeMap;

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(n);

 */
public class _352_DataStreamasDisjointIntervals {
    /** Initialize your data structure here. */
    TreeMap<Integer, int[]> treeMap;
    public _352_DataStreamasDisjointIntervals() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        Integer lowerKey = treeMap.lowerKey(val);
        Integer higherKey = treeMap.higherKey(val);
        if (lowerKey != null && higherKey != null && treeMap.get(lowerKey)[1] + 1 == val && treeMap.get(higherKey)[0] - 1 == val) {
            treeMap.put(lowerKey, new int[]{treeMap.get(lowerKey)[0], treeMap.get(higherKey)[1]});
            treeMap.remove(higherKey);
        }  else if (lowerKey != null && treeMap.get(lowerKey)[1] + 1 >= val) {
            treeMap.put(lowerKey, new int[]{treeMap.get(lowerKey)[0], Math.max(treeMap.get(lowerKey)[1], val)});
        } else if (higherKey != null && treeMap.get(higherKey)[0] - 1 == val) {
            treeMap.put(val, new int[]{val, treeMap.get(higherKey)[1]});
            treeMap.remove(treeMap.get(higherKey)[0]);
        } else {
            treeMap.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[treeMap.size()][2];
        int i = 0;
        for(int[] a : treeMap.values()){
            res[i++] = a;
        }
        return res;
    }
}
