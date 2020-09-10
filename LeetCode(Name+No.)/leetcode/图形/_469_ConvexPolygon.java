package 图形;
/**
 * Package Name : 图形;
 * File name : _469_ConvexPolygon;
 * Creator: Kane;
 * Date: 9/9/20
 */

import java.util.List;

/**
 * Given a list of points that form a polygon when joined sequentially, find if this polygon is
 * convex (Convex polygon definition).
 *
 *
 *
 * Note:
 *
 * There are at least 3 and at most 10,000 points.
 * Coordinates are in the range -10,000 to 10,000.
 * You may assume the polygon formed by given points is always a simple polygon (Simple polygon
 * definition). In other words, we ensure that exactly two edges intersect at each vertex, and
 * that edges otherwise don't intersect each other.
 *
 *
 * Example 1:
 * [[0,0],[0,1],[1,1],[1,0]]
 * Answer: True
 *
 * Example 2:
 * [[0,0],[0,10],[10,10],[10,0],[5,5]]
 *
 * Answer: False
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: 纯数学公式
 */
public class _469_ConvexPolygon {
    public boolean isConvex(List<List<Integer>> points) {
        int size = points.size();
        int flag = 0;
        for (int i = 0; i < points.size(); i++) {
            int ori = helper(points.get(i % size), points.get((i + 1) % size), points.get((i + 2) % size));
            if (ori == 0) {
                continue;
            }
            if (flag == 0) {
                flag = ori;
            } else {
                if (flag != ori) {
                    return false;
                }
            }
        }
        return true;
    }
    private int helper(List<Integer> l1, List<Integer> l2, List<Integer> l3) {
        int val = (l3.get(0) - l2.get(0)) * (l2.get(1) - l1.get(1)) -
                (l2.get(0) - l1.get(0)) * (l3.get(1) - l2.get(1));
        if (val < 0) {
            return 2;
        } else if (val == 0) {
            return 0;
        }
        return 1;
    }
}
