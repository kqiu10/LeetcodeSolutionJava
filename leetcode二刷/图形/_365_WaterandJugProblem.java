package 图形;
/**
 * Package Name : 图形;
 * File name : _365_WaterandJugProblem;
 * Creator: Kane;
 * Date: 9/9/20
 */

/**
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water
 * supply available. You need to determine whether it is possible to measure exactly z litres
 * using these two jugs.
 *
 * If z liters of water is measurable, you must have z liters of water contained within one or
 * both buckets by the end.
 *
 * Operations allowed:
 *
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug
 * itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 *
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 *
 * Input: x = 2, y = 6, z = 5
 * Output: False
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:

 * 3 * -2 + 5 * 2 = 4
 * + : 装水
 * - : 倒水
 *
 * x * m + y * n = z
 * 贝祖定理
 * z = gcd(x, y) * i
 */
public class _365_WaterandJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;
        int gcd =gcd(x, y);
        return z % gcd == 0;
    }
    private int gcd (int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
