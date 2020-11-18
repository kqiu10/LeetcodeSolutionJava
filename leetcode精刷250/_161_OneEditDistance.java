/**
 * Date: 11/18/20
 * Question Description
 Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

 A string s is said to be one distance apart from a string t if you can:

 Insert exactly one character into s to get t.
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
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _161_OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i+ 1).equals(t.substring(i + 1));
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
