/**
 * Package Name : PACKAGE_NAME;
 * File name : _70_ClimingStairs;
 * Creator: Kane;
 * Date: 9/11/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: Fibonacci Solution
 */
public class _70_ClimbingStair {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
