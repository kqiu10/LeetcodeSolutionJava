package 数组.TreeMap;
/**
 * Package Name : 数组.TreeMap;
 * File name : FindRightInterval436;
 * Creator: Kane;
 * Date: 8/1/20
 */

import java.util.TreeMap;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(n);
 * Description: TODO
 */
public class FindRightInterval436 {
    public static int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0],i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key != null ? map.get(key) : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        findRightInterval(new int[][]{{3, 4},{1, 2},{2, 3}});
    }
}
