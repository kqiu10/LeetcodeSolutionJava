package DP动态规划.匹配问题;
/**
 * Date: 10/23/20
 * Question Description
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given a non-empty string containing only digits, determine the total number of ways to decode it.

 The answer is guaranteed to fit in a 32-bit integer.

 Example 1:
 Input: s = "12"
 Output: 2
 Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 Example 2:

 Input: s = "226"
 Output: 3
 Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 Example 3:

 Input: s = "0"
 Output: 0
 Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we face it while decoding. So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.
 Example 4:

 Input: s = "1"
 Output: 1
 */


public class _91_DecodeWays {
    /**
     * Description:
      0123
     "1231" ：
     i = 2:
     first = 2     second = 12
     dp[0] = 1  dp[1] = 1   dp[2] = 1 + 1 = 2

     i = 3:
     first = 3     second = 23
     dp[3] = 2 + 1 = 3

     i = 4
     first = 1 second = 31
     dp[4] = 3

     * Time complexity:O(n);
     * Space complexity: O(n);
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= len; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];

    }
    /**
     * Description:
     0123
     "1231"
     c2c1


     * Time complexity:O(n);
     * Space complexity: O(1);
     */
    public int numDecodingsII(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int c1 = 1;
        int c2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c1 = 0;
            }
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                c1 = c1 + c2;
                c2 = c1 - c2;
            } else {
                c2 = c1;
            }
        }
        return c1;
    }
}
