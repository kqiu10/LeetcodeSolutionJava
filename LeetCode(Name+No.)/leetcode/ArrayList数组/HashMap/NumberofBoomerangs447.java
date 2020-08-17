package 数组.HashMap;
/**
 * Package Name : 数组.HashMap;
 * File name : NumberofBoomerangs447;
 * Creator: Kane;
 * Date: 8/7/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description: TODO
 */
public class NumberofBoomerangs447 {
    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int path = distance(points[i], points[j]);
                map.put(path, map.getOrDefault(path, 0) + 1);

            }
            for (int val : map.values()) {
                //because we need to consider the order of the tuple, so we need to do permutations A (2, n);
                res += val * (val - 1);
            }
            map.clear();
        }
        return res;
    }
    public static int distance(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return (int) (Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        numberOfBoomerangs(test);
    }
}
