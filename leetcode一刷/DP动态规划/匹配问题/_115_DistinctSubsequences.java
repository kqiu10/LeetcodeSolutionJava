package DP动态规划.匹配问题;
/**
 * Date: 10/24/20
 * Question Description
 Given a string S and a string T, count the number of distinct subsequences of S which equals T.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 It's guaranteed the answer fits on a 32-bit signed integer.

 Example 1:

 Input: S = "rabbbit", T = "rabbit"
 Output: 3
 Explanation:
 As shown below, there are 3 ways you can generate "rabbit" from S.
 (The caret symbol ^ means the chosen letters)

 rabbbit
 ^^^^ ^^
 rabbbit
 ^^ ^^^^
 rabbbit
 ^^^ ^^^
 Example 2:
 Input: S = "babgbag", T = "bag"
 Output: 5
 Explanation:
 As shown below, there are 5 ways you can generate "bag" from S.
 (The caret symbol ^ means the chosen letters)
 babgbag
 ^^ ^
 babgbag
 ^^    ^
 babgbag
 ^    ^^
 babgbag
 ^  ^^
 babgbag
 ^^^
 */

/**
 * Description:
 int[][] dp

 1.S.charAt(i) != T.charAt(j)
    dp[i][j] = dp[i - 1][j]
 2.S.charAt(i) == T.charAt(j)
    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
    T: r a b b i t
 S
    1  0 0 0 0 0 0
 r  1  1 0 0 0 0 0
 a  1  1 1 0 0 0 0
 b  1  1 1 1 0 0 0
 b  1  1 1 2 1 0 0
 b  1  1 1 3 3 0 0
 i  1  1 1 3 3 3 0
 t  1  1 1 3 3 3 3
 * Time complexity:O(m * n);
 * Space complexity: O(m * n);

 */
public class _115_DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
}
