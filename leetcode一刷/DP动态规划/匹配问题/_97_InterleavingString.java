package DP动态规划.匹配问题;
/**
 * Date: 10/24/20
 * Question Description
 Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

 An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

 s = s1 + s2 + ... + sn
 t = t1 + t2 + ... + tm
 |n - m| <= 1
 The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 Note: a + b is the concatenation of strings a and b.
 Example 1:
 Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 Output: true
 Example 2:

 Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 Output: false
 Example 3:

 Input: s1 = "", s2 = "", s3 = ""
 Output: true
 */

/**
 * Description:
 Ex s1 = "aabcc"
    s2 = "dbbca"
    s3 = "aadbbcbcac"
 [t, t, t, f, f, f]
 [f, f, t, t, f, f]
 [f, f, t, t, t, f]
 [f, f, t, f, t, t]
 [f, f, t, t, t, f]
 [f, f, f, f, t, t]


 * Time complexity:O(m * n);
 * Space complexity: O(m * n);

 */
public class _97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = s2.charAt(i - 1) == s3.charAt(i + j - 1) || s1.charAt(j - 1) ==  s3.charAt(i + j - 1);
            }
        }
        return dp[s2.length()][s1.length()];
    }
}
