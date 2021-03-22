/**
 * Date: 3/21/21
 * Question Description:
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can
 * be none) of the characters without disturbing the remaining characters' relative positions. (i
 * .e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It is guaranteed the answer fits on a 32-bit signed integer.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * rabbbit
 * rabbbit
 * rabbbit
 * Example 2:
 *
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 */

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class _115_DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i -1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
