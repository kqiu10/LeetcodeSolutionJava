/**
 * Date: 3/3/21
 * Question Description:
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support
 * for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the
 * substring "dce".
 * Example 5:
 *
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 */

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class _44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //case: s = "", p = "c*"
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        //case: s.charAt(i) == p.charAt(j) : dp[i][j] = dp[i - 1][j - 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                //case: p.charAt(j) == '?' :dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '?') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        //case:  dp[i][j] = dp[i][j - 1] // a* counts as single a ;
                        //       dp[i][j] = dp[i - 1][j] // a* counts as multiple a;
                        //       dp[i][j] = dp[i][j - 2] // a* counts as empty
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }

            }
        }
       return dp[s.length()][p.length()];
    }
}
