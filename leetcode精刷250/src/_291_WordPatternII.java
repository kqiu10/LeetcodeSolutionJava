package src; /**
 * Date: 11/30/20
 * Question Description
 Given a pattern and a string s, return true if s matches the pattern.

 A string s matches a pattern if there is some bijective mapping of single characters to strings such that if each character in pattern is replaced by the string it maps to, then the resulting string is s. A bijective mapping means that no two characters map to the same string, and no character maps to two different strings.



 Example 1:

 Input: pattern = "abab", s = "redblueredblue"
 Output: true
 Explanation: One possible mapping is as follows:
 'a' -> "red"
 'b' -> "blue"

 Example 2:
 Input: pattern = "aaaa", s = "asdasdasdasd"
 Output: true
 Explanation: One possible mapping is as follows:
 'a' -> "asd"
 Example 3:

 Input: pattern = "abab", s = "asdasdasdasd"
 Output: true
 Explanation: One possible mapping is as follows:
 'a' -> "a"
 'b' -> "sdasd"
 Note that 'a' and 'b' cannot both map to "asd" since the mapping is a bijection.
 Example 4:

 Input: pattern = "aabb", s = "xyzabcxzyabc"
 Output: false
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * Description: TODO
 * Time complexity:O(2^n);
 * Space complexity: O(n);

 */
public class _291_WordPatternII {

    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return isMatch(pattern, 0, s, 0, map, set);

    }

    private boolean isMatch(String pattern, int i, String s, int j, HashMap<Character, String> map, HashSet<String> set) {
        if (i == pattern.length() && j == s.length()) return true;
        if (i == pattern.length() || j == s.length()) return false;

        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            String str = map.get(c);
            if (!s.startsWith(str, j)) {
                return false;
            }
            return isMatch(pattern, i + 1, s, j + str.length(), map, set);
        }
        for (int k = j; k < s.length(); k++) {
            String p = s.substring(j, k + 1);
            if (set.contains(p)) {
                continue;
            }
            set.add(p);
            map.put(c, p);
            if (isMatch(pattern, i + 1, s, k + 1, map, set)) {
                return true;
            }
            set.remove(p);
            map.remove(c);
        }
        return false;
    }
}
