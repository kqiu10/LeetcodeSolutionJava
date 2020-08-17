package ArrayList数组.TreeMap;
/**
 * Package Name : 数组.子数组;
 * File name : DataStreamasDisjointIntervals352;
 * Creator: Kane;
 * Date: 8/2/20
 */

import java.util.*;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class DataStreamasDisjointIntervals352 {
    TreeMap<Integer, int[]> treemap;

    /** Initialize your data structure here. */
    public DataStreamasDisjointIntervals352() {
        treemap = new TreeMap<>();
    }

    public void addNum(int val) {
        if (treemap.containsKey(val)) return;
        Integer lowerKey = treemap.lowerKey(val);
        Integer higherKey = treemap.higherKey(val);
        if (lowerKey != null && higherKey != null && (val == treemap.get(lowerKey)[1] + 1 ) && (val + 1 == treemap.get(higherKey)[0])) {
            treemap.get(lowerKey)[1] = treemap.get(higherKey)[1];
            treemap.remove(higherKey);
        } else if (lowerKey != null && (val <= treemap.get(lowerKey)[1] + 1)) {
                treemap.get(lowerKey)[1] = Math.max(val, treemap.get(lowerKey)[1]);
            } else if (higherKey != null && (val + 1 == treemap.get(higherKey)[0])) {
                treemap.put(val,new int[]{val, treemap.get(higherKey)[1]});
                treemap.remove(higherKey);
            }else {
                treemap.put(val, new int[]{val, val});
            }
    }

    public int[][] getIntervals() {
        int[][] res = new int[treemap.size()][2];
        int i = 0;
        for(int[] a : treemap.values()){
            res[i++] = a;
        }
        return res;

    }

    public static void main(String[] args) {
        DataStreamasDisjointIntervals352 test = new DataStreamasDisjointIntervals352();
        test.addNum(4);;
        System.out.println(test.getIntervals());
    }
}

