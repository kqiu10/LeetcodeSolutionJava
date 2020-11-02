/**
 * Date: 11/2/20
 * Question Description
 Given a string s, return the longest palindromic substring in s.
 Example 1:

 Input: s = "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: s = "cbbd"
 Output: "bb"
 Example 3:

 Input: s = "a"
 Output: "a"
 Example 4:

 Input: s = "ac"
 Output: "a"
 */


public class _5_LongestPalindromicSubstring {
    /**
     * Description: Recursion
     * Time complexity:O(n^2);
     * Space complexity: O(1);
     */
    String res = "";
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }
    private void helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (r - l - 1 > res.length()) {
            res = s.substring(l + 1, r);
        }
    }
    /**
     * Description: DP
     * Time complexity:O(n^2);
     * Space complexity: O(n^2);
     */
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i) <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
