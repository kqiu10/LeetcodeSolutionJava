/**
 * Date: 2/16/21
 * Question Description
 * Given a string s, return the longest palindromic substring in s.
 * Examples:
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 */


public class _5_LongestPalindromicSubstring {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * 中间向两边推进法
     */
    String str = "";
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return str;
    }

    private void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;

        }
        if (right - left - 1 > str.length()) {
            str = s.substring(left, right + 1);
        }
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     * DP
     */
    public String longestPalindromeDP (String s) {
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((i - j) <= 2 || dp[i - 1][j + 1]);
                if (dp[i][j]) {
                    if (i - j + 1 > res.length()) {
                        res = s.substring(j, i + 1);
                    }
                }
            }
        }
        return res;
    }
}
