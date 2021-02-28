/**
 * Date: 2/28/21
 * Question Description:
 * Given a pattern and a string s, return true if s matches the pattern.
 *
 * A string s matches a pattern if there is some bijective mapping of single characters to
 * strings such that if each character in pattern is replaced by the string it maps to, then the
 * resulting string is s. A bijective mapping means that no two characters map to the same
 * string, and no character maps to two different strings.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: pattern = "abab", s = "redblueredblue"
 * Output: true
 * Explanation: One possible mapping is as follows:
 * 'a' -> "red"
 * 'b' -> "blue"
 * Example 2:
 *
 * Input: pattern = "aaaa", s = "asdasdasdasd"
 * Output: true
 * Explanation: One possible mapping is as follows:
 * 'a' -> "asd"
 * Example 3:
 *
 * Input: pattern = "abab", s = "asdasdasdasd"
 * Output: true
 * Explanation: One possible mapping is as follows:
 * 'a' -> "a"
 * 'b' -> "sdasd"
 * Note that 'a' and 'b' cannot both map to "asd" since the mapping is a bijection.
 * Example 4:
 *
 * Input: pattern = "aabb", s = "xyzabcxzyabc"
 * Output: false
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n:length of pattern)
 */
public class _291_WordPatternII {
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return isValid(pattern, 0, s, 0, map, set);
    }
    private boolean isValid(String pattern, int i, String s, int j, HashMap<Character, String> map, HashSet<String> set) {
        if (i == pattern.length() && j == s.length()) return true;
        if (i == pattern.length() || j == s.length()) return false;

        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            String pre = map.get(c);
            if (!s.startsWith(pre, j)) {
                return false;
            }
            return isValid(pattern, i + 1, s, j + pre.length(), map, set);
        }

        for (int k = j; k < s.length(); k++) {
            String cur = s.substring(j, k + 1);
            if (set.contains(cur)) {
                continue;
            }
            map.put(c, cur);
            set.add(cur);
            if (isValid(pattern, i + 1, s, k + 1, map, set)) {
                return true;
            }
            map.remove(c);
            set.remove(cur);
        }
        return false;
    }
}
