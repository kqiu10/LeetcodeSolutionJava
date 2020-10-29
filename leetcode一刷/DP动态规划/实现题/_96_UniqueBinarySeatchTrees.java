package DP动态规划.实现题;
/**
 * Date: 10/28/20
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
 f(n) = f(0) * f(n - 1) + f(1) * f(n - 2) + ... + f(n - 2) * f(1) + f(n - 1) * f(0)
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _96_UniqueBinarySeatchTrees {
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j < i; j++) {
                //res[j] : 左孩子 res[i - j - 1] : 右孩子
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];

    }
}
