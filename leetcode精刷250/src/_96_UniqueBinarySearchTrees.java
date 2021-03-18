package src; /**
 * Date: 11/11/20
 * Question Description
 Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 Example:
 Input: 3
 Output: 5
 Explanation:
 Given n = 3, there are a total of 5 unique BST's:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
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
                //dp[j] 左子树个数  dp[i - j - 1] 右子树个数
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
