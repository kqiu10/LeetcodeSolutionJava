package String字符串.实现题;
/**
 * Package Name : String字符串.basic基础_实现;
 * File name : _459_RepeatedSubstringPattern;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and
 * appending multiple copies of the substring together. You may assume the given string consists
 * of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _459_RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i>= 1; i--) {
            if (len % i == 0) {
                int set = len / i;
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < set; j++) {
                    sb.append(sub);
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        repeatedSubstringPattern("aba");
    }
}

/**
 *
 * Time complexity:O(m * n);
 * Space complexity: O(n);
 * Description:
 * Ex s = "abab"
 * str = "abababab"
 * str.substring(1, str.length() - 1) = "bababa"
 */
class RepeatedSubstringPatternII {
    public static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(str);
    }

}