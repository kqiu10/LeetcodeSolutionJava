package HashMap;
/**
 * Package Name : HashMap;
 * File name : _290_WordPattern;
 * Creator: Kane;
 * Date: 9/2/20
 */

import java.util.HashMap;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and
 * a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 *
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _290_WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] string = str.split(" ");
        if (pattern.length() != string.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < string.length; i ++) {
            char a = pattern.charAt(i);
            String b = string[i];
            if (map.containsKey(a)) {
                if (!b.equals(map.get(a))) {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                }
                map.put(a, b);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        wordPattern("abba", "dog dog dog dog");
    }
}
