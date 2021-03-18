package src; /**
 * Date: 11/16/20
 * Question Description
 Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

 Example 1:

 Input: [[1,1],[2,2],[3,3]]
 Output: 3
 Explanation:
 ^
 |
 |        o
 |     o
 |  o
 +------------->
 0  1  2  3  4
 Example 2:

 Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 Output: 4
 Explanation:
 ^
 |
 |  o
 |     o        o
 |        o
 |  o        o
 +------------------->
 0  1  2  3  4  5  6
 */

import java.util.HashMap;

/**
 * Description: TODO
 * Time complexity:O(n ^ 2);
 * Space complexity: O(n);

 */
public class _149_MaxPointsonaLine {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length < 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameXAxis = 1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        samePoint++;
                    }
                    if (points[i][0] == points[j][0]) {
                        sameXAxis++;
                        continue;
                    }
                    int numerator = points[i][1] - points[j][1];
                    int denominator = points[i][0] - points[j][0];
                    int gcd = gcd(numerator, denominator);
                    String Str = numerator / gcd + "/" + denominator / gcd;
                    map.put(Str, map.getOrDefault(Str, 1) + 1);
                    res = Math.max(res, map.get(Str) + samePoint);
                }
            }
            res = Math.max(res, sameXAxis);
        }
        return res;
    }
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd (b % a, a);
    }
}
