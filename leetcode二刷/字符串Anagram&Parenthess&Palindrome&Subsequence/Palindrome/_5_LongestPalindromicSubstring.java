package Palindrome;
/**
 * Package Name : Palindrome;
 * File name : _5_LongestPalindromicSubstring;
 * Creator: Kane;
 * Date: 9/6/20
 */

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _5_LongestPalindromicSubstring {
    String res = "";
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            //odd length
            helper(s, i, i);
            //even length
            helper(s, i, i + 1);
        }
        return res;
    }
    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) { res = cur;}
    }
}
/**
 * Time complexity:O(n^2);
 * Space complexity: O(n^2);
 * Description: DP
 * if (j - i) <= 2 as j - 1 <= i - 1, we dont need to go further since there are only one number.
 * otherwise we calculate dp[i + 1][j - 1].f
 */
class _5_LongestPalindromicSubstringII{
    public static String longestPalindrome(String s) {
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

    public static void main(String[] args) {
        longestPalindrome("abba");
    }
}