/**
 * Date: 11/2/20
 * Question Description
 Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:

 '.' Matches any single character.​​​​
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Example 1:

 Input: s = "aa", p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input: s = "aa", p = "a*"
 Output: true
 Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 Example 3:

 Input: s = "ab", p = ".*"
 Output: true
 Explanation: ".*" means "zero or more (*) of any character (.)".
 Example 4:

 Input: s = "aab", p = "c*a*b"
 Output: true
 Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 Example 5:

 Input: s = "mississippi", p = "mis*is*p*."
 Output: false
 */

/**
 * Description:
 * DP
 * boolean dp[i][j] 含义是s[0 - i] 与p[0 - j]是否匹配
 * 1.IF s.charAt(i) == p.charAt(j) : dp[i][j] = dp[i - 1][j - 1];
 * 2.If p.charAt(j) == '.' :dp[i][j] = dp[i - 1][j - 1];
 * 3.If p.charAt(j) == '*' :
 *    two sub conditions:
 *    1.if p.charAt(j - 1) != s.charAt(i) : dp[i][j] = dp[i][j - 2] // a* counts as empty;
 *    2.if p.charAt(j - 1) == s.charAt(i) or p.charAt(j - 1) == '.';
 *          dp[i][j] = dp[i][j - 1] // a* counts as single a ;
 *          dp[i][j] = dp[i - 1][j] // a* counts as multiple a;
 *          dp[i][j] = dp[i][j - 2] // a* counts as empty
 * * Time complexity:O(m * n);
 * Space complexity: O(m * n);

 */
public class _10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //case: s = "", p = "c*"
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                //case: s.charAt(i) == p.charAt(j) : dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                //case: p.charAt(j) == '.' :dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    //case: p.charAt(j - 1) != s.charAt(i) : dp[i][j] = dp[i][j - 2]
                    // a* counts as empty;
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
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
