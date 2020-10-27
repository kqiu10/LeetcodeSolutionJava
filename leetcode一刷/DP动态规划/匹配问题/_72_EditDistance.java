package DP动态规划.匹配问题;
/**
 * Date: 10/24/20
 * Question Description
 Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character
 Example 1:

 Input: word1 = "horse", word2 = "ros"
 Output: 3
 Explanation:
 horse -> rorse (replace 'h' with 'r')
 rorse -> rose (remove 'r')
 rose -> ros (remove 'e')
 Example 2:
 Input: word1 = "intention", word2 = "execution"
 Output: 5
 Explanation:
 intention -> inention (remove 't')
 inention -> enention (replace 'i' with 'e')
 enention -> exention (replace 'n' with 'x')
 exention -> exection (replace 'n' with 'c')
 exection -> execution (insert 'u')
 */

/**
 * Description:
 dp[i][j]表示的是从字符串1的i位置到字符串2的j位置，所需要的最少步数
 1.字符串中的字符相等 dp[i][j] = dp[i - 1][j - 1]
 2.字符串中的字符不等
    insert : dp[i][j] = dp[i][j - 1]
    replace : dp[i][j] = dp[i - 1][j - 1] + 1;
    delete : dp[i][j] = dp[i - 1][j] + 1;

        a   b   c   d
    0   1   2   3   4
 a  1
 e  2
 f  3
 * Time complexity:O(m * n);
 * Space complexity: O(m * n);

 */
public class _72_EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
