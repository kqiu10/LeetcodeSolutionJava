package String字符串.base基础;
/**
 * Package Name : String字符串.base基础;
 * File name : _161_OneEditDistance;
 * Creator: Kane;
 * Date: 8/28/20
 */

/**
 * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.
 A string s is said to be one distance apart from string t if you can:
 Insert exactky one character into s to get t.
 Delete exactly one character from s to get t.
 Replace exactly one character of s with a different character to get t.
 Example 1:
 Input: s = "ab", t = "acb"
 Output: true
 Explanation: We can insert 'c' into s to get t.
 Example 2:
 Input: s = "", t = ""
 Output: false
 Explanation: We cannot get t from s by only one step.
 Example 3:
 Input: s = "a", t = ""
 Output: true
 Example 4:
 Input: s = "", t = "A"
 Output: true
 *
 * Time complexity:O(n); because we return string.equals another string so we don't tak n^2 time complexity;
 * Space complexity: O(n);
 * Description:
 * three cases:
 * abcre abere
 * abdc abc
 * abc abdc
 *
 * corner case: abc abcdef
 */
public class _161_OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1 ? true : false;

    }
}
