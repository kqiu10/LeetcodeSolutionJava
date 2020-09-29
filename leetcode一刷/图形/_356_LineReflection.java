package 图形;
/**
 * Package Name : 图形;
 * File name : _356_LineReflection;
 * Creator: Kane;
 * Date: 9/9/20
 */

import java.util.HashSet;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the
 * given points symmetrically, in other words, answer whether or not if there exists a line that
 * after reflecting all points over the given line the set of the original points is the same
 * that the reflected ones.
 *
 * Note that there can be repeated points.
 *
 * Follow up:
 * Could you do better than O(n2) ?
 *
 * Example 1:

 * Input: points = [[1,1],[-1,1]]
 * Output: true
 * Explanation: We can choose the line x = 0.
 * Example 2:
 *
 * Input: points = [[1,1],[-1,-1]]
 * Output: false
 * Explanation: We can't choose a line.
 *
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _356_LineReflection {
    public static boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
            set.add(point[0] + "," + point[1]);
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
        }
        int sum = min + max;
        for (int[] point : points) {
            if (!set.contains(sum - point[0] + "," + point[1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isReflected(new int[][]{{1, 1},{-1, 1}});
    }
}
