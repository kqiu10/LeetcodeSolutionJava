/**
 * Date: 3/13/21
 * Question Description:
 * Given two strings s and t, return the minimum window in s which will contain all the
 * characters in t. If there is no such window in s that covers all characters in t, return the
 * empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one
 * unique minimum window in s.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int needed = t.length();
        int from = 0;
        int min = Integer.MAX_VALUE;
        int[] chs = new int[128];
        for (char c : t.toCharArray()) {
            chs[c]++;
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (chs[s.charAt(i)]-- > 0) {
                needed--;
            }
            while (needed == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++chs[s.charAt(j++)] > 0) {
                    needed++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(from, from + min);
    }
}
