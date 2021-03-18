/**
 * Date: 3/18/21
 * Question Description:
 * Given an integer n, return the number of
 * structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * <p>
 * Examples:
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: 5
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 */

/**
 * Description:
 EX   n = 3
 1         3     3      2      1
 \       /     /       / \      \
 3      2     1      1   3      2
 /     /       \                  \
 2     1         2                 3

 root : 1 left : 0, right : 2, f(0) * f(2);
 root : 2 left : 1, right : 1, f(1) * f(1);
 root : 3 left : 2, right : 0, f(2) * f(0);
 f(n) = f(0) * f(n - 1) + f(1) * f(n - 2) + ... + f(n - 2) * f(1) + f(n - 1) * f(0)

 * Time complexity:O(n);
 * Space complexity: O(n);
 */
public class _96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
