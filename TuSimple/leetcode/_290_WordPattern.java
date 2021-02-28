/**
 * Date: 2/28/21
 * Question Description:
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and
 * a non-empty word in s.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", s = "dog dog dog dog"
 * Output: false
 */

import java.util.HashMap;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] chars = s.split("\\s+");
        if (pattern.length() != chars.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!chars[i].equals(map.get(c))) {
                    return false;
                }
            } else {
                if (map.containsValue(chars[i])) {
                    return false;
                }
                map.put(c, chars[i]);
            }
        }
        return true;
    }
}
