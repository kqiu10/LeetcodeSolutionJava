package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : SquirrelSimulation573;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class SquirrelSimulation573 {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            sum += distance(nut, tree) * 2;
            max = Math.max(max, distance(tree, nut) - distance(nut, squirrel));
        }
        return sum - max;
    }
    public int distance(int[]a, int[]b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
