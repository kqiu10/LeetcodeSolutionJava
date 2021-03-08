/**
 * Date: 3/8/21
 * Question Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int oneStep = 1;
        int secondStep = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = oneStep + secondStep;
            secondStep = oneStep;
            oneStep = res;
        }
        return res;

    }

}
